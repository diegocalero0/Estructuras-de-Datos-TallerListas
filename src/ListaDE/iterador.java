/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDE;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
public class iterador<T> implements Iterator{

    private ListaDE <T> lista;
    private int indice;
    
    public iterador(ListaDE lista)
    {
        this.lista=lista;
        indice=0;
    }
    
    
    @Override
    public boolean hasNext() {
       if(indice<lista.size()){
    	   return true;
       }else{
    	   return false;
       }
    }

    @Override
    public Object next() {

        Object o=null;
        if(lista.size()>0)
        {
            try {
                o=lista.get(indice);
            } catch (Exception ex) {
                System.out.println("indice incorrecto");
            }
         indice++;
        }
        return o;
    }
    
}
