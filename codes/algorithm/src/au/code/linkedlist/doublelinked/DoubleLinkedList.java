package au.code.linkedlist.doublelinked;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Project algorithm
 * @Description: DoubleLinkList
 * @Author
 * @Explain tow way linked list
 * @Date 2021-04-17 13:39
 */
public class DoubleLinkedList {
    public static void main(String[] args) {

        System.out.println("tow way linked list...");

        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.addNodeByOrder(new Node(1,"黄琳",3500));
        doubleLinked.addNodeByOrder(new Node(3,"寒烟",8000));
        doubleLinked.addNodeByOrder(new Node(2,"吴海",5900));
        doubleLinked.addNodeByOrder(new Node(4,"彰武",6000));
        doubleLinked.showNode(doubleLinked.getHead());
/*
        doubleLinked.addNode(new Node(1,"黄琳",3500));
        doubleLinked.addNode(new Node(3,"寒烟",8000));
        doubleLinked.addNode(new Node(2,"吴海",5900));
        doubleLinked.addNode(new Node(4,"彰武",6000));



        doubleLinked.showNode(doubleLinked.getHead());

        System.out.println("later update ..");
        doubleLinked.updateNodeByNumber(new Node(2, 10));
        doubleLinked.showNode(doubleLinked.getHead());

        System.out.println("later delete ...");
        doubleLinked.deleteNodeByNumber(new Node(1));
        doubleLinked.deleteNodeByNumber(new Node(2));
        doubleLinked.deleteNodeByNumber(new Node(3));
        doubleLinked.deleteNodeByNumber(new Node(4));
        */
        System.out.println();
        System.out.println(doubleLinked.findNode(doubleLinked.getHead(),5));

//        System.out.printf("linked list size : %d \n", doubleLinked.getNodeSize(doubleLinked.getHead()));
//        doubleLinked.showNode(doubleLinked.getHead());


    }
}

class DoubleLinked {

    /**
     * create head node , not data is just an index
     */
    private Node head = new Node(0,"",0);


    public Node getHead() {
        return head;
    }

    /**
     * linked list count
     * @param node
     * @return
     */
    public int getNodeSize(Node node){

        int count = 0;

        if (node.next == null) return  count;

        Node temp = head.next;

        while (true) {

            if (temp == null) break;

            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * find linked list node at the back
     * @param node
     * @param index
     * @return
     */
    public Node findNode(Node node,int index){

        if (node.next == null) {
            System.out.println("linked list is not null.");
            return null;
        }

        Node temp = node.next;

        int size = getNodeSize(head);
        if (index <= 0 || index > size) {
            System.out.println("index error it's out of scope");
            return null;
        }

        for (int i = 0; i < size - index;i++) {

            temp = temp.next;
        }



        return temp;
    }

    /**
     * delete node by number
     *      ( by： 根据、按照)
     * @param node
     */
    public void  deleteNodeByNumber(Node node) {

        if (head.next == null) {

            System.out.println("delete failed linkde list is null.");
            return;
        }

        Node temp = head.next;
        Node pre = null;
        Node next = null;
        while (true) {

            if (temp == null) break;

            //when temp.number and node.number equal.
            if (temp.number == node.number) break;

            temp = temp.next;

        }

        if (temp == null) {
            System.out.println("delete failed cant find by number. ");
            return;
        }
        pre = temp.pre;
        next = temp.next;
        temp.pre = null;
        if (next != null) {


            temp.next = null;
//            temp.pre.next = temp.next;
            pre.next = next;
            next.pre = pre;

        }else {
            pre.next = null;
        }
    }




    /**
     * update Node in money data by number
     *      ( by： 根据、按照)
     * @param node
     */
    public void updateNodeByNumber(Node node){

        Node temp = head.next;

        if (temp == null) {
            //更新失败，链表为空。
            System.out.println("update failed，linked list is null.");
            return ;
        }

        while (true) {

            if (temp == null) break;

            if (temp.number == node.number) {// when temp.number and node.number equal
                break;
            }

            temp = temp.next;

        }

        /*
            1、tisp message when temp is null.

            2、update node data when temp is not null


         */
        if (temp == null) {

            System.out.println("update failed can't find number");

        }else {

            temp.money = node.money;

        }


    }


    /**
     * add linked list node
     * @param node
     */
    public void addNode(Node node){

        Node temp = head;

        while (true) {
            if (temp.next == null) break;

            temp = temp.next;
        }

        node.pre = temp;

        temp.next = node;

    }

    /**
     * add linked list in order
     *      (in : 在...里，on：在....上)
     * @param node
     */
    public void addNodeByOrder(Node node){

        Node temp = head;

        while (true) {

            if (temp.next == null) break;
            if (temp.next.number > node.number) break;
            temp = temp.next;
        }
        /*
            insert the node to temp.next
                1、when temp.next is null.
                2、when temp.next is not null

         */
        if (temp.next == null) {

            node.pre = temp;
            temp.next = node;

        }else {

            node.next = temp.next;
            temp.next.pre = node;
            node.pre = temp;
            temp.next = node;
        }










    }

    /**
     * output linked list nodes
     * @param head
     */
    public  void showNode(Node head){

        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        Node temp = head.next;

        while (true) {

            if (temp == null) break;

            System.out.println(temp.toString());

            temp = temp.next;


        }


    }

}


/*
 * @Author: Du Yi Code
 * @Description: to way linkde list 根据实际需求设置节点
 * @Date: 20:19 2021/4/15
 * @Param:
 * @Return:
 */
class Node {

    /**
     * 工号
     */
    public int number;

    /**
     * 称呼
     */
    public String nickName;

    /**
     * 工资
     */
    public double money;

    /**
     * next链表指针域
     */
    public Node next;

    /**
     * pre链表指针域
     */
    public Node pre;

    public Node(int number){
        this.number = number;
    }

    public Node(int number,double money){
        this.number = number;
        this.money = money;
    }

    public Node(int number,String name){
        this.number = number;
        this.nickName = name;
    }


    public Node(int number,String name,double money){
        this.number = number;
        this.nickName = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", nickName='" + nickName + '\'' +
                ", money=" + money +
                '}';
    }
}