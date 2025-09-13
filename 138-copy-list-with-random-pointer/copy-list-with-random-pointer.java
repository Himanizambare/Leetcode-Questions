class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;  // ✅ handle empty input

        Node cur = head;

        // Step 1: Insert cloned nodes
        while (cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }

        // Step 2: Copy random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Step 3: Separate both lists
        Node orig = head, copy = head.next;
        Node temp = copy;

        while (orig != null && copy != null) {
            orig.next = (orig.next != null) ? orig.next.next : null;
            copy.next = (copy.next != null) ? copy.next.next : null;

            orig = orig.next;
            copy = copy.next;
        }

        return temp;
    }
}
