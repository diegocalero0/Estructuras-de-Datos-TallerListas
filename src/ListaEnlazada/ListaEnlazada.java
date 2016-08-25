package ListaEnlazada;
import java.util.Collection;
import java.util.Iterator;

import Aplicacion.ExcepcionIndiceIncorrecto;
import Aplicacion.Nodo;



public class ListaEnlazada<T> implements Collection<T>,Iterable<T>{

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tamanio;
	
	public ListaEnlazada() {
		primero=null;
		ultimo=null;
		tamanio=0;
	}
	
	public T get(int indice) throws ExcepcionIndiceIncorrecto{
		int indiceAux=0;
		Nodo<T> nodo = primero;
		if(indice<0||indice>=tamanio){
			throw new ExcepcionIndiceIncorrecto("indice incorrecto");
		}else{
			while(indiceAux!=indice){
				nodo=nodo.getSiguiente();
				indiceAux++;
			}
		}
		return nodo.getDato();
	}
	
	@Override
	public boolean add(T dato) {
		if(tamanio==0){
			Nodo<T> nuevo = new Nodo<T>(dato);
			primero=ultimo=nuevo;
			tamanio++;
		}else{
			Nodo<T> nuevo = new Nodo<T>(dato);
			ultimo.setSiguiente(nuevo);
			ultimo=nuevo;
			tamanio++;
		}
		
		return true;
		
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		primero=null;
		ultimo=null;
		tamanio=0;
	}

	@Override
	public boolean contains(Object o) {
		Nodo<T> aux=primero;
		while(aux!=null){
			if(aux.getDato().equals(o)){
				return true;
			}else{
				aux=aux.getSiguiente();
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(tamanio==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador(this);
	}

	@Override
	public boolean remove(Object o) {
		Nodo<T> aux=primero;
		Nodo<T> anterior=null;
		
		while(aux!=null){
			if(aux.getDato().equals(o)){
				if(anterior==null){
					aux=aux.getSiguiente();
					this.primero=aux;
				}else{
					anterior.setSiguiente(aux.getSiguiente());
					aux=null;
				}
				tamanio--;
				return true;
			}else{
				anterior=aux;
				aux=aux.getSiguiente();
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return tamanio;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Nodo<T> copyList(boolean recursivo){
		
		if(recursivo){
			return copyList(null,null);
		}else{
			Nodo<T> nodoPrimero;
			Nodo<T> nodoUltimo;
			Nodo<T> aux = primero.getSiguiente();
			nodoPrimero = nodoUltimo = primero;
			while(aux!=null){
					nodoUltimo.setSiguiente(aux);
					nodoUltimo=aux;
					aux=aux.getSiguiente();	
			}
			return nodoPrimero;
		}
	}
	
	private Nodo<T> copyList(Nodo<T> primero,Nodo<T> ultimo){
		if(ultimo==null&&primero!=null){
			return primero;
		}else{
			if(primero==ultimo&&primero==null){
				primero=ultimo=this.primero;
				return copyList(primero, ultimo);
			}else{
				ultimo.setSiguiente(ultimo.getSiguiente());
				ultimo=ultimo.getSiguiente();
				return copyList(primero, ultimo);
			}
			
		}
	}

	
	public void add(int i,T o)throws Exception
    {
        
        
        if(i>=0&&i<=this.size())
        {
            
            Nodo<T> aux=new Nodo<T>(o);
        
            if(i==0)
            {
               aux.setSiguiente(primero);
               primero=aux;
               tamanio++;
            }else if(i==this.size())
            {
               ultimo.setSiguiente(aux);
               ultimo=aux;
               tamanio++;
            }else
            {
             int a=0;
             Nodo<T> ret=primero;
             Nodo<T> anterior=null;
             
             while(a<=i)
             {
                 if(a==i)
                 {
                     aux.setSiguiente(ret);
                     anterior.setSiguiente(aux);
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

	
	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}

	/**
	 * @param primero the primero to set
	 */
	public void setPrimero(Nodo<T> primero) {
		this.primero = primero;
	}

	/**
	 * @return the ultimo
	 */
	public Nodo<T> getUltimo() {
		return ultimo;
	}

	/**
	 * @param ultimo the ultimo to set
	 */
	public void setUltimo(Nodo<T> ultimo) {
		this.ultimo = ultimo;
	}

	/**
	 * @return the tamanio
	 */
	public int getTamanio() {
		return tamanio;
	}

	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	
	
}

