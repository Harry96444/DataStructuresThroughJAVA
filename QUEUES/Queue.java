

class QueueDataStructure {
    int front;
    int rear;
    int size;
    int queue[];

    public QueueDataStructure(int size) {
        front = 0;
        rear = 0;
        this.size = size;
        queue = new int[size];
    }
    public boolean enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue is already Filled!");
            return false;
        }
        else {
            queue[rear] = data;
            rear = (rear + 1);
            return true; 
        }
        
    }
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty !");
            return -1;
        }
        else {
           int d = queue[front];
           front = front + 1;
           return d;
        }
    }
    public void showQueue() {
        System.out.print("() ");
        for(int i = front; i < queue.length; i++) {
           System.out.print(queue[i]+" ");
        }
        System.out.print("()");
    }
    public int size() {
       return rear;
    }
    public boolean isEmpty() {
        return rear <= 0;
    }
    public boolean isFull() {
        return rear == size;
    }
    public int peak() {
        return queue[front];
    }
}

public class Queue {
    public static void main(String[] args) {
        QueueDataStructure q = new QueueDataStructure(5);
        System.out.println("Size : "+q.size());
        System.out.println("Is Empty ? : "+q.isEmpty());
        System.out.println("Is Full ? "+q.isFull());
        System.out.println("Front Element : "+q.peak());
        q.enqueue(10);q.enqueue(20);q.enqueue(30);q.enqueue(40);q.enqueue(50);
        q.enqueue(60);
        q.dequeue();
        System.out.println();
        q.showQueue();
        System.out.println("\n\nSize : "+q.size());
        System.out.println("Is Empty ? : "+q.isEmpty());
        System.out.println("Is Full ? "+q.isFull());
        System.out.println("Front Element : "+q.peak());
       
        
    }
}
