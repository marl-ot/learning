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

    // Функция, которая кладет данные в стек
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    // Функция, которая достает данные из стека
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public class Node {
        int value;
        Node next;
    }
}
