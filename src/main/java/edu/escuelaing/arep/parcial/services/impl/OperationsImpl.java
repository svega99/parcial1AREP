/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.parcial.services.impl;

import edu.escuelaing.arep.parcial.services.Operations;
import java.util.ArrayList;
import java.util.List;

/**
 *Implementacion de la interfaz de operaciones 
 * @author santiago.vega-r
 */
public class OperationsImpl implements Operations{
	
    @Override
    public List<Integer> mergeSort(List<Integer> lista) {
        int[] lista2 = new int[lista.size()];
        for (int i = 0; i < lista2.length; i++) {
            lista2[i] = lista.get(i);
        }
        mergeSort(lista2,lista2.length);
        List<Integer> finall= new ArrayList<>();
         for (int i: lista2){
           
                finall.add(i);
         }
        return finall;
    }
    
    
    @Override
    public Integer sumatoria(List<Integer> lista) {
        int con =0;
        for (Integer i:lista){
            con+=i;
        }
        return con;
    }
    
    private static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
         merge(a, l, r, mid, n - mid);
        
    }
    
    private static void merge( int[] a, int[] l, int[] r, int left, int right) {
  
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

   
}
