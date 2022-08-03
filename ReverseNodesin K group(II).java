//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes 
//is not a multiple of k then left-out nodes, in the end, should remain as it is.
public ListNode reverseKGroup(ListNode node, int k) {
        ListNode previous = null;
        ListNode current = node;
        ListNode next;
        ListNode newHead = null;
        ListNode toBeConnect = null;
        while (current != null) {
            int i = 0;
            ListNode temp = current;
            while (i < k && temp != null) {
                i ++;
                temp = temp.next;
            }
            if (i == k) {
                i = 0;
                while (i < k) {
                    if (current == null)
                        break;
                    next = current.next;
                    current.next = previous;
                    previous = current;
                    current = next;
                    i++;
                }
                if (newHead == null) {
                    newHead = previous;
                } else {
                    toBeConnect.next = previous;
                }
                toBeConnect = node;
                node = current;
                previous = null;
            }
            else {
                toBeConnect.next = node;
                break;
            }
        }
        return newHead;
    }
