package linkList;

    public class RemoveDuplicatesNoBuffer {
        public static void deleteDups(LinkedListNode head) {
            LinkedListNode current = head;

            while (current != null) {
                LinkedListNode runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next; // Remove duplicate
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }
    }


