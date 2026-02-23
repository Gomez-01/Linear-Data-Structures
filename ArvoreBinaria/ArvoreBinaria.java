// Falta:
//desenhar

// EU NAO SEI SE FAZ SENTIDO A ARVORE SER OBJECT já que ela compara entao farei do tipo int
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinaria implements Iterable<Integer> {
    private int size;
    private Node root;

    public class Node {

        private Node parent;
        private Node left;
        private Node right;
        private int value;

        public Node(int o) {
            this.value = o;
            this.left = null;
            this.right=null;
        }
        public Node left() {
            return this.left;
        }
        public Node right() {
            return this.right;
        }

        public int element() {
            return this.value;
        }

        public Node parent() {
            return this.parent;
        }

        public boolean hasLeft() {
            return this.left != null;
        }

        public boolean hasRight() {
            return this.right != null;
        }

        public boolean isExternal() {
            return this.left == null && this.right == null;
        }
    }

    public ArvoreBinaria() {
        this.root = null;
        this.size = 0;
    }
//-------------------------
    // Booleanos
    public boolean isEmpty() {
        return root == null;
    }
    public boolean isRoot(Node no) {
        return no == root;
    }
    public boolean contains(int element) {
        return search(element) != null;
    }
    // Retorno dos Atributos
    public Node root() {
        return this.root;
    }
    public int size() {
        return this.size;
    }
    // Altura e Profundidade
    public int depth(Node no) {
        if (no == null || isRoot(no))
            return 0;
        return 1 + depth(no.parent);
    }
    public int height(Node no) {
        if (no.isExternal())
            return 0;
        return 1 + Math.max(height(no.left), height(no.right));
    }
    // Remover e Adicionar
    public void remove(int value){
        if (isEmpty())
            throw new RuntimeException("Arvore vazia");
        Node temp = search(value);
        if (temp == null)
            throw new RuntimeException("Valor não encontrado");
        // Caso 03 - Pior caso(2 Filhos)
        if (temp.hasRight() && temp.hasLeft()) {
            Node sucessor = temp.right;
            while (sucessor.left != null)
                sucessor = sucessor.left;
            temp.value = sucessor.value;
            temp = sucessor;
        }
        removeOneOrLess(temp);
        size--;
    }
    //Nao quero repitir o codigo então vou criar um metodo privado para reaproveitar
    private void removeOneOrLess(Node temp) {
        // CASO 01 - Folha
        if (temp.left==null && temp.right==null){
            if (temp == root)
                root = null;
            else if (temp.parent.right == temp)
                temp.parent.right = null;
            else
                temp.parent.left = null;
        }
        // Caso 02 - Filho unico
        else if (temp.hasLeft() ^ temp.hasRight()){ // Tem XOR em JAVA :D
            Node filho;
            if (temp.hasLeft())
                filho = temp.left;
            else
                filho = temp.right;
            if (temp == root) {
                root = filho;
            }
            else if (temp.parent.left == temp)
                temp.parent.left = filho;
            else
                temp.parent.right = filho;
            filho.parent = temp.parent;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        Node atual = root;
        Node parent = null;
        while (atual != null) {
            parent = atual;
            if (value > atual.element()) {
                atual = atual.right();
            } else if (value < atual.element()) {
                atual = atual.left();
            } else { // nesse caso ele é igual(não lembro se pode ter igual)
                return;
            }
        }
        newNode.parent = parent;
        if (value > parent.element())
            parent.right = newNode;
        else
            parent.left = newNode;
        size++;
    }
    // Busca
    public Node search(int element) {
        Node atual = root;
        while (atual != null) {
            if (atual.element() == element) {
                return atual;
            } else if (atual.element() > element) {
                atual = atual.left;
            } else {
                atual = atual.right;
            }
        }
        return null; // Não tem nó com esse valor
    }
    // Sei lá
    public int maximum() {
        if (isEmpty())
            throw new RuntimeException("Arvore vazia");
        Node maior = root;
        while (maior.hasRight())
            maior = maior.right;
        return maior.element();
    }
    public int minimum() {
        if (isEmpty())
            throw new RuntimeException("Arvore vazia");
        Node menor = root;
        while (menor.hasLeft())
            menor = menor.left;
        return menor.element();
    }
    // Ordenação
    public void preOrder(Node no) {
        if (no == null) return;
        System.out.print(no.value + " ");
        preOrder(no.left);
        preOrder(no.right);
    }
    public void inOrder(Node no) {
        if (no == null) return;
        inOrder(no.left);
        System.out.print(no.value + " ");
        inOrder(no.right);
    }
    public void postOrder(Node no) {
        if (no == null) return;
        postOrder(no.left);
        postOrder(no.right);
        System.out.print(no.value + " ");
    }
    // Iterador
    public Iterator<Integer> iterator() {
        ArrayList<Integer> lista = new ArrayList<>();
        inOrderToList(root, lista);
        return lista.iterator();
    }
    private void inOrderToList(Node no, ArrayList<Integer> lista) {
        if (no == null) return;
        inOrderToList(no.left, lista);
        lista.add(no.value);
        inOrderToList(no.right, lista);
    }
    // Desenho
    public void printList() {
        for (Integer i : this) { // EU fiz um while mas o IntelliJ sugeriu for-each
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public void printTree() {
        if (root == null) {
            throw new RuntimeException("Impossivel printar arvore vazia :(");
        }
        int h = height(root);
        Queue<Node> fila = new LinkedList<>();
        fila.add(root);

        for (int nivel = 0; nivel <= h; nivel++) {
            int espacosAntes = (int) Math.pow(2, h - nivel) - 1;
            int espacosEntre = (int) Math.pow(2, h - nivel + 1) - 1;
            printSpaces(espacosAntes);
            int qtdNos = (int) Math.pow(2, nivel);
            for (int i = 0; i < qtdNos; i++) {
                Node atual = fila.poll();

                if (atual != null) {
                    System.out.print(atual.value);
                    fila.add(atual.left);
                    fila.add(atual.right);
                } else {
                    System.out.print("  ");
                    fila.add(null);
                    fila.add(null);
                }

                printSpaces(espacosEntre);
            }
            System.out.println();
        }
    }

    private void printSpaces(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("  ");
    }

}

