package Tree;

public class CreateTree {


    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            ++idx;
            if (nodes[idx] == -1) {
                return null;
            } else {
                Node newNode = new Node(nodes[idx]);
                newNode.left = this.buildTree(nodes);
                newNode.right = this.buildTree(nodes);
                return newNode;
            }
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}