package eecs2011.project;

public class HelperS3 {
    Graph g;
    Set s;
    Vertices v;

    public HelperS3(Graph g1, Set s1, Vertices v1){
        g = g1;
        s = s1;
        v = v1;
    }

    public void msCalculateX(Graph g1, Set known, Vertices v1){
        DoublyLinkedList level = new DoublyLinkedList();
        DoublyLinkedList ms = new DoublyLinkedList();


        known.puts(v1);
        level.addLast(v1);
        int levelTime = 0;
        int finalTime = 0;


        //levelMS.addLast(v1.functionMS);

        while (!level.isEmpty()){

            DoublyLinkedList nextLevel = new DoublyLinkedList();
            DoublyLinkedList.Node temp = level.head;


            for (temp = level.head; temp != null; temp = temp.next ) {

                DoublyLinkedList.Node temp2 = temp.element.outGoingEdges.head;


                for (temp2 = temp.element.outGoingEdges.head; temp2 != null; temp2 = temp2.next) {
                    Vertices u = temp2.getElement();
                    Vertices i = temp.getElement();

                    levelTime = i.functionMS;

                    if (!known.contains(u)) {
                        known.puts(u);
                        known.gets(u).functionRequiredMS = levelTime + i.functionRequiredMS;
                        nextLevel.addLast(u);

                        if (u.functionName == g1.size - 1){
                            ms.addLast(i);
                        }

                    } else {
                        if (u.functionName == g1.size - 1){
                            ms.addLast(i);
                        } else {
                            known.gets(u).functionRequiredMS = i.functionMS + i.functionRequiredMS;
                        }
                    }
                }
            }
            level = nextLevel;
        }

        DoublyLinkedList.Node target = ms.head;
        for (DoublyLinkedList.Node calculate = ms.head; calculate != null; calculate = calculate.next){

            if (calculate.getElement().functionRequiredMS > finalTime){
                target = calculate;
                finalTime = calculate.getElement().functionRequiredMS;
            }
        }
        finalTime = finalTime + target.getElement().functionMS;




        for (int count = 0; count < known.known.length; count++){
            Vertices v = known.known[count];
            if (v.functionName == 0){

            } else if (v.functionName == g1.size - 1){
                System.out.println(finalTime);
            } else {
                System.out.println(known.known[count].functionName + " " + v.functionRequiredMS);
                //totalMS = totalMS + temp3.element.functionMS;
            }
        }



    }


}
