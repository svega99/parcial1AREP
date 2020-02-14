/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.parcial.server;
import edu.escuelaing.arep.parcial.services.Operations;
import edu.escuelaing.arep.parcial.services.impl.OperationsImpl;
import java.util.ArrayList;
import java.util.List;
import spark.*;
import static spark.Spark.*;
import org.json.*;

/**
 *
 * @author santiago.vega-r
 */
public class server {
    
    public static void main( String[] args )
    {
        port(getPort());
          
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
   
    }
    
     private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Parcial 1</h2>"
                + "<form action=\"/results\">"
                + "  Ingrese n numeros separados por comas<br>"
                + "  <input type=\"text\" name=\"numbers\" >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        List<Integer> lista=new ArrayList<>();
        String[] listaNormal= req.queryParams("numbers").split(",");
        String pageContent;
        
        for (String i: listaNormal){
            try {
                lista.add(Integer.parseInt(i));
            }
            catch (NumberFormatException n){
                pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Format Incorrect</h2>"
                + "</body>"
                + "</html>";
            }
      
        }
        
        
        Operations op = new OperationsImpl();
        List<Integer> ordenada = op.mergeSort(lista);
        

        JSONObject myObject = new JSONObject();
        myObject.put("number_list", ordenada);
        
        pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + myObject
                + "</body>"
                + "</html>";
        
        return pageContent;
    }
    
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }        
           
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
    }
}
