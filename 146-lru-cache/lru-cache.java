class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToEnd(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            addToEnd(node);

        } else {

            Node node = new Node(key, value);

            map.put(key, node);

            addToEnd(node);

            if (map.size() > capacity) {

                Node leastRecentlyUsed = head.next;

                remove(leastRecentlyUsed);

                map.remove(leastRecentlyUsed.key);
            }
        }
    }

    private void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    private void addToEnd(Node node) {

        Node previous = tail.prev;

        previous.next = node;
        node.prev = previous;

        node.next = tail;
        tail.prev = node;
    }
}