package linkList;

    public class KthToLastRecursive {
        public static int nthToLast1(LinkedListNode head, int k) {
            if (head == null) return 0;

            int index = nthToLast1(head.next, k) + 1;

            if (index == k) {
                System.out.println(head.data); // Found the kth-to-last element
            }

            return index;
        }

            public static LinkedListNode nthToLast2(LinkedListNode head, int k) {
                if (k <= 0 || head == null) return null;

                LinkedListNode p1 = head;
                LinkedListNode p2 = head;

                // Move p2 k steps ahead
                for (int i = 0; i < k; i++) {
                    if (p2 == null) return null; // k is out of bounds
                    p2 = p2.next;
                }

                // Move both pointers together
                while (p2 != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                }

                return p1; // p1 is now at the kth-to-last element
            }
        }




