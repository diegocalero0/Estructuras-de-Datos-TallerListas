package Aplicacion;

public class Nodo<T> {
	private T dato;
	private Nodo<T> siguiente;
	
	public Nodo(T dato){
		this.dato=dato;
		siguiente=null;
	}

	/**
	 * @return the dato
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * @return the siguiente
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
}
