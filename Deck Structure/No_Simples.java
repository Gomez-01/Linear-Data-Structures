public class No_Simples {
    
    class Node {
        private Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public No_Simples() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void  inserirInicio(Object value) {
        Node newNode = new Node(value);
            newNode.next = this.head;
            this.head = newNode;
            if (size == 0)
                this.tail = newNode;
            this.size++;
    }

    public Object removerInicio() {
        if (size == 0)
            throw new RuntimeException("Impossivel remover do inicio: Deque Vazio!");

        Object o = this.head.value;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        this.size--;

        return o;
    }

    public void inserirFim(Object value) {
        Node newNode = new Node(value);

        if (this.head == null)
            this.head = newNode;
        else
            this.tail.next = newNode;

        this.tail = newNode;
        this.size++;
    }

    public Object removerFim() {
        if (size == 0)
            throw new RuntimeException("Impossivel remover do FInal: Deque Vazio!");
        Object o = this.tail.value;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            Node nodeToChange = this.head;
            while (nodeToChange.next != this.tail)
                nodeToChange = nodeToChange.next;

            this.tail = nodeToChange;
            this.tail.next = null;
        }
        size--;
        return o;
    }
// AUXILIARES
    public Object primeiro() {
        if (size == 0)
            throw new RuntimeException("Null Head: Deque Vazio!");
        return this.head.value;
    }
    public Object ultimo() {
        if (size == 0)
            throw new RuntimeException("Null tail: Deque Vazio!");
        return  this.tail.value;
    }
    public int tamanho() {
        return this.size;
    }
    public boolean estaVazia() {
        return  this.size == 0;
    }

    // Coisa que eu fiz pra teste
    public void imprimirLista() {
        System.out.print("[");
        Node nodeToPrint = this.head;
        while (nodeToPrint != null) {
            System.out.print(" " + nodeToPrint.value + " ");
            nodeToPrint = nodeToPrint.next;
        }
        System.out.println("]");
    }
}