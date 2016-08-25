package ListaEnlazada;
import java.util.Iterator;

import Aplicacion.ExcepcionIndiceIncorrecto;


public class Iterador<T> implements Iterator<T>{

	private ListaEnlazada<T> miLista;
	private int indice;
	
	public Iterador(ListaEnlazada<T> miLista) {
		this.miLista=miLista;
		indice=0;
	}
	
	@Override
	public boolean hasNext() {
		if(indice<miLista.size())
			return true;
		else
			return false;
	}

	@Override
	public T next() {
		T aux=null;
		if(indice>=0){
			try {
				aux=miLista.get(indice);
			} catch (ExcepcionIndiceIncorrecto e) {
				System.out.println("Error: Indice invalido");
			}
			indice++;
		}
		return aux;
	}
	
}
