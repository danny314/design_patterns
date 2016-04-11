package com.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCanonical {

  static class BinaryTreeNode {
    int key;
    BinaryTreeNode left, right;
    Integer cachedHash; // can speed up hash function computation hugely
    
    private static Map<Integer,BinaryTreeNode> flyweightMap = new HashMap<Integer,BinaryTreeNode>();

    public BinaryTreeNode(int k, BinaryTreeNode l, BinaryTreeNode r) {
      this.key = k;
      this.left = l;
      this.right = r;
      this.cachedHash = null;
    }

	@Override
	public int hashCode() {
		if (cachedHash == null) {
			final int prime = 31;
			int result = 1;
			result = prime * result + key;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			this.cachedHash = result;
		}
		return cachedHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (key != other.key)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
  }

  static BinaryTreeNode getCanonical(BinaryTreeNode n) {
	//Lookup node in flyweight map. If present, return it else add it to map  
	BinaryTreeNode node = BinaryTreeNode.flyweightMap.get(n.hashCode());  
	if (node == null) {
		BinaryTreeNode.flyweightMap.put(n.hashCode(), n);
		return n;
	} else {
		return node;
	}
  } 

  static int numberOfFlyweightNodes() {
    return BinaryTreeNode.flyweightMap.size();
  }
}
