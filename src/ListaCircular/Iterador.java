package ListaCircular;
import java.util.Iterator;

import Aplicacion.ExcepcionIndiceIncorrecto;

public class Iterador<T> implements Iterator<T>{

	private ListaCircular<T> miLista;
	private int indice;
	
	public Iterador(ListaCircular<T> miLista) {
		this.miLista=miLista;
		miLista.size();
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
