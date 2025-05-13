package LeetCodehot;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-02-28 18:51
 **/
import java.util.Scanner;

public class wordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < board.length &&
                    newj >= 0 && newj < board[0].length) {
                if (backtrack(board, word, newi, newj, index + 1)) {
                    board[i][j] = temp; // 恢复当前字符
                    return true;
                }
            }
        }

        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入棋盘尺寸
        System.out.print("请输入棋盘行数 (m): ");
        int m = scanner.nextInt();
        System.out.print("请输入棋盘列数 (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        // 输入棋盘数据
        char[][] board = new char[m][n];
        System.out.println("请输入棋盘数据（每行" + n + "个连续字符，不要空格）:");
        for (int i = 0; i < m; i++) {
            String line;
            while (true) {
                System.out.print("第" + (i+1) + "行: ");
                line = scanner.nextLine().trim();
                if (line.length() == n) break;
                System.out.println("输入错误！每行必须包含" + n + "个字符");
            }
            board[i] = line.toCharArray();
        }

        // 输入查询单词
        System.out.print("请输入要查找的单词: ");
        String word = scanner.nextLine().trim();

        // 执行搜索
        wordSearch solution = new wordSearch();
        boolean result = solution.exist(board, word);

        // 输出结果
        System.out.println("\n棋盘:");
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println("\n查询单词: " + word);
        System.out.println("搜索结果: " + result);
    }
}
