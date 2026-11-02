class DynamicArray {

    private int[] myArr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.myArr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return this.myArr[i];
    }

    public void set(int i, int n) {
        this.myArr[i] = n;
        return;
    }

    public void pushback(int n) {
        if(this.size >= capacity) resize();
        this.myArr[this.size] = n;
        this.size++;
    }

    public int popback() {
        if(size > 0) {
            this.size--;
        }
        return this.myArr[size];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArr = new int[this.capacity];
        for(int i = 0; i < size; i++) {
            newArr[i] = this.myArr[i];
        }
        this.myArr = newArr;
        return;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
