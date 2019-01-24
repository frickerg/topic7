package topic7.example;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import topic7.exceptions.EmptyHeapException;
import topic7.main.AscendingIntegerComparator;
import topic7.main.LinkedTreeHeap;

/**
 * Main class which triggers the initialisation of the {@link BTreeUI}
 *
 * @see {@link BTreeUI}
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class Main {
	private static AscendingIntegerComparator comparator = new AscendingIntegerComparator();

	/**
	 * Main method starting the Application
	 */
	public static void main(String[] args) {
		final LinkedTreeHeap<Integer> heap = new LinkedTreeHeap<>(comparator);
		final BTreeUI frame = new BTreeUI(heap);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				frame.dispose();
				System.exit(0);
			}
		});
		frame.setTitle("Binary Tree UI Example");
		frame.setBounds(0, 0, 600, 400);
		frame.setVisible(true);

		char c;
		int element;
		final Scanner in = new Scanner(System.in);
		printMenu();
		for (;;) {
			System.out.print("command > ");
			System.out.flush();
			c = getChar(in);

			switch (c) {
			case 'i':
				System.out.print("Insert element : ");
				System.out.flush();
				element = getInt(in);
				heap.insertElement(element);
				frame.repaint();
				break;
			case 'r':
				try {
					System.out.println("Remove min: " + heap.removeMin());
				} catch (final EmptyHeapException e) {
					System.out.println("Your tree is empty");
				}
				frame.repaint();
				break;
			case 'q':
				System.out.println("Goodbye.");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid command");
				break;
			}
			System.out.println("-----------------");
		}
	}

	private static void printMenu() {
		System.out.println("+--- Binary Tree UI ---+");
		System.out.println("i : insert number");
		System.out.println("r : remove min");
		System.out.println("q : quit");
	}

	private static char getChar(Scanner in) {
		String tmp;
		do {
			tmp = in.nextLine();
		} while (tmp.length() != 1);
		return tmp.charAt(0);
	}

	private static int getInt(Scanner in) {
		int tmp;
		while (!in.hasNextInt()) {
			in.nextLine();
		}
		tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}
