/**
 * Clase DictionaryController
 * @author Brian Carrillo
 *
 * En esta clase se manejan las acciones
 * del controlador de los diccionarios ingles
 * y frances.
 */
package uvg.edu.common;

import java.util.ArrayList;

import uvg.edu.structures.BinarySearchTree;

/**
 * @author Brian Carrillo
 *
 */
public class DictionaryController {
	StringComparator<String> comparator = new StringComparator<String>();
	BinarySearchTree<String,String> btsIngles;
	BinarySearchTree<String,String> btsFrances;
	ArrayList<String>filas;
	
	public DictionaryController(ArrayList<String>filas) {
		this.filas = filas;
		createBTSIngles();
		createBTSFrances();
	}
	
	public String listBtsIngles() {
		String result = "";
		Listado lista = new Listado();
		btsIngles.inOrder(lista);
		ArrayList<String>diccionario = lista.miListado;
		for(String asociacion:diccionario) {
			result += asociacion+"\n";
		}
		
		return result;
	}
	
	public String listBtsFrances() {
		String result = "";
		Listado lista = new Listado();
		btsFrances.inOrder(lista);
		ArrayList<String>diccionario = lista.miListado;
		for(String asociacion:diccionario) {
			result += asociacion+"\n";
		}
		
		return result;
	}
	
	private void createBTSIngles() {
		this.btsIngles = new BinarySearchTree<String,String>(this.comparator);
		for(String fila:filas) {
			String[]palabras = fila.split(",");
			btsIngles.insert(palabras[0].toLowerCase(), palabras[1].toLowerCase());
		}
	}
	
	private void createBTSFrances() {
		this.btsFrances = new BinarySearchTree<String,String>(this.comparator);
		for(String fila:filas) {
			String[]palabras = fila.split(",");
			btsFrances.insert(palabras[2].toLowerCase(), palabras[1].toLowerCase());
		}
	}
	
	public String translateText(ArrayList<String>palabras) {
		String resultado = "";
		int idioma = 0;
		int count = 0;
		
		for(String palabra:palabras) {
			palabra = palabra.toLowerCase();
			if(count!=0) {
				resultado += " ";
			}
			
			if(idioma==0) {
				if(!(btsIngles.find(palabra) == null)) {
					resultado += btsIngles.find(palabra);
					idioma = 1;
				}else if(!(btsFrances.find(palabra) == null)) {
					resultado += btsFrances.find(palabra);
					idioma = 2;
				}else {
					resultado += "*"+palabra+"*";
				}
			}else if(idioma==1) {
				if(!(btsIngles.find(palabra) == null)) {
					resultado += btsIngles.find(palabra);
				}else {
					resultado += "*"+palabra+"*";
				}
			}else if(idioma==2) {
				if(!(btsFrances.find(palabra) == null)) {
					resultado += btsFrances.find(palabra);
				}else {
					resultado += "*"+palabra+"*";
				}
			}
			
			count++;
		}
		
		return resultado;
	}
	
	public String addPalabra(String solicitud) {
		String[]palabras = solicitud.split(",");
		btsIngles.insert(palabras[0].toLowerCase(), palabras[1].toLowerCase());
		btsFrances.insert(palabras[2].toLowerCase(), palabras[1].toLowerCase());
		
		return "Nueva palabra ("+solicitud+") agregada con exito.";
	}
	
	public String deletePalabra(String asociacion) {
		String resultado = "";
		String[]palabras = asociacion.split(",");
		String valueIngles = btsIngles.find(palabras[0]);
		String valueFrances = btsFrances.find(palabras[2]);
		
		if(valueIngles.equals(valueFrances)) {
			btsIngles.delete(palabras[0]);
			btsFrances.delete(palabras[2]);
			
			resultado = "La asociacion ("+asociacion+") ha sido eliminada con exito.";
		}else {
			resultado = "Asociacion invalida.";
		}
		
		return resultado;
	}
	
}
