// class CircularDoublyLinkedList{  
        
//     Node head;

//     public CircularDoublyLinkedList() {
//         head = null;
//     }
//     public int size() {
//         int count = 0;
//         Node curr = head;
//         while(curr != null) {
//             count++;
//             curr = curr.next;
//         }
//         return count;
//     }
//     public boolean isEmpty() {
//         if(head == null) 
//            return true;
//         return false;   
//     }
//     public void addAtLast(int data) {
//         Node n = new Node(data,null,null);
//         if(head == null) {
//             n.next = n.prev = n;
//             head = n;
//         }
//         else {
//             Node existing = head.prev;
//             n.next = head;
//             head.prev = n;
//             n.prev = existing;
//             existing.next = n;
//         }
//     }
//     public void printForw() {
//         Node curr = head;
//         System.out.print("head --> ");
//         while(curr.next != head) {
//             System.out.print(curr.data+" --> ");
//             curr = curr.next;
//         }
//         System.out.println(curr.data);
//     }
//     public void printBack() {
//         Node curr = head.prev;
//         Node t = curr;
//         System.out.print("head --> ");
//         while(curr.prev != t) {
//             System.out.print(curr.data+" --> ");
//             curr = curr.prev;
//         }
//         System.out.print(curr.data);
//     }
//     private class Node {
//         int data;
//         Node next;
//         Node prev;
//         public Node() {
//             this.data = 0;
//             this.next = null;
//             this.prev = null;
//         }
//         public Node(int data, Node next, Node prev) {
//             this.data = data;
//             this.next = next;
//             this.prev = prev;
//         }
//     }
// }

// class Main {
//     public static void main(String[] args) {
//         CircularDoublyLinkedList cdd = new CircularDoublyLinkedList();
//         cdd.addAtLast(10);cdd.addAtLast(20);cdd.addAtLast(30);cdd.addAtLast(40);
//         cdd.printForw();
//         System.out.println();
//         cdd.printBack();
//     }
// }