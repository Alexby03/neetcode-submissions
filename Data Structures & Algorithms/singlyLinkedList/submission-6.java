class LinkedListNode {
    
    public int value;
    //private int index;
    public LinkedListNode next;

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
    private LinkedListNode tail;
    private int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if(head == null) return -1;
        if(index >= length) return -1;
        if(index == length-1) return this.tail.value;
        LinkedListNode current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertHead(int val) {
        if(this.head == null) {
            this.head = new LinkedListNode(val);
            this.tail = this.head;
            length++;
            //System.out.println("INSERT HEAD: " + this.getValues());
            return;
        }
        LinkedListNode newHead = new LinkedListNode(val);
        newHead.next = this.head;
        this.head = newHead;
        this.length++;
        //System.out.println("INSERT HEAD: " + this.getValues());
    }

    public void insertTail(int val) {
        if(this.head == null || this.tail == null) {
            this.head = new LinkedListNode(val);
            this.tail = this.head;
            this.length++;
            //System.out.println("INSERT TAIL: " + this.getValues());
            return;
        }
        LinkedListNode newTail = new LinkedListNode(val);
        this.tail.next = newTail;
        this.tail = newTail;
        this.length++;
        //System.out.println("INSERT TAIL: " + this.getValues());
    }

    public boolean remove(int index) {
        if(head == null) return false;
        if(index >= length) return false;
        if(index == 0) {
            if(this.head.next == null) {
                this.tail = null;
                this.head = null;
                this.length--;
                //System.out.println("REMOVED, " + index + "REMAINING: " + this.getValues());
                return true;
            }
            LinkedListNode removedHead = this.head;
            this.head = removedHead.next;
            removedHead.next = null;
            this.length--;
            //System.out.println("REMOVED, " + index + "REMAINING: " + this.getValues());
            return true;
        }
        LinkedListNode current = this.head;
        for(int i = 0; i < index-1; i++) {
            current = current.next;
        }
        if(current.next.next == null) {
            this.tail = current;
            current.next = null;
            this.length--;
            //System.out.println("REMOVED, " + index + "REMAINING: " + this.getValues());
            return true;
        }
        LinkedListNode removedNode = current.next;
        current.next = removedNode.next;
        removedNode.next = null;
        this.length--;
        //System.out.println("REMOVED, " + index + "REMAINING: " + this.getValues());
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> valuesArr = new ArrayList<>();
        if(this.head == null) return valuesArr;
        LinkedListNode current = head;
        do {
            valuesArr.add(current.value);
            current = current.next;
        }
        while(current != null);
        return valuesArr;
    }
}
