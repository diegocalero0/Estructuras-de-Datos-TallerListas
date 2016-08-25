/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDE;


import java.util.*;

/**
 *
 * @author Javier
 */
public class ListaDE<T> implements Collection<T>, Iterable<T>{

    private NodoDE<T> primero, ultimo;
    private int tamanio;
    
    public ListaDE()
    {
        this.tamanio=0;
        primero=null;
        ultimo=null;
    }
    @Override
    public int size() {
    	return tamanio;
    }

    @Override
    public boolean isEmpty() {
        return tamanio==0;
    }

    @Override
    public boolean contains(Object o) {
        NodoDE<T> aux=primero;
        
        while(aux!=null)
        {
            if(aux.getDato().equals(o))
            {
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new iterador(this);
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public T get(int indice) throws Exception
    {
        NodoDE<T> aux=primero;
        
        if(indice<=this.tamanio && indice>=0)
        {
            for(int i=0;i<=indice;i++)
            {
                if(i==indice)
                {
                    return aux.getDato();
                }
                else
                {
                    aux=aux.getSiguiente();
                }
            }
        }
        else
        {
            throw new Exception("indice fuera de rango");
        }
        return null;
    }
    
    
    @Override
    public boolean add(Object dato){
        NodoDE<T> nodo=new NodoDE<T>((T)dato);
        if(tamanio==0)
        {
            primero=ultimo=nodo;
            tamanio++;
        }
        else
        {
            ultimo.setSiguiente(nodo);
            nodo.setAnterior(ultimo);
            ultimo=nodo;
            tamanio++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {

        NodoDE<T> aux=primero;
        NodoDE<T> anterior=null;
        
        while(aux!=null)
        {
            if(aux.getDato().equals(o))
            {
                if(anterior==null)
                {
                    if(tamanio==1)
                    {
                        primero=null;
                        ultimo=null;
                    }else
                    {
                        aux.getSiguiente().setAnterior(null);
                        primero=aux.getSiguiente();
                        
                    }
                    aux=null;
                }
                else
                {
                    anterior.setSiguiente(aux.getSiguiente());
                    if(aux.getSiguiente()!=null)
                    {
                        aux.getSiguiente().setAnterior(anterior);
                    }else
                    {
                        ultimo=anterior;
                    }
                    aux=null;
                }
                
                tamanio--;
                return true;
            }
            else
            {
                anterior=aux;
                aux=aux.getSiguiente();
            }
            
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        
        this.primero=null;
        this.tamanio=0;
        
        return true;
        
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        String cadena="[";
        NodoDE<T> aux=primero;
        
        while(aux!=null)
        {
            cadena+=aux.getDato();
            aux=aux.getSiguiente();
        }
        cadena+="]";
        return cadena;
    }
    
    public NodoDE<T> copiar(NodoDE<T> primero)
    {
        ListaDE copia=new ListaDE();
        NodoDE<T> aux=primero;
        
        while(aux!=null)
        {
            copia.add(aux.getDato());
            aux=aux.getSiguiente();
        }
        return copia.primero;
    }

    public void add(int i,T o)throws Exception
    {
        
        
        if(i>=0&&i<=this.size())
        {
            
            NodoDE<T> aux=new NodoDE<T>(o);
        
            if(i==0)
            {
               aux.setSiguiente(primero);
               primero=aux;
               tamanio++;
            }else if(i==this.size())
            {
               ultimo.setSiguiente(aux);
               aux.setAnterior(ultimo);
               ultimo=aux;
               tamanio++;
            }else
            {
             int a=0;
             NodoDE<T> ret=primero;
             NodoDE<T> anterior=null;
             
             while(a<=i)
             {
                 if(a==i)
                 {
                     aux.setSiguiente(ret);
                     aux.setAnterior(anterior);
                     anterior.setSiguiente(aux);
                     ret.setAnterior(aux);
                     tamanio++;
                 }else
                 {
                     anterior=ret;
                     ret=ret.getSiguiente();
                 }
                 a++;
             }
            }
            
        }else
        {
            throw new Exception("indice fuera de rango");
        }
    }
    
    
    public NodoDE<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDE<T> primero) {
        this.primero = primero;
    }
    
    
    
    
}
