/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Noel
 */
public class metaQuery
{

    public String queryFor(Map<String, String[]> qmap, Set<String> qset, List<stockField> slist)
    {
        List<Predicate<stockField>> filters = new ArrayList<>();

        for (String s : qset)
        {
            switch (s)
            {
                case "id":
                    //forId = true;
                    filters.add(stf -> stf.getStock_id().equals(qmap.get("id")[0]));
                    break;
                case "name":
                    //forName = true;
                    filters.add(stf -> stf.getStock_name().equals(qmap.get("name")[0]));
                    break;
                case "pht":
                    //forPointHigherThan = true;
                    filters.add(stf -> stf.getPoint_average() >= Float.parseFloat(qmap.get("pht")[0]));
                    break;
                case "plt":
                    //forPointLowerThan = true;
                    filters.add(stf -> stf.getPoint_average() <= Float.parseFloat(qmap.get("plt")[0]));
                    break;
                case "date":
                    //forDateOn = true;
                    filters.add(stf -> stf.getStock_date() == Integer.parseInt(qmap.get("date")[0]));
                    break;
                case "dbtwn":
                    //forDatesBetween = true;
                    filters.add(stf -> stf.getStock_date() >= Integer.parseInt(qmap.get("dbtwn")[0].split(",")[0]) && stf.getStock_date() <= Integer.parseInt(qmap.get("dbtwn")[0].split(",")[1]));
                    break;
                case "pbtwn":
                    //forPointsBetween = true;
                    filters.add(stf -> stf.getPoint_average() >= Float.parseFloat(qmap.get("pbtwn")[0].split(",")[0]) && stf.getPoint_average() <= Float.parseFloat(qmap.get("pbtwn")[0].split(",")[1]));
                    break;
                default:
                    return "Error in query paramater";
            }
        }

        Predicate<stockField> compositeFilter = filters
                .parallelStream()
                .reduce(f -> true, Predicate::and);

        List<stockField> tmplist = slist
                .parallelStream()
                .filter(compositeFilter)
                .collect(Collectors.toList());

        return new Gson().toJson(tmplist);

    }
}
