//Intersection of two sorted Linked lists
public static Node findIntersection(Node head1, Node head2)
    {
        Node ans = null;
        Node temp = null;
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                if (ans == null) {
                    ans = head1;
                    temp = ans;
                }
                else {
                    temp.next = head1;
                    temp = temp.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            else if (head1.data < head2.data) {
                head1 = head1.next;
            }
            else head2 = head2.next;
        }
        temp.next = null;
        return ans;
    }
