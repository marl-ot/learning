public class ReverseList {

    // Вывести список на экран в перевернутом виде (без массивов и ArrayList)
    public static void main(String[] args) {
        Node head = createLinkedList();

        System.out.println("Исходный список:");
        printList(head);
        System.out.println();
        System.out.println("Список в перевернутом виде:");
        printReversed(head);
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node createLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        return head;
    }

    public static void printList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printList(node.next);
    }

    public static void printReversed(Node node) {
        if (node == null) {
            return;
        }
        printReversed(node.next);
        System.out.print(node.data + " ");
    }
}