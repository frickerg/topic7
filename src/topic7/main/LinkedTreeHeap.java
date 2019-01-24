package topic7.main;

import java.util.List;
import java.util.Stack;

import topic7.entity.BinaryTree;
import topic7.entity.Node;
import topic7.example.BTreeUI;
import topic7.exceptions.EmptyHeapException;
import topic7.exceptions.NotComparableException;
import topic7.interfaces.Comparator;
import topic7.interfaces.Heap;


/**
 * {@code LinkedTreeHeap} is an implementation of a Heap, using a
 * {@code BinaryTree} as underlying data structure.
 * 
 * @author besio1, fricg2
 * @version 17-01-2018
 *
 * @param <K>
 */
public class LinkedTreeHeap<K> implements Heap<K> {
	private final Comparator<K> comparator;
	private Node<K> lastNode;
	private final BinaryTree<K> tree;
	private final Stack<Node<K>> stack;

	public LinkedTreeHeap(Comparator<K> comparator) {
		this.comparator = comparator;
		this.tree = new BinaryTree<>();
		this.stack = new Stack<>();
	}

	@Override
	public int size() {
		return this.tree.size();
	}

	@Override
	public boolean isEmpty() {
		return this.tree.size() == 0;
	}

	@Override
	public void insertElement(K element) throws NotComparableException {
		// checks if Element is comparable
		if (!this.comparator.isComparable(element)) {
			throw new NotComparableException();
		}
		Node<K> committedNode;
		// checks if tree is empty
		if (this.isEmpty()) {
			final Node<K> rootNode = this.tree.setRootNode(element);
			committedNode = rootNode;
		} else {
			// insert the node in getInsertionNode and then do upheap
			final Node<K> insert = this.getInsertionNode();
			this.upheap(this.tree.insertChild(insert, element));
			if (this.tree.hasRightChild(insert)) {
				committedNode = insert.getRightChild();
			} else {
				committedNode = insert.getLeftChild();
			}
		}
		this.lastNode = committedNode;
		this.stack.push(committedNode);
	}

	/**
	 * Make upheap after a new node was added to the heap
	 *
	 * @param p
	 *            the node on which the upheap must be done
	 */
	private void upheap(Node<K> p) {
		// checks if p is root
		if (this.tree.isRoot(p)) {
			return;
		}
		final Node<K> parent = p.getParent();
		final K element = parent.getElement();
		// if element of node p is lesser or equal than element of node parent, do
		// upheap
		if (this.comparator.isLessThanOrEqualTo(p.getElement(), element)) {
			this.tree.replaceElement(parent, p.getElement());
			this.tree.replaceElement(p, element);
			// do the upheap with the new p and new parent
			this.upheap(parent);
		}
	}

	/**
	 * Searchs the insertion node
	 *
	 * @return insertion node
	 */
	private Node<K> getInsertionNode() {
		Node<K> insert = this.lastNode;
		// If the last node is a left child, return the parent node
		if (this.isLeftChild(insert)) {
			return insert.getParent();
		}
		// While the current node is a right child, go to the parent node
		while (this.isRightChild(insert)) {
			insert = insert.getParent();
		}
		// If the current node is a left child, go to its (right) sibling
		if (this.isLeftChild(insert)) {
			insert = this.tree.sibling(insert);
		}
		// While the current node is internal, go to the left child
		while (this.tree.isInternal(insert)) {
			insert = insert.getLeftChild();
		}
		return insert;
	}

	/**
	 * Determines, if node p is whether a right Child or not
	 *
	 * @param p
	 *            node which is tested, if it is a rightChild
	 * @return {@code true} if p is a right child, {@code false} if p is not a right
	 *         child
	 */
	private boolean isRightChild(Node<K> p) {
		if (this.tree.isRoot(p)) {
			return false;
		}
		final Node<K> parent = p.getParent();
		if (this.tree.hasRightChild(parent) && parent.getRightChild().equals(p)) {
			return true;
		}
		return false;
	}

	/**
	 * Determines, if node p is whether a left Child or not
	 *
	 * @param p
	 *            node which is tested, if it is a left child
	 * @return {@code true} if p is a left child, {@code false} if p is not a left
	 *         child
	 */
	private boolean isLeftChild(Node<K> p) {
		if (this.tree.isRoot(p)) {
			return false;
		}
		final Node<K> parent = p.getParent();
		if (parent.getLeftChild().equals(p)) {
			return true;
		}
		return false;
	}

	@Override
	public K removeMin() throws EmptyHeapException {
		if (this.isEmpty()) {
			throw new EmptyHeapException();
		}
		final K min = this.tree.replaceElement(this.tree.getRootNode(), this.lastNode.getElement());
		this.tree.remove(this.lastNode);
		this.stack.pop();
		if (this.tree.size() > 0) {
			this.lastNode = this.stack.peek();
			this.downheap(this.tree.getRootNode());
		}
		return min;
	}

	/**
	 * Make downheap by changing elements
	 *
	 * @param p
	 *            the node on which the downheap must be done
	 */
	private void downheap(Node<K> p) {
		if (this.tree.isExternal(p)) {
			return;
		}
		final Node<K> smallerElement = this.findSmallerElementOfNode(p);
		if (this.comparator.isGreaterThanOrEqualTo(p.getElement(), smallerElement.getElement())) {
			final K temp = p.getElement();
			this.tree.replaceElement(p, smallerElement.getElement());
			this.tree.replaceElement(smallerElement, temp);
			this.downheap(smallerElement);
		}
	}

	/**
	 * finds the smaller child of the node p
	 *
	 * @param node
	 *            the node on which the smaller child is searched
	 * @return smallerChild
	 */
	private Node<K> findSmallerElementOfNode(Node<K> node) {
		final Node<K> leftChild = node.getLeftChild();
		final Node<K> rightChild = node.getRightChild();
		if (!this.tree.hasRightChild(node)) {
			return leftChild;
		}
		if (this.comparator.isLessThanOrEqualTo(leftChild.getElement(), rightChild.getElement())) {
			return leftChild;
		} else {
			return rightChild;
		}
	}

	@Override
	public K minElement() throws EmptyHeapException {
		if (this.isEmpty()) {
			throw new EmptyHeapException();
		}
		return this.tree.getRootNode().getElement();
	}

	/**
	 * sort a list of comparable elements
	 *
	 * @param list
	 *            list in which the elements shoud be sorted
	 * @param comparator
	 *            using the reverse comparators
	 */
	public static <E> void heapSort(List<E> list, Comparator<E> comparator) {
		final Heap<E> heap = new LinkedTreeHeap<>(comparator);
		for (final E element : list) {
			heap.insertElement(element);
		}
		list.clear();
		for (int i = heap.size(); i > 0; i--) {
			list.add(heap.removeMin());
		}
	}

	/**
	 * This method is merely used for the example class {@link BTreeUI}. The method
	 * is not necessary for the functionality of {@link LinkedTreeHeap} and is
	 * therefore marked as deprecated.
	 */
	@Deprecated
	public BinaryTree<K> getTree() {
		return this.tree;
	}
}
