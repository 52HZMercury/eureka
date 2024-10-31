package normal; /**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-20 11:10
 **/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ioOptimization {
    public static void main(String[] args) throws IOException {
        // 输入文件路径
        String filePath = "some file path";
        File file = new File(filePath);

        // 读取文件内容到字符串列表中
        List<String> lines = readFile(file);

        // 替换字符串列表中的内容
        replace(lines);

        // 将替换后的内容写回到文件中
        writeFile(file, lines);
    }

    /**
     * 读取文件内容到字符串列表中
     * @param file 文件对象
     * @return 字符串列表
     */
    private static List<String> readFile(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * 替换字符串列表中的内容
     * @param lines 字符串列表
     */
    private static void replace(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replaceAll("1", "a");
            line = line.replaceAll("2", "b");
            line = line.replaceAll("3", "c");
            line = line.replaceAll("4", "d");
            lines.set(i, line);
        }
    }

    /**
     * 将字符串列表写回到文件中
     * @param file 文件对象
     * @param lines 字符串列表
     * @throws IOException 写入文件异常
     */
    private static void writeFile(File file, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}

