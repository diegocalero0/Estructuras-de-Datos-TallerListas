/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDE;

/**
 *
 * @author Javier
 */
public class NodoDE<T> {
    
    private NodoDE<T> anterior,siguiente;
    private T dato;
    
    public NodoDE(T dato)
    {
        this.dato=dato;
    }

    public NodoDE<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
}
