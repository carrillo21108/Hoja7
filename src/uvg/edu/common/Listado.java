/**
 * 
 */
package uvg.edu.common;

import java.util.ArrayList;

import uvg.edu.interfaces.ITreeTraversal;

/**
 * @author Brian Carrillo
 *
 */
public class Listado<V> implements ITreeTraversal<V> {
	
	public ArrayList<V> miListado = new ArrayList<V>();
	
	@Override
	public void Walk(V value) {
		miListado.add(value);
	}

}
