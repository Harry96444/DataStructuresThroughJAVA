class Node{ 
    char key;
    Node left;
    Node right;
    public Node(char key) {
        this.key = key;
        left = null;
        right = null;
    }
    public char getKey() {
        return this.key;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    
}

class BinaryT {
    Node root;
    public BinaryT() {
        root = null;
    }
    public void preOrder(Node node) {
       if(node == null) {
           return;
       }
       System.out.print(node.getKey()+" ");
       preOrder(node.getLeft());
       preOrder(node.getRight());
    }
    public void inOrder(Node node) {
       if(node == null) {
           return;
       }
       inOrder(node.getLeft());
       System.out.print(node.getKey()+" ");
       inOrder(node.getRight());
    }
    public void postOrder(Node node) {
       if(node == null) {
           return;
       }
       postOrder(node.getLeft());
       postOrder(node.getRight());
       System.out.print(node.getKey()+" ");
    }
}



public class BinaryTrees {
    public static void main(String[] args) {
       BinaryT bt = new BinaryT();
       bt.root = new Node('F');
       bt.root.left = new Node('B');
       bt.root.right = new Node('G');
       bt.root.left.left = new Node('A');
       bt.root.left.right = new Node('D');
       bt.root.left.right.left = new Node('C');
       bt.root.left.right.right = new Node('E');
       bt.root.right.right = new Node('I');
       bt.root.right.right.left = new Node('H');
       System.out.println("\nPreOrder : ");
       bt.preOrder(bt.root);
       System.out.println("\nInOrder : ");
       bt.inOrder(bt.root);
       System.out.println("\nPostOrder : ");
       bt.postOrder(bt.root);
    }
}
