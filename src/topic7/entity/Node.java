package topic7.entity;

/**
 * Node class which can store its own element, its parent as well as its left
 * child and right child. Designed to be stored in a {@link BinaryTree}
 *
 * @param <E>
 *            the generic element type
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class Node<E> {
	private E element;
	private Node<E> parent;
	private Node<E> leftChild;
	private Node<E> rightChild;

	/**
	 * Constructor of a {@link Node}
	 *
	 * @param element
	 *            the element inside of the {@link Node}
	 */
	public Node(E element) {
		this.element = element;
	}

	/**
	 * @return element of the {@link Node}
	 */
	public E getElement() {
		return this.element;
	}

	/**
	 * @param element
	 *            new element inside the {@link Node}
	 * @return the old element which has been replaced
	 */
	public E setElement(E element) {
		final E temp = this.element;
		this.element = element;
		return temp;
	}

	/**
	 * @return parent of the {@link Node}
	 */
	public Node<E> getParent() {
		return this.parent;
	}

	/**
	 * @param parent
	 *            parent to set for the {@link Node}
	 */
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}

	/**
	 * @return left child of the {@link Node}
	 */
	public Node<E> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * @param leftChild
	 *            left child to set for the {@link Node}
	 */
	public void setLeftChild(Node<E> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return right child of the {@link Node}
	 */
	public Node<E> getRightChild() {
		return this.rightChild;
	}

	/**
	 * @param rightChild
	 *            right child to set for the {@link Node}
	 */
	public void setRightChild(Node<E> rightChild) {
		this.rightChild = rightChild;
	}
}