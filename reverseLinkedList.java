// Reverse a linked list recursively
    public static Node reverseList(Node head)
    {
        if (head == null || head.next == null)
            return head;
        Node n = reverseList(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;
        return n;
    }
