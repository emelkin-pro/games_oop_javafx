package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return checkVertical(board) || checkHorizontal(board);
    }

    public static boolean checkVertical(int[][] board) {
        boolean verticalRsl = false;
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 1) {
                for (int i = 1; i < board.length; i++) {
                    if (board[i][j] == 1) {
                        verticalRsl = true;
                    } else {
                        verticalRsl = false;
                        break;
                    }
                }
            }
        }
        return verticalRsl;
    }

    public static boolean checkHorizontal(int[][] board) {
        boolean horizontalRsl = true;
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][0] == 1) {
                for (int j = 1; j < board.length; j++) {
                    if (board[i][j] == 1) {
                        horizontalRsl = true;
                    } else {
                        horizontalRsl = false;
                        break;
                    }
                }
            }
        }
        return horizontalRsl;
    }
}
