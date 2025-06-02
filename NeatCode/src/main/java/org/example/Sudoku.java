package org.example;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {
        String[][] input = { {"1","4",".",".","3",".",".",".","."},
                {"4",".",".","5",".",".",".",".","."},
                {".","9","8",".",".",".",".",".","3"},
                {"5",".",".",".","6",".",".",".","4"},
                {".",".",".","8",".","3",".",".","5"},
                {"7",".",".",".","2",".",".",".","6"},
                {".",".",".",".",".",".","2",".","."},
                {".",".",".","4","1","9",".",".","8"},
                {".",".",".",".","8",".",".","7","9"}};

        int n= 9;
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int val;
            int colVal;
            for (int j = 0; j < n; j++) {
                if (!input[i][j].equals(".")) {
                    val = Integer.parseInt(input[i][j]);
                    if (set.contains(val)) {
                        System.out.println("not a valid sudoku");
                        return;
                    } else {
                        set.add(val);
                    }
                }

                if (!input[j][i].equals(".")) {
                    colVal = Integer.parseInt(input[j][i]);
                    if (colSet.contains(colVal)) {
                        System.out.println("not a valid sudoku");
                        return;
                    } else {
                        colSet.add(colVal);
                    }
                }

                if (!input[i][j].equals(".")) {
                    val = Integer.parseInt(input[i][j]);
                    int box = (i / 3) * 3 + (j / 3);
                    if (sets[box] == null) {
                        sets[box] = new HashSet<>();
                    }
                    if (sets[box].contains(val)) {
                        System.out.println("not a valid sudoku box");
                        return;
                    } else {
                        sets[box].add(val);
                    }
                }

            }
            System.out.println("done first pass");
        }
    }
}
