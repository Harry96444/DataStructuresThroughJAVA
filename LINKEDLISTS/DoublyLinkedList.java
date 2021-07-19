// import java.util.Scanner;

// import javafx.scene.chart.PieChart.Data;

// class DoubleList {

//      Node head;
//      Node tail;

//     public DoubleList() {
//         head = null;
//         tail = null;
//     }    
//      public int size() {  // return size
//          int count = 0;
//          Node curr = head;
//          while(curr != null) {
//              count++;
//              curr = curr.next;
//          }
//         return count;
//      }
//      public boolean isEmpty() {  // return isEmpty or Not
//          if(size() >= 1) {
//              return false;
//          }
//          return true;
//      }
//      public void printForward() { // print list forward
//          if(head == null) {
//              System.out.print("Empty List");
//              return;
//          }
//          else {
//              Node curr = head;
//              System.out.print("head --> ");
//              while(curr != null) {
//                  System.out.print(curr.data +" --> ");
//                  curr = curr.next;
//              }
//              System.out.print("null");
//          }
//      }
//      public void printBackward() { // print List Backward
//          if(head == null) {
//              System.out.print("Empty List");
//              return;
//          }
//          else {
//              Node curr = tail;
//              System.out.print("head --> ");
//              while(curr != null) {
//                  System.out.print(curr.data +" --> ");
//                  curr = curr.prev;
//              }
//              System.out.print("null");
//          }
//      }
//      public void insertAtFirst(int data) { // insert at first
//         Node n = new Node();
//         if(isEmpty()) {
//            n.data = data;
//            head = tail = n;
//         }
//         else {
//            n.data = data;
//            n.next = head;
//            head.prev = n;
//            head = n;
//         }
//      }
//      public void insertAtLast(int data) {  // insert at last
//         Node n = new Node();
//         if(isEmpty()) {
//            n.data = data;
//            head = tail = n;
//         }
//         else {
//            n.data = data;
//            tail.next = n;
//            n.prev = tail;
//            tail = n;
//         }
//      }
//      public void insertAtPos(int data, int pos) { // insert at pos
//          if(pos == 1) {
//              insertAtFirst(data);
//          }
//          else if(pos == size() + 1) {
//             insertAtLast(data);
//          }
//          else if(pos > 1 && pos <= size()) {
//              Node n = new Node();
//              n.data = data;
//              Node curr = head;
//              for (int i = 1; i < pos - 1; i++) {
//                  curr = curr.next;
//              }
             
//          }
//      }
//      public void deleteAtFirst() { // delete first
//          if(isEmpty()) {
//              System.out.println("List is Already Empty");
//          }
//          else {
//              head = head.next;
//          }
//      }
//      public void deleteAtLast() { // delete last
//          if(isEmpty()) {
//              System.out.println("Empty List");
//          }
//          else if(size() == 1) {
//              head = tail = null;
//          }
//          else {

//              Node curr = tail;
//              Node prev = tail.prev;
//              curr.prev = null;
//              prev.next = null;
//              tail = prev;
//          }
//      }
//      public void deleteAtPos(int pos) {
//          if(isEmpty()) {
//              System.out.println("Empty List");
//          }
//          else if(size() == 1 || pos == 1) {
//              deleteAtFirst();
//          }
//          else if(size() == pos) {
//              deleteAtLast();
//          }
//          else if(pos > 1 && pos < size()) {
//              Node curr = head;
//              for(int i = 1; i < pos-1; i++) {
//                  curr = curr.next;
//              }
//              Node temp = curr.next;
//              Node nextnext = temp.next;
//              curr.next = nextnext;
//              nextnext.prev = curr;

//          }
//      }
//      public void addNodeBefore(int data, int pos) {
//          Node n = new Node();
//          n.data = data;
//          Node curr = head;
//          for(int i = 1; i < pos - 1; i++) {
//              curr = curr.next;
//          }
//          Node temp = curr.next;
//          curr.next = n;
//          n.prev = curr;
//          n.next = temp;
//          temp.prev = n; 
//      }
//      public void addNodeAfter(int data, int pos) {
//          Node n = new Node();
//          n.data = data;
//          Node curr = head;
//          for(int i = 1; i < pos; i++) {
//              curr = curr.next;
//          }
//          Node temp = curr.next;
//          curr.next = n;
//          n.prev = curr;
//          n.next = temp;
//          temp.prev = n; 
//      }
//      public void deleteNodeBefore(int pos) {
//          Node curr = head;
//          for(int i = 1; i < pos; i++) {
//              curr = curr.next;
//          }
//          Node temp = curr.prev.prev;
//          curr.prev = temp;
//          temp.next = curr;
//      }
//      public void deleteNodeAfter(int pos) {
//          Node curr = head;
//          for(int i = 1; i < pos; i++) {
//              curr = curr.next;
//          }
//          Node temp = curr.next.next;
//          curr.next = temp;
//          temp.prev = curr;
//      }

//      class Node {
//          int data;
//          Node next;
//          Node prev;
//          public Node (){
//              data = 0;
//              next = null; 
//              prev = null;
//          }
//          public Node(int data, Node next, Node prev) {
//              this.data = data;
//              this.next = next;
//              this.prev = prev;
//          }

//      }
// }


// public class DoublyLinkedList {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         DoubleList dll = new DoubleList();
//         System.out.println("\n\nSize : "+dll.size()+" Is Empty : "+dll.isEmpty());
//         dll.insertAtFirst(4);
//         dll.insertAtFirst(3);
//         dll.insertAtLast(5);
//         dll.insertAtLast(6);
//         dll.insertAtLast(7);
//         dll.insertAtLast(8);
//         dll.insertAtLast(9);
//         // 3 4 5 6 7 8 9 
//         System.out.println("\n\nSize : "+dll.size()+" Is Empty : "+dll.isEmpty());
//         System.out.println();
//         dll.printForward();
//         // System.out.println();
//         // dll.printBackward();
//         // System.out.println();
//         // dll.deleteAtLast();
//         // System.out.println();
//         // dll.printForward();
//         // System.out.println("\nEnter the position to delete :");
//         // int n = sc.nextInt();
//         // dll.deleteAtPos(n);
//         // System.out.println();
//         // dll.printForward();

//         System.out.println("\nEnter the position to delete before the node :");
//         int n = sc.nextInt();
//         dll.deleteNodeBefore(n);
//         System.out.println();
//         dll.printForward();

//         System.out.println("\nEnter the position to delete after the node :");
//         int n1 = sc.nextInt();
//         dll.deleteNodeAfter(n1);
//         System.out.println();
//         dll.printForward();

//         // System.out.println("\nEnter the data and position to add after the node :");
//         // int data1 = sc.nextInt();
//         // int n2 = sc.nextInt();
//         // dll.addNodeAfter(data1,n2);
//         // System.out.println();
//         // dll.printForward();
//     }
// }
