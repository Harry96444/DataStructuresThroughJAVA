import java.util.Iterator;
import java.util.PriorityQueue;

public class Pq {
   public static void main(String[] args) {
       
       PriorityQueue<Integer> p = new PriorityQueue<>();
       System.out.println(p.offer(10));
       System.out.println(p.offer(5));
       System.out.println(p.offer(12));
       System.out.println(p.offer(11));
       System.out.println(p.offer(13));
       System.out.println(p.offer(9));

       Iterator<Integer> it = p.iterator();
       while(it.hasNext()) {
           System.out.print(it.next()+" ");
       }
       System.out.println("Peek : "+p.peek());
       p.poll();
       System.out.println("PriorityQueue : "+p);
       System.out.println("Peek : "+p.peek());
       p.poll();
       System.out.println("PriorityQueue : "+p);
       System.out.println("Peek : "+p.peek());
       p.poll();
       System.out.println("PriorityQueue : "+p);
       System.out.println("Peek : "+p.peek());
   } 
}
