package org.example;

import java.util.HashSet;
import java.util.Map;

public class LCS {

    public static void main(String[] args) {
        int[] arr = {0,3,2,5,4,6,1,1};
        HashSet<Integer> arrSet = new HashSet<>();
        for (int j : arr) {
            arrSet.add(j);
        }
        int ll = 0;
        for (int j : arr) {
            if (!arrSet.contains(j - 1)){
                int length = 1;
                while (arrSet.contains(j+1)){
                    j= j+1;
                    length+=1;
                }
                if (length > ll){
                    ll =length;
                }
            }
        }
        System.out.println(ll);
    }
}
