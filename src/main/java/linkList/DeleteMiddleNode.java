package linkList;

    public class DeleteMiddleNode {
        public static boolean deleteNode(LinkedListNode node) {
            if (node == null || node.next == null) {
                return false; // Failure case
            }

            node.data = node.next.data; // Copy data from next node
            node.next = node.next.next; // Remove next node

            return true;
        }
    }


