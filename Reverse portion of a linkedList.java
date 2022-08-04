//Reverse a link list starting from mnode to n node nodes
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode nodeToConnect = head;
        ListNode temp = head;
        //Find the point from which the list is to reverse
        while (head != null && count < left) {
            nodeToConnect = head;
            head = head.next;
            count++;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        //Loop for reversing the portion
        while (count >= left && count <= right) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        //If left point is not from starting of the list
        if (left > 1) {
            nodeToConnect.next = previous;
            head.next = current;
            return temp;
        }
        //If left point is start of the list
        head.next = current;
        return previous;
    }
