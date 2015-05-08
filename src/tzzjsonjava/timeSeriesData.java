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
                + "    <title>Tzz Chart Demo of ID:" + theId + "</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <div>\n"
                + "        <h2 id=\"bar\">Loading...</h2>\n"
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
                + "    <script>\n"
                + "        var chart_global;\n"
                + "        var chart_status = \"area\";\n"
                + "        var chart_id = " + theId + "\n"
                + "        var chart_average = false;\n"
                + "    </script>\n"
                + "    <script src=\"custom.js\"></script>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
    }

    public String makeTimeSeriesAverageHTML(String theId)
    {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Tzz Chart Demo of ID:" + theId + "</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <div>\n"
                + "        <h2 id=\"bar\">Loading...</h2>\n"
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
                + "    <script>\n"
                + "        var chart_global;\n"
                + "        var chart_status = \"area\";\n"
                + "        var chart_id = " + theId + ";\n"
                + "        var chart_average = true;\n"
                + "    </script>\n"
                + "    <script src=\"custom.js\"></script>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
    }
}
