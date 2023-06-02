// Разворот односвязного списка

public class singly_linked_list {

    Node head;

    public void revert(Node currentNode, Node previousNode) {

        if (head != null && head.next != null) {
            if (currentNode.next == null) {
                head = currentNode;
            } else {
                revert(currentNode.next, currentNode);
            }
            currentNode.next = previousNode;
            previousNode.next = null;
        }
    }

    public class Node {
        int value;
        Node next;
    }
}
