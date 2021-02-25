package com.tree.demo;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public String toString(){
		String s = "";
		if(this != null){
			s = this.value + " ";
			if(this.left != null)
			 s= s +  this.left.toString();
			if(this.right != null)
				 s= s +  this.right.toString();
		}
		return s;
	}

}
