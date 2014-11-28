package com.dmac.core;

public class BST {

	private TreeNode node = null;
	
	public TreeNode insert(TreeNode node, int data) {
		
		if (node == null) {
			node = new TreeNode();
			node.setData(data);
		}
		
		else {
			if (data <= node.getData())
				node.left = insert(node.getLeft(), data);
			
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class TreeNode {
	
	public TreeNode left 		= null;
	public TreeNode right 		= null;
	private int 	 data		= 0;
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
	
	
	
	
}