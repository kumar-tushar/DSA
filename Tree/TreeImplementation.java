package Tree;

import java.util.*;

public class TreeImplementation {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // Tree Creation
    static int index=-1;
    public static Node createTree(int[] nodes){
        index++;
        if(nodes[index]==-1)
            return null;
        else {
            Node newNode = new Node(nodes[index]);
            newNode.left = createTree(nodes);
            newNode.right = createTree(nodes);
            return newNode;
        }
    }


    // Preorder Tree Traversal
    public static void preorder(Node root) {
        if(root == null) {
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    // postorder Tree Traversal
    public static void postorder(Node root) {
        if(root == null) {
            System.out.print(-1+" ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }


    // inorder Tree Traversal
    public static void inorder(Node root) {
        if(root == null) {
            System.out.print(-1+" ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    // levelOrder Tree Traversal
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            System.out.print(currNode.data+" ");
            if(currNode.left != null)
                queue.add(currNode.left);
            if(currNode.right != null)
                queue.add(currNode.right);
        }
    }







    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root=createTree(nodes);

        levelOrder(root);

    }
}