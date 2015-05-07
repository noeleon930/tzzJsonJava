/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import static spark.Spark.*;

/**
 *
 * @author Noel
 */
public class TzzJsonJava
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        port(168);
        get("/", (req, res) -> "Hello World");
    }

}
