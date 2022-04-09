/**
 * Clase Association
 * @author Brian Carrillo
 *
 * En esta clase se manejan las asociaciones de
 * diccionario
 */
package uvg.edu.structures;

/**
 * @author Brian Carrillo
 *
 */
public class Association<K, V> {
	private K id;
	private V value;
	private Association<K,V> left;
	private Association<K,V> right;
	private Association<K,V> parent;
	
	public Association(K id, V value) {
		setId(id);
		setValue(value);
		setLeft(null);
		setRight(null);
		setParent(null);
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Association<K, V> getLeft() {
		return left;
	}

	public void setLeft(Association<K, V> left) {
		this.left = left;
	}

	public Association<K, V> getRight() {
		return right;
	}

	public void setRight(Association<K, V> right) {
		this.right = right;
	}

	public Association<K, V> getParent() {
		return parent;
	}

	public void setParent(Association<K, V> parent) {
		this.parent = parent;
	}
	
	
	
}
