package au.code.tree;

import sun.reflect.generics.tree.Tree;

public class BinaryTree {

    public static void main(String[] args) {

        Binary binary = new Binary();

        /*
            create binary tree node.
         */
        TreeNode root = new TreeNode(001,"马腾宾");
        TreeNode node1 = new TreeNode(002,"于海涛");
        TreeNode node2 = new TreeNode(003,"王光志");
        TreeNode node3 = new TreeNode(004,"尹晓艳");
        TreeNode node4 = new TreeNode(005,"张桂荣");

        /*
            manual add node in tree.
         */
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node4);
        node2.setRight(node3);

        /*
            set root in tree
         */
        binary.root = root;

        /*
            pre order traversal tree.

         */
        System.out.println("pre order.");
        binary.PreOrderTree();//1,2,3,4

        /*
            middle order traversal tree.
         */
        System.out.println("middle order.");
        binary.MiddleOrderTree();//2,1,3,4

        /*
            postscript order traversal tree.
         */
        System.out.println("postscript order.");
        binary.PostOrderTree();//2,4,3,1


        TreeNode prefind = binary.preOrderSearch(5);
        System.out.printf("find number ：%d \n\t node is：%s \n",5,(prefind != null ? prefind:"not node."));

        TreeNode middlefind = binary.MiddleOrderSearch(5);
        System.out.printf("find number ：%d \n\t node is：%s \n",5,(middlefind != null ? middlefind:"not node."));

        TreeNode postfind = binary.PostOrderSearch(5);
        System.out.printf("find number ：%d \n\t node is：%s \n",5,(postfind != null ? postfind:"not node."));





    }

}

/**
 * create binary tree.
 */
class Binary {

    public TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * pre order traversal node of tree.
     */
    public void PreOrderTree() {
        /*
            output node date when this.root is not null of tree.
         */
        if (this.root != null) {

            this.root.preOrderTraversal();

        }else {

            System.out.println("tree is null.");
        }

    }

    /**
     * middle order traversal node of tree.
     */
    public void MiddleOrderTree() {

        /*
            output node data when tree is not null.
         */
        if (this.root != null) {

            this.root.MiddleOrderTraversal();
        }else {

            System.out.println("tree is null.");
        }
    }


    /**
     * postscript order traversal node data of tree.
     */
    public void PostOrderTree() {

        if (this.root != null) {
            this.root.PostOrderTraversal();
        } else {
            System.out.println("tree is null.");
        }

    }

    /**
     * find node of tree by no.
     * @param no
     * @return
     */
    public TreeNode preOrderSearch(int no) {

        /*
            when root is not null find node.
         */
        if (this.root != null) {

            return this.root.PreOrderSearch(no);
        }else {

            return null;
        }
    }

    /**
     * find node of tree by no.
     * @param no
     * @return
     */
    public TreeNode MiddleOrderSearch(int no) {

        /*
            when root is not null find node.
         */
        if (this.root != null) {

            return this.root.MiddleOrderSearch(no);
        }else {
            return null;
        }
    }

    /**
     * find node of tree by no.
     * @param no
     * @return
     */
    public TreeNode PostOrderSearch(int no) {

        /*
            when root is not null fond node.
         */
        if (this.root != null){

            return this.root.PostOrderSearch(no);
        }else {

            return null;
        }

    }



}


/**
 * create node in node
 */
class TreeNode {

    /*
        node number
     */
    private int number;

    /*
        node value.
     */
    private String value;

    /*
        tree left children default null.
     */
    private TreeNode left;

    /*
        tree right children default null.
     */
    private TreeNode right;

    public TreeNode(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "number=" + number +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     *  pre order traversal of tree.
     */
    public void preOrderTraversal() {

        /*
            first output father node.
         */
        System.out.println(this);

        /*
            If left children of tree not null output it.
                (of：属于、来源)
         */
        if (this.left != null) {

            /*
                left children back method.

             */
            this.left.preOrderTraversal();

        }

        /*
            If right children of tree not null output it.

         */
        if (this.right != null) {

            /*
                right children back method.

             */
            this.right.preOrderTraversal();

        }

    }

    /**
     *  middle order node data of tree.
     *      when tree only three node left and middle and right or null but at least one node.
     */
    public void MiddleOrderTraversal() {
        /*
            always last left node of tree.
         */
        if (this.left != null) this.left.MiddleOrderTraversal();

        /*
            output father node when the is last node of tree.
         */
        System.out.println(this);

        /*
            output right children node of tree.

         */
        if (this.right != null) {

            this.right.MiddleOrderTraversal();

        }

    }

    /**
     *  postscript order traversal node of tree.
     */
    public void PostOrderTraversal() {

        /*
            find left last node of tree.
         */
        if (this.left != null) {

            /*
                back method
             */
            this.left.PostOrderTraversal();
        }

        /*
            find right last node.
         */
        if (this.right != null) {
            this.right.PostOrderTraversal();
        }

        /*
            output last right children node of tree.
         */
        System.out.println(this);

    }


    /**
     *
     * Search node of tree by number of node.
     *  Traversal in preorder.
     * @param no number in node
     * @return
     */
    public TreeNode PreOrderSearch(int no) {

        /*
            If number and no equal return the node.
         */
        if (this.number == no) {
            /*
                return previous method.
             */
            return this;
        }

        /*
            default null.

         */
        TreeNode result = null;
        /*
            The left node is not null.
         */
        if (this.left != null) {

            /*
                left node call yourself and save return date.
             */
            result = this.left.PreOrderSearch(no);
        }

        /*
            found node return end.
         */
        if (result != null) return result;

        /*
            If right node is not null.
         */
        if (this.right != null) {

            /*
                right node call yourself.
             */
            result = this.right.PreOrderSearch(no);
        }



        /*
            return find node date.
            if can't fina node by no return result default is null.
         */
        return result;

    }

    /**
     * Search node of tree by number of node.
     *  Traversal in middle order.
     * @param no
     * @return
     */
    public TreeNode MiddleOrderSearch(int no) {

        /*
            create result default is null
         */
        TreeNode result = null;

        /*
            If left node is not null. the call yourself.
         */
        if (this.left != null) {

            result = this.left.MiddleOrderSearch(no);
        }

        /*
            found node return and end.
         */
        if (result != null) return result;

        /*
            The node in number and no equal return node.
         */
        if (this.number == no) {

            return this;
        }

        /*
            right node is not null call yourself.
         */
        if (this.right != null) {

            /*
                save return data to result.
             */
            result = this.right.MiddleOrderSearch(no);
        }

        /*
            return result content if can't find result is null.
         */
        return result;
    }

    /**
     * Search node of tree by number of node.
     *  postscript in traversal.
     * @param no
     * @return
     */
    public TreeNode PostOrderSearch(int no) {

        /*
            create result save return data the default is null.
         */
        TreeNode result = null;

        /*
            If left node is not null call yourself and save return data to result.
         */
        if (this.left != null) {

            result = this.left.PostOrderSearch(no);
        }

        /*
            found node return and end.
         */
        if (result != null) return result;

        /*
            If right node is not null call yourself and save return data to result.
         */
        if (this.right != null) {

            result = this.right.PostOrderSearch(no);
        }

        /*
            found node return and end.
         */
        if (result != null) return result;

        /*
            where node in number and no equal return it.
         */
        if (this.number == no) {

            return this;
        }


        /*
            return result if can't find result is null.
         */
        return result;
    }















    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
