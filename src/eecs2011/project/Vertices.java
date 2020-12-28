package eecs2011.project;

public class Vertices {
    int functionName;
    int functionMS;
    int functionRequiredMS;
    DoublyLinkedList outGoingEdges;

    public Vertices(int name){
        this.functionName = name;
        outGoingEdges = new DoublyLinkedList();
    }
}
