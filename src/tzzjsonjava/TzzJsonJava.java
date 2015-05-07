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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static spark.Spark.*;

/**
 *
 * @author Noel
 */
public class TzzJsonJava
{

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
        System.out.println(workingDir);
        externalStaticFileLocation(workingDir + File.separator + "public_html");

        //Loading methods
        splitString splitter = new splitString();
        List<stockField> stockList = new fromTzzData().makeStockObjectList();

        //Home
        get("/", (req, res) -> "Hello Tzz!");

        //Template Test
        get("/html", (req, res) ->
        {
            res.type("text/html");
            return new htmlRender().index();
        });

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
    }

}
