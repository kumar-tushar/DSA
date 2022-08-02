package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {

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


    // levelOrder Tree Traversal
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list1=new ArrayList<>();
        if(root==null)
            return list1;

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list2=new ArrayList<>();

            int size= queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.remove();
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
                list2.add(currNode.data);
            }
            list1.add(list2);
        }
        return list1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root=createTree(nodes);

        System.out.println(levelOrder(root));
    }
}
