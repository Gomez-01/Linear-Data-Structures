import java.util.Arrays;

public class Rubro {
    // Vermelha Cresce
    // Preta Diminui
    private int capacity;
    private int sizeV;
    private int sizeP; // Capacidade - Qtd itens na pilha preta
    private Object[] lista;

    public Rubro() {
        this.capacity = 1;
        this.sizeP = this.capacity;
        this.sizeV = 0;
        this.lista = new Object[this.capacity];
    }

    private void increaseCapacity() {
        int newCapacity = this.capacity*2;
        Object[] newList = new Object[newCapacity];

        int newSizeP = newCapacity - realSizeP();

        for (int i = 0; i < this.sizeV; i++)
            newList[i] = this.lista[i];
        for (int i = 0; i < realSizeP(); i++)
            newList[newSizeP + i] = this.lista[this.sizeP + i];

        this.sizeP = newSizeP;
        this.capacity = newCapacity;
        this.lista = newList;
    }
    private void decreaseCapacity() {
        int newCapacity = this.capacity/2;
        if (newCapacity < 1)
            newCapacity = 1;

        Object[] newList = new Object[newCapacity];

        int newSizeP = newCapacity - realSizeP();

        for (int i = 0; i < this.sizeV; i++)
            newList[i] = this.lista[i];
        for (int i = 0; i < realSizeP(); i++)
            newList[newSizeP + i] = this.lista[this.sizeP + i];

        this.sizeP = newSizeP;
        this.capacity = newCapacity;
        this.lista = newList;
    }


    private int realSizeP() {
        return this.capacity - this.sizeP;
    }


    private int totalSize() {
        return realSizeP() + this.sizeV;
    }

    public void pushV(Object value) {
        if (sizeV >= sizeP)
            increaseCapacity();
        this.lista[sizeV++] = value;
    }
    public void pushP(Object value) {
        if (sizeP <= sizeV)
            increaseCapacity();

        this.lista[--sizeP] = value;
    }
    public boolean isEmptyV() {
        return this.sizeV == 0;
    }
    public boolean isEmptyP() {
        return realSizeP() == 0;
    }
    public Object topP() {
        if (isEmptyP())
            throw new RuntimeException("topo Preto Vazio");
        return lista[sizeP];
    }
    public Object topV() {
        if (isEmptyV())
            throw new RuntimeException("Topo Vermelho Vazio");
        return lista[sizeV-1];
    }

    public Object popV() {
        if (this.sizeV == 0)
            throw new RuntimeException("Pilha vermelha vazia :( ");
        // ACHO que é para aparecer o valor que vai ser deletado entao
        Object o = this.lista[sizeV-1];
        if (totalSize() <= capacity/3)
            decreaseCapacity();
        this.lista[sizeV-1] = null;
        this.sizeV--;
        return o;
    }
    public Object popP() {
        if (this.sizeP == capacity)
            throw new RuntimeException("Pilha preta vazia :( ");
        // ACHO que é para aparecer o valor que vai ser deletado entao
        Object o = this.lista[sizeP];
        if (totalSize() <= capacity/3)
            decreaseCapacity();
        this.lista[sizeP] = null;
        this.sizeP++;
        return o;
    }

    public int getSizeP () {
        return realSizeP();
    }

    public int getSizeV () {
        return sizeV;
    }
    public void arrayCheck () {
        System.out.println(Arrays.toString(lista)); // Segestão de Lucas
    }
    public int getCapacity() {
        return capacity;
    }
}