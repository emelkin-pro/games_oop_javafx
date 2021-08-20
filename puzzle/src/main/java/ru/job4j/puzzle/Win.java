package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (checkHorizontal(board, i) || checkVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean checkVertical(int[][] board, int column) {
        boolean verticalRsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                verticalRsl = false;
                break;
            }
        }
        return verticalRsl;
    }

    public static boolean checkHorizontal(int[][] board, int row) {
        boolean horizontalRsl = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                horizontalRsl = false;
                break;
            }
        }
        return horizontalRsl;
    }
}