package topic7.example;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import topic7.entity.BinaryTree;
import topic7.entity.Node;
import topic7.main.LinkedTreeHeap;

/**
 * Frame class designed to paint a {@link BinaryTree} for graphical reference
 * and demonstration purposes using {@link Graphics2D} as rendering class for
 * the geometry of our {@link BinaryTree}.
 *
 * The implementation of an user interface was not a project requirement.
 * Therefore, the BSTTest.java (link below) was used to implement the UI. The
 * BSTTest.java class was adapted to handle our own {@link LinkedTreeHeap} class
 *
 * @author besio1, fricg2
 * @see https://www.ida.liu.se/~TDDC91/info/code/lab2/BSTTest.java
 * @version 17-01-2018
 */
@SuppressWarnings("serial")
public class BTreeUI extends Frame implements ActionListener {
	private static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, 25);

	private static final int SPACING_PARENT_TO_CHILD = 20;
	private static final int SPACING_BETWEEN_SIBLINGS = 30;
	private static final Dimension EMPTY_DIMENSION = new Dimension(0, 0);

	private final LinkedTreeHeap<Integer> heap;
	private final HashMap<Node<Integer>, Rectangle> surroundingRectancleMap = new HashMap<>();
	private final HashMap<Node<Integer>, Dimension> subtreeDimensionMap = new HashMap<>();

	private FontMetrics fm;
	private boolean isRecalculationRequested = true;

	/**
	 * Constructor for class {@link BTreeUI}.
	 *
	 * @param heap
	 *            the heap that will be drawn by the {@link BTreeUI}.
	 */
	public BTreeUI(LinkedTreeHeap<Integer> heap) {
		this.heap = heap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

	@Override
	public void repaint() {
		this.isRecalculationRequested = true;
		super.repaint();
	}

	private Dimension calculateSubtreeDimension(Node<Integer> node) {
		if (node == null) {
			return BTreeUI.EMPTY_DIMENSION;
		}
		final Dimension leftDimension = this.calculateSubtreeDimension(node.getLeftChild());
		final Dimension rightDimension = this.calculateSubtreeDimension(node.getRightChild());
		final int height = this.fm.getHeight() + BTreeUI.SPACING_PARENT_TO_CHILD
				+ Math.max(leftDimension.height, rightDimension.height);
		final int width = leftDimension.width + BTreeUI.SPACING_BETWEEN_SIBLINGS + rightDimension.width;
		final Dimension dimension = new Dimension(width, height);
		this.subtreeDimensionMap.put(node, dimension);
		System.out.println(
				"subtreeDimensionMap.put(" + node.getElement() + "," + dimension.height + "/" + dimension.width + ")");

		return dimension;
	}

	private void calculateLocation(Node<Integer> node, int left, int right, int top) {
		if (node == null) {
			return;
		}
		Dimension leftDimension = this.subtreeDimensionMap.get(node.getLeftChild());
		if (leftDimension == null) {
			leftDimension = BTreeUI.EMPTY_DIMENSION;
		}
		Dimension rightDimension = this.subtreeDimensionMap.get(node.getRightChild());
		if (rightDimension == null) {
			rightDimension = BTreeUI.EMPTY_DIMENSION;
		}
		int center = 0;
		if (right != Integer.MAX_VALUE) {
			center = right - rightDimension.width - BTreeUI.SPACING_BETWEEN_SIBLINGS / 2;
		} else if (left != Integer.MAX_VALUE) {
			center = left + leftDimension.width + BTreeUI.SPACING_BETWEEN_SIBLINGS / 2;
		}
		final int width = this.fm.stringWidth(node.getElement().toString());
		final Rectangle surroundingRectangle = new Rectangle(center - width / 2 - 3, top, width + 6,
				this.fm.getHeight());
		this.surroundingRectancleMap.put(node, surroundingRectangle);
		this.calculateLocation(node.getLeftChild(), Integer.MAX_VALUE, center - BTreeUI.SPACING_BETWEEN_SIBLINGS / 2,
				top + this.fm.getHeight() + BTreeUI.SPACING_PARENT_TO_CHILD);
		this.calculateLocation(node.getRightChild(), center + BTreeUI.SPACING_BETWEEN_SIBLINGS / 2, Integer.MAX_VALUE,
				top + this.fm.getHeight() + BTreeUI.SPACING_PARENT_TO_CHILD);
	}

	private void drawTree(Graphics2D g, Node<Integer> node, int x, int y, int offset) {
		if (node == null) {
			return;
		}
		final Rectangle surroundingRectangle = this.surroundingRectancleMap.get(node);
		g.draw(surroundingRectangle);
		g.drawString(node.getElement().toString(), surroundingRectangle.x + 3, surroundingRectangle.y + offset);
		if (x != Integer.MAX_VALUE) {
			g.drawLine(x, y, surroundingRectangle.x + surroundingRectangle.width / 2, surroundingRectangle.y);
		}
		this.drawTree(g, node.getLeftChild(), surroundingRectangle.x + surroundingRectangle.width / 2,
				surroundingRectangle.y + surroundingRectangle.height, offset);
		this.drawTree(g, node.getRightChild(), surroundingRectangle.x + surroundingRectangle.width / 2,
				surroundingRectangle.y + surroundingRectangle.height, offset);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(FONT);
		this.fm = g.getFontMetrics();
		if (this.isRecalculationRequested) {
			this.surroundingRectancleMap.clear();
			this.subtreeDimensionMap.clear();
			final Node<Integer> rootNode = this.heap.getTree().getRootNode();
			if (rootNode != null) {
				this.calculateSubtreeDimension(rootNode);
				this.calculateLocation(rootNode, Integer.MAX_VALUE, Integer.MAX_VALUE, 40);
			}
			this.isRecalculationRequested = false;
		}
		g2d.translate(this.getWidth() / 2, BTreeUI.SPACING_PARENT_TO_CHILD);
		this.drawTree(g2d, this.heap.getTree().getRootNode(), Integer.MAX_VALUE, Integer.MAX_VALUE,
				this.fm.getLeading() + this.fm.getAscent());
		this.fm = null;
	}
}