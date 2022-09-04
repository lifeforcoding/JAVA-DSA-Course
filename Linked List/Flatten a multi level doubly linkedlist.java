public Node flatten(Node head) {
        if (head == null) return head;
        Node p = head;
        while (p.next != null || p.child != null) {
            if (p.child == null) {
                p = p.next;
            } else {
                Node child = p.child;
                p.child = null;
                Node next = p.next;
                p.next = child;
                child.prev = p;
                Node tail = flatten(child);
                if (next!= null) {
                    tail.next = next;
                    next.prev = tail;
                    p = next;
                } else p = child;
            }
        }
        if (head.prev != null) return p;
        else return head;
    }
