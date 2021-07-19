class PqueueDs {
    int MAX;
    int size;
    int pq[];

    PqueueDs(int MAX) {
       this.MAX = MAX;
       size = 0;
       pq = new int[MAX];
    }
    public void offer(int data) {
        int i;
        if(isEmpty()) {
            pq[0] = data;
            size++;
        }
        else {
            for(i = size - 1; i >= 0; i--) {
                if(data > pq[i]) {
                    pq[i+1] = pq[i];
                }
                else {
                    break;
                }
            }
            pq[i+1] = data;
            size++;
        }
    }
    public int poll() {
        if(isEmpty()) {
            System.out.println("Priority Queue is already filled!");
            return -1;
        }
        else {
            int ret;
            size--;
            ret = pq[size];
            pq[size] = 0;
            return ret;
        }
    }
    public boolean isFull() {
        return size == MAX;
    }
    public int peek() {
        return pq[size - 1];
    }
    public boolean isEmpty() {
        return size <=0;
    }
    public void print() {
        System.out.print("() ");
        for (int i = 0; i < pq.length; i++) {
            System.out.print(pq[i]+" ");
        }
        System.out.print("()");
    }


}

class PriorityQueue {
    public static void main(String[] args) {
        PqueueDs p = new PqueueDs(5);
        p.offer(10);
        p.offer(30);
        p.offer(5);
        p.offer(8);
        p.offer(29);
        p.print();
        // // 30 29 10 8 5
        System.out.println("Peek : "+p.peek());
        System.out.println("\nPoll : "+p.poll());
        p.print();
        System.out.println("Peek : "+p.peek());
        System.out.println("\nPoll : "+p.poll());
        p.print();
        System.out.println("Peek : "+p.peek());

        // System.out.println("\nPeek Element : "+p.peek());
        // System.out.println(p.poll());
        // System.out.println("Peek Element : "+p.peek());
        // // System.out.println(p.poll());
        // // System.out.println(p.poll());
        // // System.out.println();
        // p.print();
    }
}