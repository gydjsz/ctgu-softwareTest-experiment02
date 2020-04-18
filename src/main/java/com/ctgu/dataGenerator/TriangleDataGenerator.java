package com.ctgu.dataGenerator;
import	java.io.File;

import com.ctgu.triangle.Triangle;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TriangleDataGenerator {
    // 测试样例存放路径
    private static final String dir = "src/test/resources/triangle/";

    /**
     * 创建一个CSVPrinter对象
     * @param fileName 文件名
     * @return 一个CVSPrinter对象
     * @throws IOException
     */
    public static CSVPrinter createCSVPrinter(String fileName) throws IOException {
        File file = new File(dir);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(dir + fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
        CSVPrinter printer = new CSVPrinter(osw, csvFormat);
        return printer;
    }

    /**
     * 生成一般边界测试数据, 4n + 1
     * @throws IOException
     */
    public static void normalBoundaryValue() throws IOException {
        int sideA[] = {1, 2, 50, 99, 100};
        int sideB[] = {1, 2, 50, 99, 100};
        int sideC[] = {1, 2, 50, 99, 100};
        CSVPrinter csvPrinter = createCSVPrinter("三角形一般边界测试用例.csv");
        int num = 0;
        for (int a : sideA) {
            for (int b : sideB) {
                for (int c : sideC) {
                    if((a == 50 && a == b) || (a == 50 && a == c) || (b == 50 && b == c)){
                        csvPrinter.printRecord(++num, a, b, c, Triangle.classifyTriangle(a, b, c));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成最坏情况边界测试数据, 6n + 1
     * @throws IOException
     */
    public static void worstCaseBoundaryValue() throws IOException {
        int sideA[] = {0, 1, 2, 50, 99, 100, 101};
        int sideB[] = {0, 1, 2, 50, 99, 100, 101};
        int sideC[] = {0, 1, 2, 50, 99, 100, 101};
        CSVPrinter csvPrinter = createCSVPrinter("三角形最坏情况测试用例.csv");
        int num = 0;
        for (int a : sideA) {
            for (int b : sideB) {
                for (int c : sideC) {
                    if((a == 50 && a == b) || (a == 50 && a == c) || (b == 50 && b == c)){
                        csvPrinter.printRecord(++num, a, b, c, Triangle.classifyTriangle(a, b, c));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成健壮边界测试数据, 5^n
     * @throws IOException
     */
    public static void robustBoundaryValue() throws IOException {
        int sideA[] = {1, 2, 50, 99, 100};
        int sideB[] = {1, 2, 50, 99, 100};
        int sideC[] = {1, 2, 50, 99, 100};
        CSVPrinter csvPrinter = createCSVPrinter("三角形健壮测试用例.csv");
        int num = 0;
        for (int a : sideA) {
            for (int b : sideB) {
                for (int c : sideC) {
                    csvPrinter.printRecord(++num, a, b, c, Triangle.classifyTriangle(a, b, c));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成健壮最坏情况测试用例, 7^n
     * @throws IOException
     */
    public static void robustWorstCaseBoundaryValue() throws IOException {
        int sideA[] = {0, 1, 2, 50, 99, 100, 101};
        int sideB[] = {0, 1, 2, 50, 99, 100, 101};
        int sideC[] = {0, 1, 2, 50, 99, 100, 101};
        CSVPrinter csvPrinter = createCSVPrinter("三角形健壮最坏情况测试用例.csv");
        int num = 0;
        for (int a : sideA) {
            for (int b : sideB) {
                for (int c : sideC) {
                    csvPrinter.printRecord(++num, a, b, c, Triangle.classifyTriangle(a, b, c));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    public static void main(String[] args) throws IOException {
        //生成一般边界测试数据
        normalBoundaryValue();
        //生成最坏情况边界测试数据
        worstCaseBoundaryValue();
        //生成健壮边界测试数据
        robustBoundaryValue();
        //生成健壮最坏情况测试用例
        robustWorstCaseBoundaryValue();
    }
}
