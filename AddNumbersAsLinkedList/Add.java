package Practice.AddLinkedList;

public class Add {
    public ListNode addNumbers(ListNode l1, ListNode l2) {
        
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        ListNode head = null;;
        ListNode current = null;
        int carry = 0;
        while ((rl1 != null) || (rl2 !=null)) {
            //
            // create a new Node 
            //
            int l1v = (rl1 != null) ? rl1.val : 0;
            int l2v = (rl2 != null) ? rl2.val : 0;
            int sum = l1v + l2v + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            ListNode e = new ListNode(sum, null);

            if (head == null) {
                current = e;
                head = e;
            } else {
                current.next = e;
                current = e;
            }

            rl1 = (rl1 != null) ? rl1.next : null;
            rl2 = (rl2 != null) ? rl2.next : null;
        }
        return reverse(head);
}

    private void show(ListNode node) {
        ListNode current = node;
        System.out.println("");
        while(current != null) {
            System.out.print(current.val+ " ");
            current = current.next;
        }
        System.out.println("");
    }
    private ListNode reverse(ListNode node) {

        ListNode current = node;
        ListNode previous = null;
        ListNode next = null;
        
        //
        // for each node, reattach next to previous
        //
        while(current != null) {
            //remember next node
            next = current.next;
            //reroute current node pointer
            current.next = previous;
            // current becomes previous node
            previous = current;
            // move to next remembered node
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3,null))));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4,null)));
        
        Add adder = new Add();
        System.out.println("before");
        adder.show(root1);
        adder.show(root2);
        ListNode res = adder.addNumbers(root1, root2);
        System.out.println("result");
        adder.show(res);


    }
}
