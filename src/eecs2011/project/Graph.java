package eecs2011.project;

import java.util.Iterator;

public class Graph {
    Vertices[] vertCollect;
    int size;


    public Graph (int totalSize){
        this.size = totalSize+2;
        vertCollect = new Vertices[this.size];
        for (int i = 0; i < this.size; i++){
            vertCollect[i] = new Vertices(i);
        }
    }

    public void addVertices(int name){
        this.vertCollect[name] = new Vertices(name);
    }

    public void addEdge(int start, int dest){
        if (this.vertCollect[start] == null){
            addVertices(start);
        }
        if (this.vertCollect[dest] == null){
            addVertices(dest);
        }

        vertCollect[start].outGoingEdges.addLast(vertCollect[dest]);
    }

    public void addFunctionTime(int dest, int value){
        vertCollect[dest].functionMS = value;
    }

    public boolean hasEdges(int start, int dest){
        return vertCollect[start].outGoingEdges.contains(vertCollect[dest]);
    }

    public boolean hasVertices(int name){
        if (vertCollect[name] == null){
            return false;
        } else {
            return true;
        }
    }

    public Vertices getVertices(int name){
        return vertCollect[name];
    }

    public void printVerticesEdges(int name){
        DoublyLinkedList.Node temp;
        for (temp = vertCollect[name].outGoingEdges.head; temp != null; temp = temp.next){
            System.out.println(temp.element.functionName);
        }

    }










}
