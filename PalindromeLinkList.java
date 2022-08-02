boolean isPalindrome(Node head) 
    {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node previous = null;
        Node current = slow;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        boolean palindrome = true;
        while (previous != null && head != null) {
            if (previous.data != head.data) {
                palindrome = false;
                break;
            }
            previous = previous.next;
            head = head.next;
        }
        return palindrome;
    }
