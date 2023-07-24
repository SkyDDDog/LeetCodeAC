package com.lear.swardToOffer.offer29;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Main {

    public static void main(String[] args) {

    }

}

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];
        int[] result = new int[total];
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int directionIndex = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < total; i++) {
            result[i] = matrix[row][col];
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow<0 || nextRow>=rows || nextCol<0 || nextCol>=columns || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex+1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return result;
    }
}