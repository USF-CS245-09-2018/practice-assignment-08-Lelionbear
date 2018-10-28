public class LinkedList implements List {
    public class Node{
        public Object data;
        public Node next;

        public Node(){
            next = null;
        }

        public Node(Object obj){
            data = obj;
            next = null;
        }
    }
    private Node head;
    private int size = 0;

    public LinkedList(){
        head = new Node();
    }
    @Override
    public void add(Object obj) throws Exception {
        if (head.next == null){
            head = new Node(obj);
        }
        else{
            Node current = head;
            head =  new Node(obj);
            head.next = current;
        }
        size++;
    }

    public Node find(int pos){
        Node node = head;
        for (int i = 0; i < pos; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(int pos, Object obj) throws Exception {
//        if (pos < 0 || pos > size)
//            throw new Exception("invalid position");
        Node newNode = new Node(obj);
        if (pos == 0){
            newNode.next = head;
            head = newNode;
        }else{
            Node previous = find(pos-1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }

    @Override
    public Object get(int pos) throws Exception {
        if (pos < 0 || pos >= size)
            throw new Exception("invalid position");
        return find(pos).data;
    }

    @Override
    public Object remove(int pos) throws Exception {
        if (pos < 0 || pos >= size)
            throw new Exception("invalid position");
        if (pos == 0){
            Node rmNode = head;
            head = head.next;
            --size;
            return rmNode.data;
        }
        Node previous = find(pos-1);
        Node current = previous.next;
        previous.next = current.next;
        --size;
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }
}
