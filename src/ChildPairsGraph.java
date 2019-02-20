/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:


1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   10

Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Sample output (pseudodata):
[
  [1, 2, 4],   // Individuals with zero parents
  [5, 7, 8, 10] // Individuals with exactly one parent
]


*/


import java.io.*;
import java.util.*;

class ChildPairsGraph {

    private static List<String> childPairs(int[][] pcp){
        // int nodes;
        // TreeSet ts = new TreeSet();
        // for (int i=0; i< pcp.length; i++){
        //     ts.add(pcp[i][0]);
        //     ts.add(pcp[i][1]);
        // }
        // int nodes=ts.size();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i=0; i< pcp.length; i++){
            if (!map.containsKey(pcp[i][0])){
                map.put(pcp[i][0],0);
            }
            map.put(pcp[i][1],map.getOrDefault(pcp[i][1],0) + 1 );

        }
//        for (int i=0; i< pcp.length; i++){
//            map.put(pcp[i][0],map.getOrDefault(pcp[i][0],0) );
//
//        }
        System.out.println(map);
        return null;

    }

    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };


        childPairs(parentChildPairs);





    }
}