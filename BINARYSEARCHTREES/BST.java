import java.util.*;

class NodeSearch {
    int key;NodeSearch left;NodeSearch right;public NodeSearch(int key) {this.key = key;left=right=null;}
}
class BinarySearchTree {
    NodeSearch root;
    public BinarySearchTree() {root = null;}
    public NodeSearch binarySearch(NodeSearch node , int k) {
       if(node == null || node.key == k) {
           return node;
       }
       if(k < node.key) {
         return binarySearch(node.left, k);
       }
       else {
          return binarySearch(node.right, k);
       }
    }
    public NodeSearch insert(NodeSearch node,int e) {
       if(node == null) {
           NodeSearch new_root = new NodeSearch(e);
           return new_root;
       }
       if(e < node.key) {
           node.left = insert(node.left, e);
       }
       else if(e > node.key) {
           node.right = insert(node.right, e);
       }
       return node;
    }
    public NodeSearch delete(NodeSearch node , int key) {
        if(node == null) {
            return null;
        }
        else if(key < node.key) {
            node.left = delete(node.left, key);
        }
        else if(key > node.key) {
            node.right = delete(node.right, key);
        }
        else {
            if(node.left != null && node.right != null) {
                int max = max(node.left);
                node.key = max;
                node.left = delete(node.left, max);
                return node;
            }
            else if(node.left != null) {
               return node.left;
            }
            else if(node.right != null) {
                return node.right;
            }
            else {
                return null;
            }
        }
        return node;
    }
    private static int max(NodeSearch node) {
        if(node.right != null) {
            return max(node.right);
        } else {
            return node.key;
        }
    }
    public void Pre(NodeSearch node) {
       if(node == null) {
           return;
       }
       System.out.print(node.key+" ");
       Pre(node.left);
       Pre(node.right);
    }
    public void In(NodeSearch node) {
       if(node == null) {
           return;
       }
       In(node.left);
       System.out.print(node.key+" ");
       In(node.right);
    }
    public void Post(NodeSearch node) {
       if(node == null) {
           return;
       }
       Post(node.left);
       Post(node.right);
       System.out.print(node.key+" ");
    }
}


public class BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new NodeSearch(35);
        bst.root.left = new NodeSearch(8);
        bst.root.left.left = new NodeSearch(3);
        bst.root.left.right = new NodeSearch(10);
        bst.root.right = new NodeSearch(152);
        bst.root.right.left = new NodeSearch(43);

        System.out.println("\nPreOrder : ");
        bst.Pre(bst.root);
        System.out.println("\nInOrder : ");
        bst.In(bst.root);
        System.out.println("\nPostOrder : ");
        bst.Post(bst.root);

        // Scanner sc = new Scanner(System.in);
        // System.out.println("\nEnter Key to Search : ");
        // int search = sc.nextInt();
        // NodeSearch found = bst.binarySearch(bst.root, search);
        // if(found != null && found.key == search) {
        //     System.out.println("Found!");
        //  }
        // else {
        //     System.out.println("Not Found!");
        // }

        bst.insert(bst.root, 50);

        System.out.println("\nAfter Inserting : ");
        System.out.println("\nPreOrder : ");
        bst.Pre(bst.root);
        System.out.println("\nInOrder : ");
        bst.In(bst.root);
        System.out.println("\nPostOrder : ");
        bst.Post(bst.root);

        bst.delete(bst.root, 50);

        System.out.println("\nAfter deleting : ");
        System.out.println("\nPreOrder : ");
        bst.Pre(bst.root);
        System.out.println("\nInOrder : ");
        bst.In(bst.root);
        System.out.println("\nPostOrder : ");
        bst.Post(bst.root);


    }
}
