package linkList;
import java.util.HashSet;


    class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class RemoveDuplicates {
        public static void deleteDups(LinkedListNode head) {
            HashSet<Integer> set = new HashSet<>();
            LinkedListNode previous = null;
            LinkedListNode current = head;

            while (current != null) {
                if (set.contains(current.data)) {
                    previous.next = current.next; // Remove duplicate
                } else {
                    set.add(current.data);
                    previous = current;
                }
                current = current.next;
            }
        }


}
