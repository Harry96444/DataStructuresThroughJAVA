public class StackDs {
     
    private int[] stack;
    private int size;
    private int top;

    public StackDs(int size) {
        this.size = size;
        stack = new int[this.size];
        top = 0;
    }

    public void push(int data) {
        if(isFull()) {
            expand();
            stack[top++] = data;
        }
        else {
            stack[top++] = data;
        }
    }
    public void expand() {
        int newstack[] = new int[size*2];
        System.arraycopy(stack, 0, newstack, 0, stack.length);
        stack = newstack;
        size *= 2;
    }
    public int pop() {
       if(isEmpty()) {
           System.out.println("Stack is already Empty!");
           return -1;
       }
       top--; 
       int ret =  stack[top];
       stack[top] = 0;
       return ret;
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[top-1];
    }
    public Boolean isEmpty() {
        return top <= 0;
    }
    public int size() {
        return top;
    }
    public boolean isFull() {
        return top == size;
    }
    public void print() {
        for(int i = stack.length-1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
    
     public static void main(String[] args) {
         StackDs s = new StackDs(6);
         s.push(30);s.push(20);s.push(10);
         s.push(40);s.push(50);s.push(60);s.push(70);
         
         s.print();
         System.out.println("Popped :"+s.pop());
         System.out.println();
         s.print();
        

         



     }
}
