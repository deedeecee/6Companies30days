package Amazon;

public class DeleteNodesGFG {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static void linkdelete(Node head, int n, int m) {
        Node current = head;

        while ((current != null) && (current.next != null)) {
            for (int i = 0; (i < (m - 1)) && (current != null); i++) {
                current = current.next;
            }

            if (current == null) {
                break;
            }

            Node deleteNode = current.next;

            for (int i = 0; (i < n) && (deleteNode != null); i++) {
                deleteNode = deleteNode.next;
            }

            current.next = deleteNode;
            current = current.next;
        }
    }

    static void displayLinkedList(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println(temp.data + " -> null");
    }

    public static void main(String[] args) {
        Node head = new Node(9, new Node(1, new Node(3, new Node(5, new Node(9, new Node(4,
                new Node(10, new Node(1))))))));

        displayLinkedList(head);

        int m = 8;
        int n = 1;

        linkdelete(head, n, m);
        displayLinkedList(head);
    }
}
