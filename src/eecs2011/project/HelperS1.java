package eecs2011.project;

public class HelperS1 {
    Graph g;
    Set s;
    Vertices v;

    public HelperS1(Graph g1, Set s1, Vertices v1){
        g = g1;
        s = s1;
        v = v1;
    }

    public boolean connectCheck(Graph g1, Set known, Vertices v1) {

        known.puts(v1);

        DoublyLinkedList.Node temp = v1.outGoingEdges.head;
        if (temp == null) {
            if (v1 != g1.vertCollect[g1.size - 1]) {
                return false;
            }
        } else {
            for (temp = v1.outGoingEdges.head; temp != null; temp = temp.next) {
                Vertices u = temp.getElement();
                if (!known.contains(u)) {
                    connectCheck(g1, known, u);
                }
            }
        }
        return true;
    }

    public boolean cycleHelper(Graph g1, Set known, Vertices v1, boolean[] recursiveCall){

        if (recursiveCall[v1.functionName]){
            return true;
        }
        if (known.contains(v1)){
            return false;
        }
        recursiveCall[v1.functionName] = true;
        known.puts(v1);


        DoublyLinkedList.Node temp = v1.outGoingEdges.head;
        for (temp = v1.outGoingEdges.head; temp != null; temp = temp.next) {
            Vertices u = temp.getElement();
            if (cycleHelper(g1, known, u, recursiveCall)) {
                return true;
            }
        }
        recursiveCall[v1.functionName] = false;
        return false;
    }

    public boolean cycleCheck(Graph g1, Set known){
        boolean[] recursiveStack = new boolean[g1.size];
        for (int s = 0; s < g1.size; s++){
            if (cycleHelper(g1, known, g1.getVertices(s), recursiveStack)){
                return true;
            }
        }
        return false;

    }

}
