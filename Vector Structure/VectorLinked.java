public class VectorLinked {
    public class Node {
        Object value;
        Node next,prev;

        Node(Object value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }
    // Eu tinha feito sem no sentinela mas após fazer o LinkedList eu prefiri fazer
    // Dessa forma.
    private Node head;
    private Node tail;
    private int size;


    public VectorLinked() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public Object elementAt(Node no) {
        return no.value;
    }

    public Object replaceAt(Node no, Object o) {
        Object temp = no.value;
        no.value = o;
        return  temp;
    }

    public void insertAt(Node no, Object o) {
        Node newNode = new Node(o);
        newNode.prev = no.prev;
        newNode.next = no;
        no.prev.next = newNode;
        no.prev = newNode;
        this.size++;
    }

    public Object removeAt(Node no) {
        Object temp = no.value;
        no.next.prev = no.prev;
        no.prev.next = no.next;
        this.size--;
        return  temp;
    }


    public Node getNode(int r) {
        if (r >= this.size || r < 0)
            throw new RuntimeException("indice Invalido");
        Node nodeToGet = this.head.next;
        for(int i = 0; i<r;i++)
            nodeToGet = nodeToGet.next;
        return nodeToGet;
    }

    public boolean isEmpty() {
        return this.size ==0;
    }

    public int size() {
        return this.size;
    }
}
