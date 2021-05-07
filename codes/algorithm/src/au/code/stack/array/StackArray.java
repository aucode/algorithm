package au.code.stack.array;


/**
 * @Project algorithm
 * @Description: StackArray
 * @Author
 * @Explain
 * @Date 2021-04-20 15:02
 */
public class StackArray {

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.showStack();
        System.out.println(stack.getTopValue());
//        stack.push(6);

//        stack.put
    }
}

class Stack {

    private int val;

    private int size;

    private int top;

    private int[] stack;

    public Stack(int size) {

        this.size = size;

        /*
            stack top pointer default -1
         */
        this.top = -1;

        this.stack = new int[this.size];

    }

    /**
     * stack is full
     * @return
     */
    public boolean isFull(){

        return this.top == this.size -1;
    }

    /**
     * stack is empty
     * @return
     */
    public boolean isEmpty(){
        return this.top == -1;
    }

    /**
     * Push element in stack.
     * @param val
     */
    public void push(int val) {

        if (isFull()) {
            System.out.println("error: push fail stack is full.");
            return;
        }

        this.stack[++this.top] = val;
    }

    /**
     * Pop val element of stack.
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            System.out.println("error: pop fail stack id empty.");
            return -1;
        }

        /*
            return stack top element and top pointer minus one.

         */
        return this.stack[this.top--];
    }

    /**
     * return stack top element.
     * @return
     */
    public int getTopValue(){
        return this.stack[this.top];
    }


    /**
     * output stack in data.
     */
    public void showStack() {

        if (isEmpty()) {

            System.out.println("stack is null.");
            return;
        }


        for (int i = this.top;i >= 0;i--) {

            System.out.printf("stack[%d] = %d \n",i,stack[i]);

        }


    }
}


