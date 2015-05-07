/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

/**
 *
 * @author Noel
 */
public class timeSeriesData
{

    public String makeTimeSeriesJS()
    {
        return "";
    }

    public String makeTimeSeriesHTML(String theId)
    {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Tzz Chart Demo</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <div>\n"
                + "        <h2 id=\"bar\"> </h2>\n"
                + "    </div>\n"
                + "    <div id=\"chart\">\n"
                + "    </div>\n"
                + "\n"
                + "    <!-- Load c3.css -->\n"
                + "    <link href=\"c3.min.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                + "\n"
                + "    <!-- Load d3.js and c3.js -->\n"
                + "    <script src=\"d3.min.js\" charset=\"utf-8\"></script>\n"
                + "    <script src=\"c3.min.js\"></script>\n"
                + "\n"
                + "    <!-- Load jquery and do custom things in it -->\n"
                + "    <script src=\"jquery.min.js\"></script>\n"
                + "    <!-- <script src=\"tzzServerGenerate.js\"></script> -->\n"
                + "    <!-- <script src=\"custom.js\"></script> -->\n"
                + "    <script>\n"
                + "        var chart_global;\n"
                + "        var chart_status = \"area\";\n"
                + "\n"
                + "        $.getJSON(\"/stream/id/" + theId + "\", function(jsonData) {\n"
                + "            var chart = c3.generate({\n"
                + "                bindto: '#chart',\n"
                + "                data: {\n"
                + "                    json: jsonData,\n"
                + "                    keys: {\n"
                + "                        x: 'stock_dateStr',\n"
                + "                        value: ['point_open', 'point_high', 'point_low', 'point_close'],\n"
                + "                    },\n"
                + "                    xFormat: '%Y%m%d',\n"
                + "                    type: 'line'\n"
                + "                },\n"
                + "                point: {\n"
                + "                    show: false\n"
                + "                },\n"
                + "                zoom: {\n"
                + "                    enabled: true\n"
                + "                },\n"
                + "                axis: {\n"
                + "                    x: {\n"
                + "                        type: 'timeseries',\n"
                + "                        tick: {\n"
                + "                            fit: true,\n"
                + "                            count: 50,\n"
                + "                            culling: {\n"
                + "                                max: 50\n"
                + "                            },\n"
                + "                            rotate: 80,\n"
                + "                            format: '%Y%m%d'\n"
                + "                        }\n"
                + "                    }\n"
                + "                }\n"
                + "            });\n"
                + "\n"
                + "            chart_global = chart;\n"
                + "        });\n"
                + "    </script>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
    }
}
