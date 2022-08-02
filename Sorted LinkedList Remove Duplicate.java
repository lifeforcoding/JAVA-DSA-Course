public ListNode deleteDuplicates(ListNode head) {
         ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                if (temp.next.next != null)
                    temp.next = temp.next.next;
                else temp.next = null;
            }
            else temp = temp.next;
        }
        return head;
    }
