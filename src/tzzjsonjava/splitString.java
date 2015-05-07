/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import spark.utils.StringUtils;

/**
 *
 * @author Noel
 */
public class splitString
{

    public List<String> nsplit(String line, String splitChar)
    {
        //Replace space char to empty
        line = StringUtils.replace(line, " ", "");

        StringTokenizer st = new StringTokenizer(line, splitChar);
        List<String> list = new ArrayList<>();

        //Adding splitted string to list
        while (st.hasMoreTokens())
        {
            list.add(st.nextToken());
        }

        return list;
    }
}
