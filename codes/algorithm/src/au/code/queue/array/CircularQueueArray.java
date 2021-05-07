package au.code.queue.array;


import au.code.Menu;

import java.util.Scanner;


/**
 * @Project algorithm
 * @Description: CircularQueueArray
 * @Author
 * @Explain
 * @Date 2021-04-14 19:34
 */
public class CircularQueueArray {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

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
class CircularQueue {

    private Object arr[];  //数组
    private int rear;     //尾（进，所指向得到位置为空）
    private int front;    //头（出）
    private int maxSize;  //最大值



    public CircularQueue(){

        this(8);

    }

    public CircularQueue(int size){

        //初始化队列数组
        this.maxSize = size;
        this.front = this.rear = 0;
        this.arr = new Object[this.maxSize];

    }

    /**
     * 添加
     * @param val
     */
    public void addQueue(int val){
        if(isEmpty()){
            System.out.println("添加失败，队列已满！");
            return ;
        }
        this.arr[this.rear] = val;
        //当指针超过数组下标，复位从头开始技数。
        this.rear = (this.rear + 1) % maxSize;
    }

    /**
     * 出队
     * @return
     */
    public Object getQueue(){
        if(isFull()){

            throw new RuntimeException("队列为空，出队失败");
        }

        Object headVal = this.arr[this.front];
        //当指针超过数组下标，复位从头开始技数。
        this.front = (this.front + 1) % maxSize;
        return headVal;

    }


    /**
     * 判空
     * @return
     */
    public Boolean isFull(){
        return this.rear == this.front;
    }

    /**
     * 判满
     * @return
     */
    public Boolean isEmpty(){
        return (this.rear + 1) % maxSize == this.front;
    }
    /**
     * 显示队列
     */
    public void showQueue(){

        if (isFull()) throw new RuntimeException("队列为空，出队失败");
        //从哪里开始，要遍历多少个
        int count = 0;
        for (int i = this.front; i < this.front + size();i++){
            System.out.printf("arr[%d] = %d \t",count++,arr[i % maxSize]);
        }
        System.out.println();
    }

    public int size(){
        return (this.rear + maxSize - this.front) % maxSize;
    }

    /**
     * 队头
     * @return
     */
    public Object headQueue(){
        if (isFull()){
            throw new RuntimeException("无数据，队列为空!");
        }
        return this.arr[this.front];
    }










}