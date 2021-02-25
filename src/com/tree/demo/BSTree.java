package com.tree.demo;

public class BSTree {
	Node root;

	public BSTree() {
		this.root = null;
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			Node currentNode = this.root;
			boolean added = false;
			while (!added) {
				if (value < currentNode.value) {
					// Left treverse
					if (currentNode.left == null) {
						currentNode.left = newNode;
						added = true;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					// Right treverse
					if (currentNode.right == null) {
						currentNode.right = newNode;
						added = true;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
	}

	public String lookup(int value) {
		Node currentNode = this.root;
		while (currentNode != null) {
			if (currentNode.value == value)
				return "found";
			else if (value < currentNode.value)
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		}
		return "Not found";
	}
	
	public Boolean remove(int value){
		Node currentNode = this.root;
		boolean found = false;
		Node parentNode = null;
		while (!found && currentNode != null) {
			if (currentNode.value == value)
				found = true;
			else if (value < currentNode.value){
				parentNode = currentNode;
				currentNode = currentNode.left;
			}
			else {
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
		}
		if(found){
			if(currentNode.right == null){
				if(parentNode == null)
					this.root = currentNode.left;
				else if (currentNode.value < parentNode.value){
					parentNode.left = currentNode.left;
				} else {
					parentNode.right = currentNode.left;
				}
			}
			else if(currentNode.right.left == null){
				if(parentNode == null)
					this.root = currentNode.left;
				else {
				    currentNode.right.left = currentNode.left;
				    if (currentNode.value < parentNode.value){
						parentNode.left = currentNode.right;
					} else {
						parentNode.right = currentNode.right;
					}
				}
			} else {
				Node leftMostChild = currentNode.right.left;
				Node leftMostParent = currentNode.right;
				while(leftMostChild.left != null){
					leftMostParent = leftMostChild;
					leftMostChild = leftMostChild.left;
				}
				leftMostParent.left = leftMostChild.right;
				leftMostChild.left = currentNode.left;
				leftMostChild.right = currentNode.right;
				if(parentNode == null)
					this.root = leftMostChild;
				else {
				    if (currentNode.value < parentNode.value){
						parentNode.left = leftMostChild;
					} else {
						parentNode.right = leftMostChild;
					}
				}
				
			}
			
		}
		return found;
	}
}
