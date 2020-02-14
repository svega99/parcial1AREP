/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.parcial.services;

import java.util.List;


/**
 *	Interfaz de operaciones	
 *
 * @author santiago.vega-r
 */
public interface Operations {
	
	/**
	 * Retorna la lista ordenada por merge 
	 * @param lista Lista a ordenar
	 * @return Lista ordenada
	 */
    public List<Integer> mergeSort(List <Integer> lista);
    
    
    /**
     * Retorna la sumatoria de la lista 
     * @param lista Lista a sumar
     * @return Sumatoria de la lista
     */
    public Integer sumatoria(List <Integer> lista);
}
