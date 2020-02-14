/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.parcial.client;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author santiago.vega-r
 */
public class Client {
    
    
    
    public static void main(String[] args) throws IOException {
		
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		List<Integer>  numeros =new ArrayList<>();
		numeros.add(9);
		numeros.add(8);
		numeros.add(2);
		numeros.add(18);
		numeros.add(7);
		numeros.add(25);
		numeros.add(15);
		
		String query =  numeros.toString().replace("[", "").replace("]", "").replace(" ", "");
		
		URL herokuApp = new URL("https://agile-sea-56391.herokuapp.com/results?numbers="+query);
		
		URLConnection con = herokuApp.openConnection();
		
		in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		
		System.err.println("Conectado");
		BufferedReader stdIn = new BufferedReader(
		new InputStreamReader(System.in));
		String line;
        
		while ((line = in.readLine()) != null) { 
			System.out.println(line); 
		}
		
		in.close();
		stdIn.close();
		
	}
    
    
	
}
