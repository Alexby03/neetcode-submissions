class LinkedListNode {
    
    private int value;
    //private int index;
    private LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    //    this.index = index;
        this.next = null;
    }

    public int getValue() {
        return this.value;
    }

    //public void getIndex() {
    //    return this.index;
    //}

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class LinkedList {

    private LinkedListNode head;
    private int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if(head == null) return -1;
        if(index >= length) return -1;
        LinkedListNode current = head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void insertHead(int val) {
        if(this.head == null) {
            this.head = new LinkedListNode(val);
            length++;
            System.out.println("INSERT HEAD: " + this.length);
            return;
        }
        LinkedListNode newHead = new LinkedListNode(val);
        newHead.setNext(this.head);
        this.head = newHead;
        this.length++;
        System.out.println("INSERT HEAD: " + this.length);
    }

    public void insertTail(int val) {
        if(this.head == null) {
            this.head = new LinkedListNode(val);
            this.length++;
            System.out.println("INSERT TAIL: " + this.length);
            return;
        }
        LinkedListNode current = head;
        while(current.getNext() != null) current = current.getNext();
        current.setNext(new LinkedListNode(val));
        this.length++;
        System.out.println("INSERT TAIL: " + this.length);
    }

    public boolean remove(int index) {
        if(head == null) return false;
        if(index == 0) {
            LinkedListNode removedHead = this.head;
            this.head = removedHead.getNext();
            removedHead.setNext(null);
            this.length--;
            //System.out.println("REMOVED, REMAINING: " + this.length);
            return true;
        }
        if(index >= length) return false;
        LinkedListNode current = this.head;
        for(int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        LinkedListNode removedNode = current.getNext();
        current.setNext(removedNode.getNext());
        removedNode.setNext(null);
        this.length--;
        //System.out.println("REMOVED, REMAINING: " + this.length);
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> valuesArr = new ArrayList<>();
        if(this.head == null) return valuesArr;
        LinkedListNode current = head;
        do {
            valuesArr.add(current.value);
            current = current.getNext();
        }
        while(current != null);
        return valuesArr;
    }
}
