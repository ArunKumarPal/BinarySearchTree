package com.tree.demo;

public class Test {

	public static void main(String[] args) {
		BSTree tree = new BSTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(20);
		tree.insert(170);
		tree.insert(15);
		tree.insert(1);
		tree.insert(12);
		tree.insert(17);
		tree.insert(10);
		tree.insert(14);
		tree.insert(16);
		tree.insert(18);
		tree.insert(30);
		tree.insert(50);
		System.out.println(tree.root.toString());
		System.out.println(tree.lookup(20));
		System.out.println(tree.lookup(10));
		System.out.println(tree.lookup(15));
		System.out.println(tree.remove(20));
		System.out.println(tree.lookup(20));
		System.out.println(tree.root.toString());

	}

}
