//Created the node class
class Node {
    int data; //HOlds the data of the current node
    Node next; // Holds the reference to the next node
    //Constructor for creating new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Practice {
    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node head = n1;
        head = insertLL(head, 1, 4);
        head = insertLL(head, 3,6);
        printLL(head);
    }

    //Traversal of a linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }
    }

    //Function for insert an element at any position in a linked list
    public static Node insertLL(Node head, int position, int data) {
        //Handle for insert in the head
        Node temp = new Node(data);
        if (position == 1) {
            temp.next = head;
            return temp;
        }
        Node previousNode = head;
        for (int i = 1; i < position - 1; i++) {
            previousNode = previousNode.next;
            if (previousNode == null) return head;
        }

        //Handle for insert at tail. & for insert at any other given position
        Node afterNode = previousNode.next;
        previousNode.next = temp;
        temp.next = afterNode;
        return head;
    }
}
