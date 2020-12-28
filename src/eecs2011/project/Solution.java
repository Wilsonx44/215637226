package eecs2011.project;

import java.util.Scanner;

/**
 * The Solution class is where you write your solutions.
 * Please do NOT modify the method declarations and the package name.
 * You can add other classes to the package if needed.
 * Read data from standard input and write your answer to standard output.
 * We use pipelines to send input to your program and send your output to our judge system.
 * Please do NOT read and write data from and to the disk.
 * You should strictly follow the sample output format.
 * Please do not use any built-in/third-party data structures or algorithms.
 * Memory Limit: 256MB  Time Limit: 10s
 */
public class Solution {

    /**
     * Solution to Part 1
     */
    public void check_validity() {
        ; // read from standard input
        ; // do something
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of functions

        Graph g = new Graph(n);

        int[][] workflow = new int[n + 2][n + 2]; // workflow graph
        int[] rt = new int[n]; // response time of functions
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                workflow[i][j] = input.nextInt(); // read workflow graph from standard input
                if (workflow[i][j] == 1){
                    g.addEdge(i, j);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            rt[i] = input.nextInt(); // read response time from standard input
            g.addFunctionTime(i+1, rt[i]);
        }
        input.close();


        Set s = new Set(g.size);
        Set b = new Set(g.size);

        HelperS1 help = new HelperS1(g, s, g.getVertices(0));

        if (help.connectCheck(g,s,g.getVertices(0)) && s.noVoid() && !help.cycleCheck(g, b)){
            System.out.println("True");
        } else {
            System.out.println("false");
        }

    }

    /**
     * Solution Part 2
     */
    public void schedule_1() {
        ; // read from standard input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of functions

        Graph g = new Graph(n);

        int[][] workflow = new int[n + 2][n + 2]; // workflow graph
        int[] rt = new int[n]; // response time of functions
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                workflow[i][j] = input.nextInt(); // read workflow graph from standard input
                if (workflow[i][j] == 1){
                    g.addEdge(i, j);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            rt[i] = input.nextInt(); // read response time from standard input
            g.addFunctionTime(i+1, rt[i]);
        }
        input.close();

        Set s = new Set(g.size);
        HelperS2 help = new HelperS2(g, s, g.getVertices(0));
        DoublyLinkedList exe = new DoublyLinkedList();

        help.msCalculate(g, s, g.getVertices(0), exe);

    }

    /**
     * Solution to Part 3
     */
    public void schedule_x() {
        ; // read from standard input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of functions

        Graph g = new Graph(n);

        int[][] workflow = new int[n + 2][n + 2]; // workflow graph
        int[] rt = new int[n]; // response time of functions
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                workflow[i][j] = input.nextInt(); // read workflow graph from standard input
                if (workflow[i][j] == 1){
                    g.addEdge(i, j);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            rt[i] = input.nextInt(); // read response time from standard input
            g.addFunctionTime(i+1, rt[i]);
        }
        input.close();

        Set s = new Set(g.size);
        HelperS3 help = new HelperS3(g, s, g.getVertices(0));
        DoublyLinkedList exe = new DoublyLinkedList();
        help.msCalculateX(g, s, g.getVertices(0));

    }

    /**
     * Solution to Part 4 (optional)
     */
    public void schedule_2() {
        ; // read from standard input
        ; // do something
        ; // write your answer to standard output
    }
}
