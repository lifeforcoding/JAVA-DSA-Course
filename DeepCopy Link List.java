//Deep copy a linked list with next and random pointer
    public Node copyRandomList(Node head) {
        //Creating the deep copy nodes and inserting them between the current and next node of the original list
        Node current = head;
        Node front;
        while (current != null) {
            front = current.next;
            current.next = new Node(current.val);
            current.next.next = front;
            current = front;
        }
        //Set the random node as in the original list with the newly created nodes.
        current = head;
        while (current != null) {
            if (!(current.random == null)) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //Extract the newly inserted nodes from the original list and reverse the list state to the original
        // and connect the extracted nodes for a new node
        Node newHead = new Node(0);
        front = newHead;
        current = head;
        while (current != null) {
            front.next = current.next;
            front = front.next;
            current.next = front.next;
            current = current.next;
        }
        return newHead.next;
    }
