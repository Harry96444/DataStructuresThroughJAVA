class DoublyQueue {
      int size;
      int front;
      int rear;
      int doublequeue[];

      public DoublyQueue(int size) {
          this.size = size;
          front = 0;
          rear = 0;
          doublequeue = new int[size];
      }

      public void offerFirst(int data) {
          doublequeue[rear] = data;
          rear++;
      }
      public void offerLast(int data) {
          int t = size-1;
          doublequeue[t--] = data;
      }
      public void printQueue() {
          System.out.print("() ");
          for(int i = front; i < size; i++) {
              System.out.print(doublequeue[i]+" ");
          }
          System.out.print("()");
      }

}

public class QueueDoublyEnded {
    public static void main(String[] args) {
        DoublyQueue d = new DoublyQueue(5);
        d.offerFirst(10);
        d.offerLast(20);
        d.printQueue();
 
        System.out.println();

        d.offerFirst(30);
        d.offerLast(40);
        d.printQueue();
    }
}
