package sizebst;


/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST {
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root){
		rootNode =  root;
	}

	public String toString(){
		if (rootNode == null)
			return "(null)";
		else {
			return "("+ SizeBSTN.nodeString(rootNode) + ")";
		}
	}

	/**
	 * @param target the number to search for
	 * @return true iff target is in this tree
	 */
	public boolean search(int target) {

		if (rootNode == null) {

			return false;

		} else if (SizeBSTN.getNode(rootNode, target).data == target) {

			return true;

		} else {

			return false;

		}
	}

	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData){

		if(SizeBSTN.getNode(rootNode,newData)==null) {

			rootNode = new SizeBSTN(newData);

		} else if(SizeBSTN.getNode(rootNode,newData).data>newData){

			SizeBSTN.getNode(rootNode,newData).LSubtree = new SizeBSTN(newData);
			SizeBSTN.getNodeIncr(rootNode,newData);

		} else if(SizeBSTN.getNode(rootNode,newData).data<newData){

			SizeBSTN.getNode(rootNode,newData).RSubtree = new SizeBSTN(newData);
			SizeBSTN.getNodeIncr(rootNode,newData);

		} else {

			return;

		}
	}

	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target){

		return SizeBSTN.sumNodesLeq(rootNode, target);

	}

	public static void main(String args []){
		SizeBST tree1 = new SizeBST(null);
		System.out.println("empty: "+tree1);
		tree1.insert(40);
		System.out.println("40 "+tree1);
		tree1.insert(60);
		System.out.println("50" +tree1);
		tree1.insert(20);
		System.out.println("30" +tree1);
		tree1.insert(70);
		System.out.println("35" +tree1);
		tree1.insert(30);
		System.out.println("30" +tree1);
		tree1.insert(50);
		System.out.println("35" +tree1);
		tree1.insert(50);
		System.out.println("35" +tree1);
		int test = tree1.numLEq(80);
		System.out.println("test:" + test);
	}
}
