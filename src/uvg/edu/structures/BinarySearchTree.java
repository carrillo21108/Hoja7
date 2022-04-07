/**
 * 
 */
package uvg.edu.structures;

import java.util.ArrayList;
import java.util.Comparator;

import uvg.edu.interfaces.IBinarySearchTree;
import uvg.edu.interfaces.ITreeTraversal;

/**
 * @author Brian Carrillo
 *
 */
public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {
	
	private int count;
	private Association<K,V> root;
	private Comparator<K> keyComparator;
	
	public BinarySearchTree(Comparator<K> _keyComparator) {
		this.keyComparator = _keyComparator;
		root = null;
		count = 0;
	}
	
	@Override
	public void insert(K id, V value) {
		
		if (isEmpty()) {
			root = new Association<K, V>(id, value);
			count++;
		} else {
			internalInsert(root, id, value);
		}
	}

	@Override
	public V delete(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V find(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		return count;
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public ArrayList<V> getElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inOrder(ITreeTraversal<V> traversal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preOrder(ITreeTraversal<V> traversal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrder(ITreeTraversal<V> traversal) {
		// TODO Auto-generated method stub
		
	}
	
	private void internalInsert(Association<K, V> actual, K id, V value) {
		
		int result = keyComparator.compare(actual.getId(), id);
		
		if (result > 0) { //actual id es mayor que new id luego busca en el lado izquierdo
			
			if (actual.getLeft() == null) { //No tiene hijo izquierdo
				Association<K, V> newAssociation = new Association<K, V>(id, value);
				actual.setLeft(newAssociation);
				newAssociation.setParent(actual);
				count++;
			} else {
				internalInsert(actual.getLeft(), id, value);
			}
			
		} else if (result < 0) { //actual id es mas pequeño que new luego busca en el lado derecho
			if (actual.getRight() == null) { //No tiene hijo derecho
				Association<K, V> newAssociation = new Association<K, V>(id, value);
				actual.setRight(newAssociation);
				newAssociation.setParent(actual);
				count++;
			} else {
				internalInsert(actual.getRight(), id, value);
			}
		}
		
	}

}
