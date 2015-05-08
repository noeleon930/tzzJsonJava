/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static spark.Spark.*;

/**
 *
 * @author Noel
 */
public class TzzJsonJava
{

    public static class stockSet
    {

        private final int id;
        private final String name;

        stockSet(String name, int id)
        {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        //Set port
        port(168);

        //Set public resources
        String workingDir = System.getProperty("user.dir");
        externalStaticFileLocation(workingDir + File.separator + "public_html");

        //Loading methods and data
        splitString splitter = new splitString();
        final List<stockField> stockList = new fromTzzData().makeStockObjectList();

        //Home
        get("/home", (req, res) -> "Hello Tzz!");

        //Demo Home
        get("/demo/home", (req, res) ->
        {
            res.redirect("/static/DemoHome.tzzissocool");
            return null;
        });

        //Filter before Demo (for its csss or jss)
        get("/demo/id/:theId", (req, res) ->
        {
            //Checking if this is from template
            String test = req.params(":theId");
            if (test.matches("[0-9]+"))
            {
                return new timeSeriesData().makeTimeSeriesHTML(test);
            }
            else
            {
                //Hacking this shit for 1 hour >w<
                res.redirect("/static/" + test);
                return null;
            }
        });

        //tzzServerGenerate.js
        get("/tzzServerGenerate.js", "application/javascript", (req, res) -> new timeSeriesData().makeTimeSeriesJS());

        //Split simple test
        get("/split", (req, res) ->
        {
            List<String> a = splitter.nsplit("helloooo, madartfarkers, yo!,,,,,,", ",");

            a.forEach(System.out::println);

            return Arrays.toString(a.toArray());
        });

        //Split eat param test
        get("/split/:string", (req, res) ->
        {
            String target = URLDecoder.decode(req.params(":string"), "UTF-8");

            List<String> a = splitter.nsplit(target, ",");

            a.forEach(System.out::println);

            return Arrays.toString(a.toArray());
        });

        //For META query
        get("/stream/meta", "application/json", (req, res) ->
        {
            return new metaQuery().queryFor(req.queryMap().toMap(), req.queryParams(), stockList);
        });

        //For date query
        get("/stream/date/:theDate", "application/json", (req, res) ->
        {
            List<stockField> tmp = stockList
                    .parallelStream()
                    .filter(s -> s.equalDate(Integer.parseInt(req.params(":theDate"))))
                    .collect(Collectors.toList());

            return new Gson().toJson(tmp);
        });

        //For id query
        get("/stream/id/:theId", "application/json", (req, res) ->
        {
            List<stockField> tmp = stockList
                    .parallelStream()
                    .filter(s -> s.equalId(req.params(":theId")))
                    .collect(Collectors.toList());

            return new Gson().toJson(tmp);
        });

        //For name query
        get("/stream/name/:theName", "application/json", (req, res) ->
        {
            String target = URLDecoder.decode(req.params(":theName"), "UTF-8");

            List<stockField> tmp = stockList
                    .parallelStream()
                    .filter(s -> s.equalName(target))
                    .collect(Collectors.toList());

            return new Gson().toJson(tmp);
        });

        //Fot stock_set query (ask for name and id's collection)
        get("/stream/stock_set", "application/json", (req, res) ->
        {
            Map<String, String> tmp = stockList
                    .parallelStream()
                    .collect(Collectors.toMap(s -> s.getStock_name(), s -> s.getStock_id(), (oldValue, newValue) -> oldValue));

            List<stockSet> ttmp = new ArrayList<>();

            tmp.forEach((k, v) ->
            {
                ttmp.add(new stockSet(k, Integer.parseInt(v)));
            });

            return new Gson().toJson(ttmp);
        });
    }

}
