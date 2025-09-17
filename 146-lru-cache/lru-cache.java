

class Node {
    int key, value;
    Node prev, next;
    public Node(int k, int v) {
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}

 class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Insert node right after head (Most Recently Used position)
    private void addNode(Node node) {
        Node oldNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldNext;
        oldNext.prev = node;
    }

    // Remove a node from DLL
    private void removeNode(Node node) {
        Node oldPrev = node.prev;
        Node oldNext = node.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    // Get value and move node to MRU position
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        map.remove(key);
        removeNode(node);
        addNode(node);
        map.put(key, node);
        return node.value;
    }

    // Put key-value into cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            removeNode(oldNode);
            map.remove(key);
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;  // Least Recently Used
            removeNode(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

   
}
