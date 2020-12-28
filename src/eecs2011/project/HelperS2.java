package eecs2011.project;

public class HelperS2 {
    Graph g;
    Set s;
    Vertices v;

    public HelperS2(Graph g1, Set s1, Vertices v1){
        g = g1;
        s = s1;
        v = v1;
    }

    public void msCalculate(Graph g1, Set known, Vertices v1, DoublyLinkedList order){
        DoublyLinkedList level = new DoublyLinkedList();


        known.puts(v1);
        level.addLast(v1);

        order.addLast(v1);

        while (!level.isEmpty()){
            DoublyLinkedList nextLevel = new DoublyLinkedList();
            DoublyLinkedList.Node temp = level.head;


            for (temp = level.head; temp != null; temp = temp.next ) {

                DoublyLinkedList.Node temp2 = temp.element.outGoingEdges.head;

                for (temp2 = temp.element.outGoingEdges.head; temp2 != null; temp2 = temp2.next) {
                    Vertices u = temp2.getElement();
                    Vertices i = temp.getElement();


                    if (!known.contains(u)) {
                        known.puts(u);
                        order.addLast(u);

                        nextLevel.addLast(u);
                    } else {
                        if (u.functionName == g1.size - 1){

                        } else {
                            order.removeAt(i);

                            order.addBefore(i, u);
                        }
                    }
                }
            }
            level = nextLevel;
        }

        DoublyLinkedList.Node temp3;
        int totalMS = 0;
        for (temp3 = order.head; temp3 != null; temp3 = temp3.next){

            if (temp3.element.functionName == 0){

            } else if (temp3.element.functionName == g1.size - 1){
                System.out.println(totalMS);
            } else {
                System.out.println(temp3.element.functionName + "  " + totalMS);
                totalMS = totalMS + temp3.element.functionMS;
            }

        }

    }


}
