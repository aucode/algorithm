package au.code.queue.array;

import au.code.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @Project algorithm
 * @Description: QueueArray
 * @Author
 * @Explain
 * @Date 2021-04-15 12:01
 */
public class QueueArray {
    public static void main(String[] args) {

        Queue queue = new Queue(3);

        Menu o = new Menu();
        char key = ' ';         //保存键盘输入的数据
        boolean flag = true;    //循环判断
        Scanner scanner = new Scanner(System.in);   //键盘输入

        while (flag){
            Object[] msg = new String[]{"a：添加队列","g：取出队列","h：获取头队列","s：显示队列","e：程序队列"};
            o.menu(msg);
            o.println("请输入...");
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    o.println("请输入添加的数字！");
                    queue.addQueue(scanner.nextInt());
                    /*
                    try {
                        int val = scanner.nextInt();


                    }catch (InputMismatchException e) {
                        System.out.println("添加失败，请输必须是整数，操作已结束！");
                        break;
                    }
                    */
                    break;
                case 'g':
                    try {

                        Object val = queue.getQueue();
                        System.out.printf("%d 出队成功 ! \n", val);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        Object head = queue.headQueue();
                        System.out.printf("队头元素未 %d ! \n", head);

                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'e':

                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束~~~");
    }
}

class Queue {

    private int maxSize;//数组大小
    private int front;//头指针（出）
    private int rear;//尾指针（进）
    private Object[] arr;

    //初始化队列
    public Queue(int size) {

        this.maxSize = size;
        this.arr = new Object[this.maxSize];
        this.front = this.rear = -1;
    }

    public Queue(){

        this(2);

    }

    //判断是否为空
    public boolean isFull() {

        return this.rear == this.front;
    }

    //判断是否未满
    public boolean isEmpty() {

        return this.rear == maxSize - 1;
    }

    public boolean addQueue(int val) {
        if (isEmpty()) {

            System.out.println("添加失败，队列已满！");
            return false;
        }

        this.arr[++this.rear] = val;
        return true;

    }

    public Object getQueue() {

        if (isFull()) {

            throw new RuntimeException("队列为空，出队失败");
        }

        return this.arr[++front];
    }

    public Object headQueue() {

        if (isFull()) {
            throw new RuntimeException("队列为空，无数据~~~");
        }
        return arr[this.front + 1];
    }

    public void showQueue() {
        if (isFull()) {

            System.out.println("队列为空，无数据。");
            return ;
        }
        int count = 0;
        for (int i = this.front + 1; i <= this.rear; i++) {
            System.out.printf("arr[%d] = %d \t", count++, arr[i]);


        }
        System.out.println();
    }


}