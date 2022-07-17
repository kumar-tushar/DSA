package Tree;

public class CreateTree {

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


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        System.out.println(createTree(nodes).data);
    }
}