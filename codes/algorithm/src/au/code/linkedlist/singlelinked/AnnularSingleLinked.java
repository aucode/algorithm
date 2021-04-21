package au.code.linkedlist.singlelinked;



/**
 * @Project algorithm
 * @Description: AnnularSingleLinked
 * @Author
 * @Explain annular single linked list (Joesphu)
 *      there are n people in a circle ,and the number of each person are 1,2...N, in turn.
 *      Now from the ON.
 *      K people start to count ,count to m people out,nutil everone people out end count.
 *
 * @Date 2021-04-18 18:31
 */
public class AnnularSingleLinked {

    public static void main(String[] args) {

        AnnularSingleLinkedList linkedList = new AnnularSingleLinkedList();

        /*

        001 马腾宾 4502
        002 于海涛 4542
        003 王光志 4552
        004 尹晓艳 4152

         */
        linkedList.add(new AnnularNode(001,"马腾宾"));
        linkedList.add(new AnnularNode(002,"于海涛"));
        linkedList.add(new AnnularNode(003,"王光志"));
        linkedList.add(new AnnularNode(004,"尹晓艳"));
        System.out.println("init linked list.");
        linkedList.showLinkedList(linkedList.getFirst());


        System.out.println("alert delete linked list in node");

        linkedList.removeNode(001);
        linkedList.removeNode(004);
        linkedList.removeNode(002);
        linkedList.removeNode(003);
//        System.out.println(linkedList.getLast());
        linkedList.showLinkedList(linkedList.getFirst());

    }


}

/**
 * create single annular linked list
 */
class AnnularSingleLinkedList {

    private AnnularNode first = new AnnularNode(0,"");


    AnnularNode last = null;

    public AnnularNode getLast() {
        return last;
    }

    public AnnularNode getFirst() {
        return first;
    }

    public AnnularSingleLinkedList() {
    }


    /**
     * remove node of annular single linked list by node number.
     * @param number
     */
    public void removeNode(int number) {

        /*
            first next default equal null.
            linked list is not data node
            end removeNode method.

         */
        if (first.next == null) {
            System.out.println("error: remove failed annular single linked list is null.");
            return ;
        }

        /*
            create temp variable default first next node.

         */
        AnnularNode temp = first;

        boolean flag = false;

        while (true) {


            /*
                when temp.number and number equal.
                end while.
                wary for remove the node.

             */
            if (temp.next.number == number) {

                flag = true;
                break;
            }

            /*
                when temp and last equal end while.

             */
            if (temp.next == last) break;

            /*
                temp move next one.

             */
            temp = temp.next;

        }

        /*
            the node remove.

         */
        if (flag) {

            /*
                1. when temp.next is last node the move forward
                2. remove temp.next node
                3. end method.

             */
            if (temp.next == last) {
                last = temp;
            }
            temp.next = temp.next.next;
            return;
        }

        /*
            can't find node of number.

         */
        System.out.println("error: remove filed can't find node of number.");






    }


    /**
     * add linked list in node
     * @param node
     */
    public void add(AnnularNode node) {

        /*
            temp default first equal.

         */
        AnnularNode temp = first;

        while (true) {

            /*
                annular linked list only one node
                  because default null.
             */
            if (temp.next == null) break;


            /*
                temp and first equal end while.
                because last.next and equal first.


             */
            if (temp == last) break;
            /*
                temp move next one.

             */
            temp = temp.next;

        }

        /*
            last save in linked list last node

            Last node.next point first
         */
        temp.next = node;
        node.next = first;//Last node.next point first
        last = node;

    }

    /**
     * output node data info of annular single linked list.
     * @param first
     */
    public void showLinkedList(AnnularNode first){

        /*
            annular single linked list is null

         */
        if (first.next == null) {
            System.out.println("Annular single linked list is null.");
            return ;
        }

        AnnularNode temp = first.next;

        while (true) {

            /*
                when temp and last.next and first equal end while.

             */
            if (temp == last.next) break;

            /*
                output data node of annular single linked list.

             */
            System.out.println(temp);

            /*
                temp move next one node.

             */
            temp = temp.next;

        }

    }
}




/**
 * create a annular node
 */
class AnnularNode {

    protected int number;

    protected String nickName;

    protected AnnularNode next;

    public AnnularNode(int number, String nickName) {
        this.number = number;
        this.nickName = nickName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public AnnularNode getNext() {
        return next;
    }

    public void setNext(AnnularNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "AnnularNode{" +
                "number=" + number +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
