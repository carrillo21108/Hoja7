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
		return internalFind(root, id);
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
		ArrayList<V> list = new ArrayList<V>();
		internalGetElements(list, root);
		
		return list;
	}

	@Override
	public void inOrder(ITreeTraversal<V> traversal) {
		internalInOrder(root, traversal);
	}

	@Override
	public void preOrder(ITreeTraversal<V> traversal) {
		internalPreOrder(root, traversal);
		
	}

	@Override
	public void postOrder(ITreeTraversal<V> traversal) {
		internalPostOrder(root, traversal);
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

	private void internalGetElements(ArrayList<V> list, Association<K, V> actual) {
		if (actual != null) {
			internalGetElements(list, actual.getLeft());
			
			list.add((V)("("+actual.getId()+", "+actual.getValue()+")"));
			
			internalGetElements(list, actual.getRight());
		}
	}
	
	private void internalInOrder(Association<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
			internalInOrder(actual.getLeft(), traversal);
			
			traversal.Walk((V)("("+actual.getId()+", "+actual.getValue()+")"));
			
			internalInOrder(actual.getRight(), traversal);
		}
	}
	
	private void internalPreOrder(Association<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
			traversal.Walk((V)("("+actual.getId()+", "+actual.getValue()+")"));
			
			internalPreOrder(actual.getLeft(), traversal);
			
			internalPreOrder(actual.getRight(), traversal);
		}
	}
	
	private void internalPostOrder(Association<K, V> actual, ITreeTraversal<V> traversal) {
		if (actual != null) {
		
			internalPostOrder(actual.getLeft(), traversal);
			
			internalPostOrder(actual.getRight(), traversal);
			
			traversal.Walk((V)("("+actual.getId()+", "+actual.getValue()+")"));
		}
	}
	
	private V internalFind(Association<K, V> actual, K id) {
		if (actual != null) {
			int result = keyComparator.compare(actual.getId(), id);
			
			if (result > 0) {
				return internalFind(actual.getLeft(), id);
			} else if (result < 0) {
				return internalFind(actual.getRight(), id);
			} else {
				return actual.getValue();
			}
			
		} else {
			return null;
		}
	}

}
