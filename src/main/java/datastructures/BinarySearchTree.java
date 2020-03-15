package datastructures;

import java.util.ArrayList;
import java.util.List;


/*
        A binary search tree (or BST) is a tree data structure where each node
        may contain at most two children and each parent is greater than its
        left child and less than or equal to its right child (if any).

        BST's are useful in scenarios that require fast insertion, search, and deletion.
        All of the three aforementioned operations have an average time complexity of O(logn)
        with a worst case of O(n). Optimal times are experienced when the height of the tree
        is logarithmic to the number of nodes (i.e. the BST is balanced).

        Example of unbalanced BST:

            0
             \
              1
               \
                2
                 \
                  3


        The above arrangement is the worst case for a BST, because the height is proportional
        to the number of nodes. To fix this, the BST must be balanced.

        Example of balanced BST:

            2
           / \
          1   3
         /
        0

        If the pattern above is continued, and each level of the tree is fully populated before
        continuing to the next level, then the height of the tree becomes similar to logn. Fixing
        an unbalanced BST can be done by acquiring the inorder traversal (returns elements in sorted order)
        and inserting the middle element of the array first, then bisecting the array, and using the two
        subarrays to generate the left BST and right BST recursively. However, this is O(nlogn) which defeats
        the purpose of a BST. This problem can be fixed by AVL trees, which perform O(logn) rotations to keep
        the BST balanced after each insertion and deletion. See AVL class for further explanation.
 */



public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void add(T entry){
        if (root == null){
            root = new TreeNode<>(entry);
        } else {
            add(entry, root);
        }
    }

    private void add(T entry, TreeNode<T> parent){
        if (entry.compareTo(parent.val) >= 0){
            if (parent.right == null){
                parent.right = new TreeNode<>(entry);
            } else {
                add(entry, parent.right);
            }
        } else {
            if (parent.left == null){
                parent.left = new TreeNode<>(entry);
            } else {
                add(entry, parent.left);
            }
        }
    }

    private void inorder(TreeNode<T> node, List<T> acc){
        if (node == null){
            return;
        }
        inorder(node.left, acc);
        acc.add(node.val);
        inorder(node.right, acc);
    }

    public String toString(){
        List<T> res = new ArrayList<>();
        inorder(root, res);
        return res.toString();
    }

}
