public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode current = head;
        int m = 1;
        //Pointer to point to the last node of the list to connect to the reverse list
        ListNode pointToConnect = null;
        ListNode next;
        //Pointer for pointing the 1st element of the list next to the revered list which connect 
        //to the end of the reversed list
        ListNode nextConnect = null;
        while (current != null) {
            int i = 0;
            ListNode previous = null;
            ListNode temp = current;
            //Loop which will find the total length to find is it ven length or odd length
            while (i < m && temp != null) {
                i++;
                temp = temp.next;
            }
            m = i; //update the length with the 'm' so that it run till that point 
            //Otherwise it will through null pointer
            i = 0;
            
            while (i < m) {
                if (current == null)
                    break;
                //condition to reverse the part if it is of even length
                if (m % 2 == 0) {
                    next = current.next;
                    current.next = previous;
                    previous = current;
                    current = next;
                }
                //Condition if it is not of even length
                else {
                    pointToConnect = current;
                    current = current.next;
                    nextConnect = current;
                }
                i++;
            }
            //Condition to join the previous part and the next part with the reversed list if it is a even length
            if (m % 2 == 0) {
                pointToConnect.next = previous;
                nextConnect.next = current;
                pointToConnect = nextConnect;
                nextConnect = current;
            }
            m++;
        }
        return head;
        }
