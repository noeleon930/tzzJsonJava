/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Noel
 */
public class fromTzzData
{

    public List<stockField> makeStockObjectList() throws IOException
    {
        //Loading file and make it to stream
        Path hugeFilePath = FileSystems.getDefault().getPath("C:\\k_normal.txt");
        Stream<String> lines = Files.lines(hugeFilePath, StandardCharsets.UTF_8);

        //Declare splitter
        final splitString splitter = new splitString();

        //Return processed list
        return lines.parallel()
                .map(s ->
                        {
                            List<String> a = splitter.nsplit(s, ";");

                            String id = a.get(0);
                            String name = a.get(1);
                            int date = Integer.parseInt(a.get(2));
                            float open = Float.parseFloat("-".equals(a.get(3)) ? "0" : a.get(3));
                            float high = Float.parseFloat("-".equals(a.get(4)) ? "0" : a.get(4));
                            float low = Float.parseFloat("-".equals(a.get(5)) ? "0" : a.get(5));
                            float close = Float.parseFloat("-".equals(a.get(6)) ? "0" : a.get(6));

                            return new stockField(id, name, date, open, high, low, close);
                })
                .collect(Collectors.toList());

    }

}
