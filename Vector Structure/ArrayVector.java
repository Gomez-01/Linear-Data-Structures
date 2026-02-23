public class ArrayVector {

    Object[] list;
    int size;
    int capacity;

    public ArrayVector() {
        this.list = new Object[1];
        this.size = 0;
        this.capacity = 1;
    }

    public void increaseCapacity() {
        int newCapacity = capacity*2;
        Object[] newList = new Object[newCapacity];
        for (int i =0; i<this.size;i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
        this.capacity = newCapacity;
    }


    public Object elementAt(int r) {
        if (r >= size() || r<0)
            throw new RuntimeException("Espaço Inalcançavél");
        return this.list[r];
    }


    public Object replaceAt(int r, Object o) {
        if (r >= size() || r<0)
            throw new RuntimeException("Espaço Inalcançavél");
        Object apagado = this.list[r];
        this.list[r] = o;
        return apagado;
    }

    public void insertAt(int r, Object o) {
        if (r > this.size || r<0)
            throw new RuntimeException("Espaço Inalcançavél");
        if (size()==capacity)
            increaseCapacity();
        for (int i = this.size; i>r; i--) {
            this.list[i] = this.list[i-1];
        }
        this.list[r]=o;
        this.size++;
    }

    public Object removeAt(int r) {
        if (r >= this.size || r<0)
            throw new RuntimeException("Espaço Inalcançavél");
        Object apagado = this.list[r];

        for (int i = r; i<this.size-1; i++) {
            this.list[i] = this.list[i+1];
        }
        this.size--;
        return apagado;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size==0;
    }
}
