/**
 * 
 */
package uvg.edu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uvg.edu.common.StringComparator;
import uvg.edu.structures.BinarySearchTree;

/**
 * @author Brian Carrillo
 *
 */
class BinarySearchTreeTest {
	
	StringComparator<String> comparator = new StringComparator<String>();
	BinarySearchTree<String,String>arbol = new BinarySearchTree<String,String>(comparator);

	@Test
	void insertTest() {
		String valorEsperado = "(dog, perro)\n(homework, tarea)\n(house, casa)\n(town, pueblo)\n(woman, mujer)\n(yes, si)\n";
		String valorRecibido = "";
		arbol.insert("yes", "si");
		arbol.insert("homework", "tarea");
		arbol.insert("dog", "perro");
		arbol.insert("house", "casa");
		arbol.insert("woman", "mujer");
		arbol.insert("town", "pueblo");
		ArrayList<String> listado = arbol.getElements();
		for(String asociacion:listado) {
			valorRecibido+=asociacion+"\n";
		}
		assertEquals(valorEsperado, valorRecibido);	
	}
	
	@Test
	void deleteTest() {
		String valorEsperado = "(dog, perro)\n(homework, tarea)\n(house, casa)\n(town, pueblo)\n(woman, mujer)\n";
		String valorRecibido = "";
		arbol.insert("yes", "si");
		arbol.insert("homework", "tarea");
		arbol.insert("dog", "perro");
		arbol.insert("house", "casa");
		arbol.insert("woman", "mujer");
		arbol.insert("town", "pueblo");
		arbol.delete("yes");
		ArrayList<String> listado = arbol.getElements();
		for(String asociacion:listado) {
			valorRecibido+=asociacion+"\n";
		}
		assertEquals(valorEsperado, valorRecibido);	
	}
	
	@Test
	void findTest() {
		String valorEsperado = "tarea";
		String valorRecibido = "";
		arbol.insert("yes", "si");
		arbol.insert("homework", "tarea");
		arbol.insert("dog", "perro");
		arbol.insert("house", "casa");
		arbol.insert("woman", "mujer");
		arbol.insert("town", "pueblo");
		valorRecibido = arbol.find("homework");
		
		assertEquals(valorEsperado, valorRecibido);	
	}

}
