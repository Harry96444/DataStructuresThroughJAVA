
// class Circular {

//     private Node last;
//     public Circular() {
//         this.last = null;
//         if(this.last != null) {
//             this.last.next = last;
//         }
//     }
   
//     public void insertAtEnd(int data) {
//         Node n = new Node();
//         n.data = data;
  
//         if(last == null) {
//             n.next = n;
//         }
//         else {
//             n.next = last.next;
//             last.next = n;
//         }
//         last = n;
//     }
//     public void insertAtFirst(int data) {
//         Node n = new Node();
//         n.data = data;
//         if(last == null) {
//             last = n;
//         }
//         else {
//             n.next = last.next;
//             last.next = n;   
//         }
//     }
//     public void insertAtPos(int data, int pos) {
//         Node n = new Node();
//         n.data = data;
//         if(pos == 1) {
//             insertAtFirst(data);
//         }
//         else if(pos == size() + 1) {
//             insertAtEnd(data);
//         }
//         else if(pos > 1 && pos <= size()) {
//             Node curr = last.next;
//             for(int i = 1; i < pos - 1; i++) {
//                 curr = curr.next;
//             }
//             Node t = curr.next;
//             curr.next = n;
//             n.next = t;
//         }
//         else {
//             System.out.println("Invalid position");
//         }
//     }
//     public void deleteAtEnd() {
//         if(last == null) {
//             System.out.println("List is Already Empty!");
//             return;
//         }
//         else if(size() == 1) {
//             last = null;
//         }
//         else {
//             Node curr = last.next;
//            while(curr.next != last){
//                 curr = curr.next;
//             }   
//             curr.next = last.next;
//             last = curr;

//         }
//     }
//     public void deleteAtFirst() {
//         if(last == null) {
//             System.out.println("List is Already Empty!");
//             return;
//         }
//         else if(size() == 1) {
//             last = null;
//         }
//         else {
//             last.next = last.next.next;
//         }
//     }
//     public void deleteAtPos(int pos) {
//         if(pos == 1) {
//             deleteAtFirst();
//         }
//         else if(pos == size()) {
//             deleteAtEnd();
//         }
//         else if(pos > 1 && pos < size()) {
//             Node curr = last.next;
//             for(int i = 1; i < pos - 1; i++) {
//                 curr = curr.next;
//             }
//             Node t1 = curr.next.next;
//             curr.next = t1;
//         }
//         else {
//             System.out.println("Invalid position");
//         }
//        }   
    
//     public void insertBefore(int data,int pos) {
//         if(pos < 1) {
//             System.out.println("Invalid size!");
//         }
//         else if(pos == 1){
//              insertAtFirst(data);
//         }
//         else if(pos == size() + 1) {
//              insertAtEnd(data);
//         }
//         else {
//             Node n = new Node(data,null);
//             Node curr = last.next;
//             for(int i = 1; i < pos - 1; i++) {
//                  curr = curr.next;
//             }
//             Node t1 = curr.next;
//             curr.next = n;
//             n.next = t1;
//         }
//     }
//     public void insertAfter(int data,int pos) {
//         if(pos < 1) {
//             System.out.println("Invalid size!");
//         }
//         else if(pos == 1){
//              insertAtFirst(data);
//         }
//         else if(pos == size() + 1) {
//              insertAtEnd(data);
//         }
//         else {
//             Node n = new Node(data,null);
//             Node curr = last.next;
//             for(int i = 1; i < pos; i++) {
//                  curr = curr.next;
//             }
//             Node t1 = curr.next;
//             curr.next = n;
//             n.next = t1;
//         }
//     }
//     public void deleteBefore(int pos) {
//         if(pos == 1) {
//             deleteAtFirst();
//         }
//         else if(pos == size()) {
//             deleteAtEnd();
//         }
//         else if(pos > 1 && pos < size()) {
//             Node curr = last.next;
//             for(int i = 1; i < pos - 2; i++) {
//                 curr = curr.next;
//             }
//             Node t1 = curr.next.next;
//             curr.next = t1;
//         }
//         else {
//             System.out.println("Invalid position");
//         }
//     } 
//     public void deleteAfter(int pos) {
//         if(pos == 1) {
//             deleteAtFirst();
//         }
//         else if(pos == size()) {
//             deleteAtEnd();
//         }
//         else if(pos > 1 && pos < size()) {
//             Node curr = last.next;
//             for(int i = 1; i < pos; i++) {
//                 curr = curr.next;
//             }
//             Node t1 = curr.next.next;
//             curr.next = t1;
//         }
//         else {
//             System.out.println("Invalid position");
//         }
//     }  



//     public int size() {
//         int count = 0;
//         Node curr = last.next;
//         while(curr != last) {
//             count++;
//             curr = curr.next;
//         }
//         return count;
//     }
//     public void printList() {
//         if(last == null) {
// 			System.out.println("List is Empty!");
//             return;
// 		}
// 		Node first = last.next;
// 		while(first != last) {
// 			System.out.print(first.data + " --> ");
// 			first = first.next;
// 		}
// 		System.out.print(first.data);
//     }
    
//     private class Node {
//         private int data;
//         private Node next;

//         public Node() {
//             data = 0;
//             next = null;
//         }
//         public Node(int data, Node next) {
//             this.data = data;
//             this.next = next;
//         }
//     }



// }
// public class CircularSingleLL {
//     public static void main(String[] args) {
//         Circular c = new Circular();
//         c.insertAtEnd(2);
//         c.insertAtEnd(3);
//         c.insertAtEnd(4);
//         c.insertAtFirst(13);
//         c.insertAtFirst(12);
//         c.insertAtFirst(11);
//         c.insertAtEnd(14);
//         c.insertAtEnd(15);
//         c.insertAtEnd(16);
//         // 11 12 13 2 3 4 14 15 16
//         System.out.println();
//         c.printList();
//         System.out.println();
//         c.deleteAfter(7);
//         System.out.println();
//         c.printList();
//         // 11 12 13 2 3 4 15 16
//     }
// }
