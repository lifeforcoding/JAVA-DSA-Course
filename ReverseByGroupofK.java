//reverse the linked list in the group of k
public static Node reverse(Node node, int k)
    {
        Node previous = null;
        Node current = node;
        Node next;
        Node newHead = null;
        Node toBeConnect = null;
        while (current != null) {
            int i = 0;
            // loop to reverse the list upto k length
            while (i < k) {
                if (current == null)
                    break;
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
            }
            //condition for connecting after the 1st iteration
            //Define the new head which will point the head of the new list
            if (newHead == null) {
                newHead = previous;
            }
            //Condition for after every other iteration
            else {
                toBeConnect.next = previous;
            }
            toBeConnect = node;
            node = current;
            previous = null;
        }
        return newHead;
    }
