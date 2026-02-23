public class Sequence {
    public class Node {
        Object value;
        Node next,prev;
        public Node(Object value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public Sequence() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.size=0;
        this.head.next = tail;
        this.tail.prev = head;
    }
    public boolean isFirst(Node no) {

        return no.prev==this.head;
    }
    public boolean isLast(Node no) {
        return no.next==this.tail;
    }
    public Node first() {
        if (isEmpty())
            throw new RuntimeException("Lista Vazia");
        return this.head.next;
    }
    public Node last() {
        if (isEmpty())
            throw new RuntimeException("Lista Vazia");
        return this.tail.prev;
    }
    public Node before(Node p) {
        if (isEmpty())
            throw new RuntimeException("Lista Vazia");
        return p.prev;
    }
    public Node after(Node p) {
        if (isEmpty())
            throw new RuntimeException("Lista Vazia");
        return p.next;
    }
    public void replaceElement(Node no,Object o){
        if (isEmpty())
            throw new RuntimeException("Lista Vazia");
        no.value = o;
    }
    public void swapElements(Node no,Node no2) {
        Object Temp = no.value;
        no.value = no2.value;
        no2.value = Temp;
    }
    public void insertBefore(Node no, Object o) {
        if (no.prev==this.head) {
            InsertFirst(o);
        } else {
            Node newNode = new Node(o);
            newNode.next = no;
            newNode.prev = no.prev;
            no.prev.next = newNode;
            no.prev = newNode;
            this.size++;
        }
    }

    public void insertAfter(Node no, Object o) {
        if (no.next==this.tail) {
            InsertLast(o);
        } else {
            Node newNode = new Node(o);
            newNode.prev = no;
            newNode.next = no.next;
            no.next.prev = newNode;
            no.next = newNode;
            this.size++;
        }
    }
    public void InsertFirst(Object o) {
        Node newNode = new Node(o);
        newNode.prev = this.head;
        newNode.next = this.head.next;
        this.head.next.prev = newNode;
        this.head.next = newNode;
        this.size++;
    }
    public void InsertLast(Object o) {
        Node newNode = new Node(o);
        newNode.next = this.tail;
        newNode.prev = this.tail.prev;
        this.tail.prev.next = newNode;
        this.tail.prev = newNode;
        this.size++;
    }
    public Object remove(Node no) {
        Object temp = no.value;
        no.prev.next = no.next;
        no.next.prev = no.prev;
        this.size--;
        return temp;
    }
    // Agora os de Vector
    public Object elementAt(int r) {
        if (r >= size() || r<0)
            throw new RuntimeException("Espaço Inalcançavél");
        return atRank(r).value;
    }

    public Object replaceAt(int r, Object o) {
        Object temp = atRank(r).value;
        atRank(r).value = o;
        return  temp;
    }

    public void insertAt(int r, Object o) {
        Node no = atRank(r);
        Node newNode = new Node(o);
        newNode.prev = no.prev;
        newNode.next = no;
        no.prev.next = newNode;
        no.prev = newNode;
        this.size++;
    }
    public Object removeAt(int r) {
        Node no = atRank(r);
        Object temp = no.value;
        no.next.prev = no.prev;
        no.prev.next = no.next;
        this.size--;
        return  temp;
    }


    public int RankOf(Node no) {
        Node n = head.next;
        int r = 0;
        while (n != tail) {
            if (n == no)
                break;
            n = n.next;
            r++;
        }
        return r;
    }

    public Node atRank(int r) {
        if (r < 0 || r >= size)
            throw new RuntimeException("Rank inalcançavel");
        Node no;
        if (r <= size()/2) {
            no = this.head.next;
            for(int i=0; i < r; i++)
                no = no.next;
        } else {
            no = this.tail.prev;
            for (int i = size - 1; i > r; i--)
                no = no.prev;
        }
        return no;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size==0;
    }
}