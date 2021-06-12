package coding.questions;

public class MergeTrees {
	static class Node{
		Node left, right;
		int value;
		Node(int data){
			this.value = data;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node mergeTrees(Node t1, Node t2) {
		if(t1 == null) return t2;
		if(t2 == null) return t1;
		t1.value += t2.value;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

}
