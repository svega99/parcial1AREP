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
 * Servidor que devuelve JSON con una lista ordenada y su sumatoria
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
    /**
     * Pagina de input 
     * @param req Request de la página
     * @param res Response de la página
     * @return HTML con la pagina 
     */
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
     /**
      * Función que devuelve el objeto JSON  
      * 
      * @param req Request de la página
      * @param res Response de la página
      * @return 
      */
    private static JSONObject resultsPage(Request req, Response res) {
        List<Integer> lista=new ArrayList<>();
        String[] listaNormal= req.queryParams("numbers").split(",");
      
        
        for (String i: listaNormal){
           
             lista.add(Integer.parseInt(i));
      
        }
        res.header("Content-Type","application/json");
        
        Operations op = new OperationsImpl();
        List<Integer> ordenada = op.mergeSort(lista);
        Integer n = op.sumatoria(lista);

        JSONObject myObject = new JSONObject();
        myObject.put("SortList", ordenada);
        myObject.put("Sum", n);
        
        return myObject;
    }
    
    /**
     * Devuelve el puerto 
     * @return el puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }        
           
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
    }
}
