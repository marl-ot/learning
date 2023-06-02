public class linked_list {

    Node head;
    Node tail;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node new_node = new Node();
        new_node.value = value;
        node.next = new_node;
        new_node.previous = node;
        if (next == null) {
            tail = new_node;
        } else {
            next.previous = new_node;
            new_node.next = next;
        }
    }

    // константная операция по удалению
    public void delete(Node node) {
        Node previous = node.previous; // предыдущая нода
        Node next = node.next; // следующая нода
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }

    }

    // Функция, которая кладет данные в очередь
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    // Функция, которая достает данные из очереди
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }

}
