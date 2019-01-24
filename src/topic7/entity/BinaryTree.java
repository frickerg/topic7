package topic7.entity;

import topic7.exceptions.NotComparableException;

/**
 * Binary Tree implementation which stores {@link Node} objects and provides
 * multiple methods for Binary Tree operations.
 *
 * @param <E>
 *            the generic content type used inside a {@link Node}
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class BinaryTree<E> {
	private Node<E> rootNode;
	private int size = 0;

	/**
	 * Constructor with no arguments. Creates an empty {@link BinaryTree}
	 */
	public BinaryTree() {
	}

	/**
	 * Constructor with a given root element. Creates a {@link BinaryTree} with a
	 * root {@link Node} and a size of 1.
	 *
	 * @param element
	 *            the element inside the {@link Node}
	 */
	public BinaryTree(E element) {
		this.rootNode = new Node<>(element);
		this.size++;
	}

	/**
	 * @return size of the {@link BinaryTree}
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @return whether or not the size of the {@link BinaryTree} equals zero
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * @return root node of the {@link BinaryTree}
	 */
	public Node<E> getRootNode() {
		return this.rootNode;
	}

	/**
	 * Replaces the root of the {@link BinaryTree}
	 *
	 * @param element
	 *            the element which should be the new element of the root
	 *            {@link Node}
	 * @return the updated root {@link Node}
	 */
	public Node<E> setRootNode(E element) {
		this.rootNode = new Node<>(element);
		this.size++;
		return this.rootNode;
	}

	/**
	 * Method determines, whether or not a specific {@link Node} in the
	 * {@link BinaryTree} holds a left child
	 *
	 * @param node
	 *            the {@link Node} which should be inspected
	 * @return {@code true} if the given {@link Node} holds a left child
	 */
	public boolean hasLeftChild(Node<E> node) {
		return node.getLeftChild() != null;
	}

	/**
	 * Method determines, whether or not a specific {@link Node} in the
	 * {@link BinaryTree} holds a right child
	 *
	 * @param node
	 *            the {@link Node} which should be inspected
	 * @return {@code true} if the given {@link Node} holds a right child
	 */
	public boolean hasRightChild(Node<E> node) {
		return node.getRightChild() != null;
	}

	/**
	 * Inserts an element as new child of a parent {@link Node}. The child will
	 * automatically be inserted into the free remaining spot as left or right
	 * child.
	 *
	 * @param insertionNode
	 *            the {@link Node} which will receive a new child
	 * @return the newly inserted child of the {@code insertionNode}
	 */
	public Node<E> insertChild(Node<E> insertionNode, E element) {
		if (this.hasLeftChild(insertionNode)) {
			return this.insertRight(insertionNode, element);
		}
		return this.insertLeft(insertionNode, element);
	}

	private Node<E> insertLeft(Node<E> node, E element) {
		final Node<E> leftChild = new Node<>(element);
		// creating relationship between parent and child
		node.setLeftChild(leftChild);
		leftChild.setParent(node);
		this.size++;
		return leftChild;
	}

	private Node<E> insertRight(Node<E> node, E element) {
		final Node<E> rightChild = new Node<>(element);
		// creating relationship between parent and child
		node.setRightChild(rightChild);
		rightChild.setParent(node);
		this.size++;
		return rightChild;
	}

	/**
	 * Finds the sibling of a specific {@link Node} inside the {@link BinaryTree}
	 *
	 * @param node
	 *            the {@link Node} for which we want to find its sibling
	 * @return the sibling of the provided {@link Node}
	 */
	public Node<E> sibling(Node<E> node) throws NotComparableException {
		this.checkNodeCompatibility(node);
		if (this.isRoot(node)) {
			throw new NotComparableException();
		}

		final Node<E> parent = node.getParent();
		final Node<E> left = parent.getLeftChild();
		final Node<E> right = parent.getRightChild();

		return (left.equals(node)) ? right : left;
	}

	/**
	 * Replaces the element inside a {@link Node}
	 *
	 * @param node
	 *            the {@link Node} which should have its element replaced
	 * @param element
	 *            the element which should be the new element of the {@link Node}
	 * @return the old element which has been replaced
	 */
	public E replaceElement(Node<E> node, E element) throws NotComparableException {
		this.checkNodeCompatibility(node);
		return node.setElement(element);
	}

	/**
	 * Removes a {@link Node} from the {@link Binary Tree}
	 *
	 * @param node
	 *            the {@link Node} which should be removed
	 */
	public void remove(Node<E> node) {
		if (this.isRoot(node)) {
			// reset the tree if the root node is to be removed
			this.rootNode = null;
			this.size = 0;
		} else {
			final Node<E> parent = node.getParent();
			// revoking the relationship towards the child
			if (parent.getLeftChild().equals(node)) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			this.size--;
		}
	}

	/**
	 * @param node
	 *            the {@link Node} which should be inspected
	 * @return whether or not a {@link Node} is internal in the {@link Binary Tree}
	 */
	public boolean isInternal(Node<E> node) {
		return (this.hasLeftChild(node) || this.hasRightChild(node));
	}

	/**
	 * @param node
	 *            the {@link Node} which should be inspected
	 * @return whether or not a {@link Node} is external in the {@link Binary Tree}
	 */
	public boolean isExternal(Node<E> node) {
		return !(this.hasLeftChild(node) || this.hasRightChild(node));
	}

	/**
	 * @param node
	 *            the {@link Node} which should be inspected
	 * @return whether or not a {@link Node} is the root in a {@link Binary Tree}
	 */
	public boolean isRoot(Node<E> node) throws NotComparableException {
		this.checkNodeCompatibility(node);
		return node.equals(this.rootNode);
	}

	private void checkNodeCompatibility(Node<E> node) {
		if (node == null || this.isEmpty()) {
			throw new NotComparableException();
		}
	}
}
