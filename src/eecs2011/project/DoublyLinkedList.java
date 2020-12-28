package eecs2011.project;

public class DoublyLinkedList {
    public static class Node {
        public Vertices element;
        public DoublyLinkedList.Node next;
        public DoublyLinkedList.Node prev;
        public Node(Vertices e, DoublyLinkedList.Node n, DoublyLinkedList.Node p){
            element = e;
            next = n;
            prev = p;
        }
        public Vertices getElement(){
            return element;
        }

        public DoublyLinkedList.Node getNext(){
            return next;
        }

        public DoublyLinkedList.Node getPrev(){
            return prev;
        }

        public void setNext (DoublyLinkedList.Node n){
            next = n;
        }

        public void setPrev (DoublyLinkedList.Node p){ prev = p; }
    }

    public DoublyLinkedList.Node head = null;
    public DoublyLinkedList.Node tail = null;
    public int size = 0;

    public DoublyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Vertices first(){
        if (isEmpty()){
            return null;
        }
        return head.getElement();
    }

    public Vertices last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(Vertices e){

        DoublyLinkedList.Node temp;
        temp = new DoublyLinkedList.Node(e, head, null);
        if (size!=0){
            head.setPrev(temp);
        }
        head = temp;

        if (size == 0){
            tail = head;
        }
        size++;
    }

    public void addLast(Vertices e){
        DoublyLinkedList.Node temp;
        temp = new DoublyLinkedList.Node(e, null, tail);

        if (size!=0) {
            tail.setNext(temp);
        }
        tail = temp;

        if (isEmpty()) {
            head = temp;
        }
        size++;

    }

    public Vertices removeFirst(){
        if (isEmpty()){
            return null;
        }

        Vertices answer = head.getElement();
        head = head.getNext();
        if (size != 1) {
            head.prev = null;
        }
        size--;

        if (size == 0){
            tail = null;
        }
        return answer;
    }

    public Vertices removeLast(){
        if (isEmpty()){
            return null;
        }


        Vertices answer = tail.getElement();



        if (size == 1){
            head = null;
            tail = null;
            size--;
            return answer;
        }

        else {
            tail = tail.getPrev();
            tail.setNext(null);


        }
        size--;

        return answer;
    }

    public boolean contains(Vertices e){
        boolean answer = false;
        DoublyLinkedList.Node temp = head;

        while (temp != null){
            if (temp.element == e){
                answer = true;
                return answer;
            }
            temp = temp.next;
        }

        return answer;


    }

    public void addBefore(Vertices from, Vertices dest){
        DoublyLinkedList.Node temp;
        DoublyLinkedList.Node target = null;


        for (temp = head; temp != null && temp.element.functionName != dest.functionName ; temp = temp.next){

        }
        target = temp;

        DoublyLinkedList.Node insert = new Node(from, target, target.prev);
        target.prev.next = insert;
        target.prev = insert;
        size++;
    }

    public void addAfter(Vertices from, Vertices dest){
        DoublyLinkedList.Node temp;
        DoublyLinkedList.Node target = null;


        for (temp = head; temp.element.functionName != dest.functionName && temp != null; temp = temp.next){

        }
        target = temp;

        DoublyLinkedList.Node insert = new Node(from, target.next, target);
        target.next.prev = insert;
        target.next = insert;
        size++;
    }



    public Vertices removeAt(Vertices from){
        DoublyLinkedList.Node temp;
        DoublyLinkedList.Node target = null;


        for (temp = head; temp != null && temp.element.functionName != from.functionName ; temp = temp.next){

        }
        target = temp;

        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.next = null;
        target.prev = null;

        return target.element;

    }




}
