//Function to delete a node without any reference to head pointer.
void deleteNode(Node del)
    {
         Node newNode = new Node(del.next.data);
         newNode.next = del.next.next;
         del.data = newNode.data;
         del.next = newNode.next;
    }

//Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.

 public ListNode middleNode(ListNode head) {
        ListNode slowNode = head, fastNode = head;
        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

//Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
        Node temp = head;
    	int totalNoOfNode = 0;
        while (head != null) {
            totalNoOfNode++;
            head = head.next;
        }
        int returnPosition = totalNoOfNode - n;
        
        int count = 0;
        while (temp != null) {
            if (count == returnPosition)
                return temp.data;
            temp = temp.next;
            count++;
        }
        return -1;	
    }

//Remove Nth Node From End of List
 public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode temp = head;
        int totalNoOfNode = 0;
        while (temp != null) {
            totalNoOfNode++;
            temp = temp.next;
        }
        if (totalNoOfNode == n) {
            head = head.next;
            return head;
        }
        int returnPosition = totalNoOfNode - n;
        temp = head;
        int count = 0;
        while (temp != null) {
            if (count == returnPosition - 1) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }
