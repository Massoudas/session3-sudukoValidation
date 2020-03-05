package com.company;

import java.util.Arrays;

public class Main {

    public static boolean validation(int[][] suduko){
        int i=0;
        int j=0;
        int k=0;
        boolean isValid=true;

        for(k=0;k<9;k++) {
            for (i = 0; i < 9; i++) {
                for (j = i + 1; j < 9; j++) {
                    if (suduko[i][k]==suduko[j][k]){
                        isValid=false;
                        return isValid;
                    }
                }
            }
        }
        for(k=0;k<9;k++) {
            for (i = 0; i < 9; i++) {
                for (j = i + 1; j < 9; j++) {
                    if (suduko[k][i]==suduko[k][j]){
                        isValid=false;
                        return isValid;
                    }
                }
            }
        }

        int l;
        int[] flatArray = new int[81];
        int a=0;

        for (k = 0; k < 8; k += 3) {
            for (l = 0; l < 8; l += 3) {
                for (i = k; i < k + 3; i++) {
                    for (j = l; j < l + 3; j++) {
                        flatArray [a]= suduko[i][j];
                        a++;
                    }
                }
            }
        }

        for (k = 0; k < 81; k+= 9) {
            for (i = k; i < k+8; i++) {
                for (j = i+1; j < k + 9; j++) {
                    if(flatArray[i]==flatArray[j])isValid=false;
                }
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };
        int[][] grid2 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {9, 1, 2, 3, 4, 5, 6, 7, 8},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {5, 1, 7, 8, 9, 6, 2, 3, 4},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}
        };

        System.out.println(validation(grid1));

    }
}
