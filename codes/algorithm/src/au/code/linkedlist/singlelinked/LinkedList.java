package au.code.linkedlist.singlelinked;

/**
 * @Project algorithm
 * @Description: LinkedList
 * @Author
 * @Explain linked list，the content inculdes  number nick name money
 * @Date 2021-04-15 20:18
 */
public class LinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        System.out.println("链表添加数据节点！");
        singleLinkedList.addNode(new Node(1,"黄琳",3500));
        singleLinkedList.addNode(new Node(3,"寒烟",8000));
        singleLinkedList.addNode(new Node(2,"吴海",5900));
        singleLinkedList.addNode(new Node(4,"彰武",6000));
        singleLinkedList.showLinkedList();

        /*




        System.out.println("顺序添加数据节点！");
        singleLinkedList.addNodeByOrder(new Node(1,"黄琳",3500));
        singleLinkedList.addNodeByOrder(new Node(3,"寒烟",8000));
        singleLinkedList.addNodeByOrder(new Node(2,"吴海",5900));
        singleLinkedList.addNodeByOrder(new Node(4,"吴海",6000));
        singleLinkedList.showLinkedList();

        System.out.println("修改数据节点！");
        singleLinkedList.updateNode(new Node(4,9000));
        singleLinkedList.showLinkedList();

        System.out.println("删除数据节点！");
        singleLinkedList.deleteNode(1);
        singleLinkedList.deleteNode(2);
        singleLinkedList.deleteNode(3);
        singleLinkedList.deleteNode(4);

        singleLinkedList.showLinkedList();
        */

        /*
            求链表有效节点的个数.
                注意带头节点、不带头结点的区别。


        System.out.printf("求链表有效节点的个数为：%d\n" , singleLinkedList.gteValidNode(singleLinkedList.getHead()));
        */

        /*
                查找链表倒数第 n 个节点 findNode

        System.out.printf("倒数第%d个节点为：", 3);
        System.out.println(singleLinkedList.findNode(singleLinkedList.getHead(),3));
        */
        System.out.println("linkedlist 反转 后");
        singleLinkedList.reverseLinkedList(singleLinkedList.getHead());

        singleLinkedList.showLinkedList();





    }
}

/**
* @Author: Du Yi Code
* @Description:  单项链表
* @Date: 20:40 2021/4/15
* @Param:
* @Return:
*/
class SingleLinkedList {

    //创建一个头节点，不存放数据 (一般直接不操作)
    private Node head = new Node(0,"",0.0);

    public Node getHead() {
        return head;
    }

    /**
     * linkedlist 反转
     * @param node
     */
    public void reverseLinkedList(Node node){

        //当linked list为空 或者只有一个元素时不用发转
        if (node.next == null || node.next.next == null) return;

        Node reverseNode = new Node(0,"",0.0);
        Node next = null;
        Node temp = node.next;


        while (temp != null) {

            next = temp.next;

            temp.next = reverseNode.next;//把翻转后的linkedlist 保存起来

            reverseNode.next = temp;//把当前节点放到翻转的linked list 的第一个位置（reverseNode.next 永远是指头节点的next）

            temp = next;
        }
        node.next = reverseNode.next;


    }



    /**
     * (带头结点)查找链表倒数第 n 个节点 findNode
     * @param node 带查找LinkedList
     * @param index 查找位置
     * @return
     */
    public Node findNode(Node node, int index){

        int size = gteValidNode(node);

        Node temp = node.next;

        if( index <= 0 || index > size ) return null;

        for (int i = 0; i < size - index; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 带头结点linkedList 的 有效节点个数。
     * @param node
     * @return
     */
    public int gteValidNode(Node node){

        int count = 0;//统计节点个数
        if(node.next == null) return count;

        Node temp = node.next;
        while ( temp != null) {

            count++;
            temp = temp.next;

        }


        return count;
    }



    /**
     * 修改节点,根据工号，修改money
     */
    public void updateNode(Node node) {

        if (head.next == null) {
            System.out.printf("链表为空~~ \n");
            return ;
        }

        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null){
                break;
            }
            if (temp.number == node.number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.money = node.money;
        } else {
            System.out.printf("找不到工号： %d 的数据\n", node.number);
        }

    }

    /**
     * 删除节点
     */
    public void deleteNode(int number){
        if (head.next == null) {
            System.out.printf("链表为空~~ \n");
            return ;
        }
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            if (temp.next.number == number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {//Java垃圾回收机制，自动回收
            temp.next = temp.next.next;
        } else {
            System.out.printf("找不到工号： %d 的数据\n", number);
        }
    }

    /**
     * 按顺序添加
     * @param node
     */
    public void addNodeByOrder(Node node){
        /*
            1.找到插入位置,注意 head 本身无数据，
                head.next 开始才有数据。
         */
        Node temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.number > node.number) {//则插入temp 位置
                break;
            }
            if (temp.next.number == node.number) {
                System.out.printf("工号: %d 的数据已添加。无法再次加入！\n",node.number);
                flag = false;
                break;
            }
            temp = temp.next;
        }

        //修改节点
        if (flag) {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 添加节点
     * @param node
     */
    public void addNode(Node node){
        /*
            1、找到链表最后一个节点
            2、添加节点 （把next 指向Node）
         */
        Node temp = head;
        //不断后移，直到找到最后一个节点
        while (true) {
            if (temp.next == null) break;
            //后移
            temp = temp.next;
        }
        temp.next = node;

    }

    /**
     * 显示节点
     */
    public void showLinkedList() {


        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        Node temp = head.next;
        while (true){
            if (temp == null) break;

            System.out.println(temp.toString());
            temp = temp.next;
        }

    }



}


/*
* @Author: Du Yi Code
* @Description: 链表节点，根据实际需求设置节点
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
     * 链表指针域
     */
    public Node next;


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
