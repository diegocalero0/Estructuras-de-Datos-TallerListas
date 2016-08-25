package Taller;

import java.util.Collection;

import ListaEnlazada.ListaEnlazada;

public class Taller<T> {
	
	public <T> int contarEnLista(Collection<T> lista , Object o){
		
		int cont=0;
		for(Object aux:lista){
			if(aux.equals(o)){
				cont++;
			}
		}
		return cont;
	}
	
	
	public int mayorEnteroListaCircular(Collection<Integer> listacircular){
		
		int mayor=Integer.MIN_VALUE;
		for(int a:listacircular){
			if(a>mayor){
				mayor=a;
			}
		}
		
		return mayor;
		
	}
	
	public ListaEnlazada<Alumno> ordenarHombreMujeres(ListaEnlazada<Alumno> lista) throws Exception{
		boolean hombre=true;
		ListaEnlazada<Alumno> hombres = new ListaEnlazada<Alumno>();
		ListaEnlazada<Alumno> mujeres = new ListaEnlazada<Alumno>();
		
		for(Alumno aux:lista){
			if(aux.getGenero().equals("h")){
				hombres.add(aux);
			}else{
				mujeres.add(aux);
			}
		}
		
		lista.clear();
		
		while(hombres.size()>0&&mujeres.size()>0){
			lista.add(hombres.get(0));
			hombres.remove(hombres.get(0));
			lista.add(mujeres.get(0));
			mujeres.remove(mujeres.get(0));
		}
		
		ListaEnlazada<Alumno> listaAux = new ListaEnlazada<Alumno>();
		
		if(hombres.size()==mujeres.size()){
			return lista;
		}else if(hombres.size()>mujeres.size()){
			listaAux=hombres;
		}else{
			listaAux=mujeres;
		}
		
		for(Alumno aux:listaAux ){
			lista.add(aux);
		}
		
		return lista;
		
	}
	
}
