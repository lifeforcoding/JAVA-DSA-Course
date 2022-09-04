//Sort a linked list using bubble sort
    public static void bubbleSortLL(ListNode head) {
        ListNode crr = head;
        ListNode crrNext = null;
        while (crr.next.next != null) {
            crrNext = crr.next;
            while (crrNext != null) {
                if (crr.data > crrNext.data) {
                    int temp = crr.data;
                    crr.data = crrNext.data;
                    crrNext.data = temp;
                }
                crrNext = crrNext.next;
            }
            crr = crr.next;
        }
    }
