import java.util.Scanner;

class Linkedlist {
    
    Node head; 

    public Linkedlist() {
        head = null;
    }
    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        else {
            return false;
        }
    }
    public int getListSize() {
        Node curr = head;
        int count = 0;
        while(curr!=null) {
            count++;
            curr = curr.getNext();
        }
        return count;
    }
    public void printList() {
        
       if(isEmpty()) {
           System.out.println("No items in LinkedList");
       }
       else {

           Node temp = head; 
           System.out.print("head --> ");
           while(temp!=null) {
               System.out.print(temp.getData()+" --> ");
               temp = temp.getNext();
           }
           System.out.print("null");
       }  
    }
    public void insertAtFirst(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(head);
        head = newNode;
    }
    public void insertAtEnd(int data) {
       Node newNode = new Node();
       Node temp = head;
       if(temp == null) {
           newNode.data = data;
           head = newNode;
       }
       else {
           while(temp.next != null) {
              temp = temp.next;
           }
           newNode.data = data;
           temp.next = newNode;
       }
    }
    public void insertAtPos(int data, int position) {
         if(position == 1) {
             insertAtFirst(data);
         } else if(position == getListSize() + 1) {
             insertAtEnd(data);
         } else if(position > 1 && position <= getListSize()) {
             Node newNode  = new Node();
             Node curr = head;
             for(int i = 1; i < position-1; i++) {
                 curr = curr.next;
             }
             newNode.data = data;
             newNode.next = curr.next;
             curr.next = newNode;
         }
         else {
             System.out.println("Not Possible to insert");
         }
    }
    public void deleteFirst() {
        if(head == null) {
            System.out.println("\nList is Already Empty");
        }
        else {
            head = head.getNext();
        }
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("List is Already Empty");
        }
        else if(getListSize() == 1) {
            head = null;
        }
        else {
            Node temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }
    public void deleteAtPos(int position) {
        if(head == null) {
            System.out.println("List is Already Empty");
        }
        else if(position < 1 || position > getListSize()) {
            System.out.println("Invalid Position");
        }
        else if(position == 1) {
            deleteFirst();
        }
        else if(position == getListSize()) {
            deleteLast();
        }
        else {
            Node t = head;
            for(int i = 1; i < position - 1; i++) {
                t = t.getNext();
            }
           Node t1 = t.next;
           t.next = t1.next;
        }
    }
    public int getNthNodeFromEnd(int n) {
        if(head == null) {
			return 0;
		}

		if(n <= 0 || getListSize() < n) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
        
        Node temp = head;
        int l = getListSize();

        for(int i = 1; i < l - n + 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public int getMiddleNode() {
        Node curr = head;
		if(curr == null) {
			return 0;
		}
            Node slowPtr = curr;
		    Node fastPtr = curr;
             while(fastPtr != null && fastPtr.getNext() != null) {
			 slowPtr = slowPtr.getNext();
			 fastPtr = fastPtr.getNext().getNext();
		   }
       return slowPtr.getData();
	}
    public boolean containsLoop() {
      Node slow = head;
      Node fast = head;
      while(fast != null && fast.getNext().getNext() != null) {
          fast = fast.getNext().getNext();
          slow = slow.getNext();
          if(fast == slow) {
              return true;
          }
      }
      return false;
    } 
    public int search(int key) {
        int s = -1;
        Node curr = head;
        for(int i = 1; i <= getListSize(); i++){
            if(curr.getData() == key) {
                s = i;
                return s;
            }
            curr = curr.getNext();
        }
        return s;
    }
    public void reverseList(){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public int getStartingLoopNode() {
        Node slow = head;
        Node fast = head;
        Node entry = head; 
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(slow != entry) {
                   slow = slow.next;
                   entry = entry.next; 
                }
                return entry.getData();
            }
        }
        
        return 0;
        
    }
    public void removeLoop1() {
		Node fastPtr = head;
		Node slowPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr) {
				removeLoop2(slowPtr);
				return;
			}
		}
	}
	public void removeLoop2(Node slowPtr) {
		Node temp = head;
		while(temp.next != slowPtr.next){
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

    private static class Node {
       int data;
       Node next;
       public Node() {
           data = 0;
           next = null;
       }
       public Node(int data,Node next) {
           this.data = data;
           this.next = next;
       }
       public int getData() {
            return this.data;
       }
       public void setData(int data) {
            this.data = data;
       }
       public Node getNext() {
            return this.next;
       }
       public void setNext(Node next) {
            this.next = next;
       }
    }
}
class LLDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist ll = new Linkedlist();
        System.out.println("\n\n11. Search in a List ?\n10. Reverse a List\n1. Show List\n2. Insert at first\n3. Insert at end\n4. Insert at Position\n5. Delete at first\n6. Delete at end\n7. Delete at Position\n8. Check List size\n9. Check Empty");
        String ch = "";
        do {
                 System.out.println("\nEnter your choice :");
                 int c = sc.nextInt();
               switch(c) {
                   case 1 : ll.printList();break;
                   case 2 : System.out.println("\nEnter the data:"); 
                            ll.insertAtFirst(sc.nextInt());break;
                   case 3 : System.out.println("\nEnter the data:"); 
                            ll.insertAtEnd(sc.nextInt());break;
                   case 4 : System.out.println("\nEnter the data & position:"); 
                            ll.insertAtPos(sc.nextInt(),sc.nextInt());break;
                   case 5 : ll.deleteFirst();break;
                   case 6 : ll.deleteLast();break;
                   case 7 : System.out.println("\nEnter the data & position:"); 
                            ll.deleteAtPos(sc.nextInt());break;
                   case 8 : System.out.println("List Size :"+ll.getListSize());break;
                   case 11 : System.out.println("\nEnter Key to Search:"); 
                             int key = sc.nextInt(); 
                             System.out.println("Node found At Position "+ll.search(key));break; 
                   case 9 : if(ll.isEmpty()) {System.out.println("\nList is empty");} else{System.out.println("\nList is Not Empty");}break;
                   case 10 : ll.reverseList(); ll.printList();break;
                   case 12 : System.out.println("Middle Node is : "+ll.getMiddleNode());break;
                   case 13 : System.out.println("\nEnter n to get Nth node from end:"); 
                             int n = sc.nextInt(); 
                             System.out.println("Nth Node from end is : "+ll.getNthNodeFromEnd(n));break;
                   case 14 : System.out.println("LinkedList Contains Loop : "+ll.containsLoop());break;
                   default : System.out.println("\nPlease Enter Correct Option!");
               }
               System.out.println("\nDo You Want to Continue ?");
               ch = sc.next();
           } while (ch.equalsIgnoreCase("y"));
        
    }
}
