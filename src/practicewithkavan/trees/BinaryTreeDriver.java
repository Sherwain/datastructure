package practicewithkavan.trees;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Sherwain Date: 4/15/13 Time: 1:19 PM To
 * change this template use File | Settings | File Templates.
 */
public class BinaryTreeDriver {
	public static void main(String[] args) {
		// This class add the nodes to the binary tree in a complete tree
		// fashion. ie all levels are filled before moving to the next level.
		BinaryTree<Character> T = new BinaryTree<Character>();
		Character val[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'A' };
		// for (int x = 0; x < val.length; x ++)
		// T.addComplete(val[x]);
		// System.out.println("PreOrder(VLR) :" + T.preOrderTraversal());
		// System.out.println("InOrder(LVR) :" + T.inOrderTraversal());
		// System.out.println("PostOrder(LRV) :" + T.postOrderTraversal());
		// System.out.println("LevelOrder :" + T.levelOrderTraversal());
		// System.out.println("LevelOrder :" + T.levelOrder());
		// System.out.println("Depth of tree is Tree is: " + T.getDepth());
		// System.out.println("Height of tree is Tree is: " + T.getHeight());
		// System.out.println(T.isFull());
		// System.out.println(T.isBalanced());
		// System.out.println("Leaves: " + T.countLeaves());

		Set<Character> Ts = new HashSet<Character>();
		int start = 0;
		int stop = 0;
		// Ts = ;

	}

	public static String isWord(String book) {
		Set<Character> alphabeth = new HashSet<Character>();
		int start = 0;
		int stop = 0;
		int found = 0;
		String match = null;
		String temp;

		for (int i = 0; i < book.length(); i++) {
			if (alphabeth.contains(book.charAt(i))) {
				if (++found == 26) {
					temp = book.substring(start, i);
					match = temp.length() < match.length() ? temp : match;

				} else {
					found = 0;
					start = i;
				}
			}

		}
		return "";
	}
}
