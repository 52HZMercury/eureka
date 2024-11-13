package hot100;
import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-11-13 20:27
 **/
public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        StringBuilder path = new StringBuilder();
        dfs(path, n, n, res);
        return res;
    }

    private void dfs(StringBuilder path, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝
            res.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generateParenthesis gp = new generateParenthesis();
        List<String> res = gp.generateParenthesis(n);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
}
