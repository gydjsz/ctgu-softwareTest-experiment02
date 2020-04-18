package com.ctgu.dataGenerator;

import com.ctgu.nextDate.NextDate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NextDateDataGenerator {
    // 测试样例存放路径
    private static final String dir = "src/test/resources/nextDate/";

    /**
     * 创建一个CSVPrinter对象
     * @param fileName 文件名
     * @return 一个CVSPrinter对象
     * @throws IOException
     */
    public static CSVPrinter createCSVPrinter(String fileName) throws IOException {
        File file = new File(dir);
        if (!file.exists()) {
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
     *
     * @throws IOException
     */
    public static void normalBoundaryValue() throws IOException {
        int year[] = {1900, 1901, 1975, 2049, 2050};
        int month[] = {1, 2, 6, 11, 12};
        int day[] = {1, 2, 15, 30, 31};
        CSVPrinter csvPrinter = createCSVPrinter("NextDate一般边界测试用例.csv");
        int num = 0;
        for (int y : year) {
            for (int m : month) {
                for (int d : day) {
                    if ((y != 1975 && m == 6 && d == 15) || (y == 1975 && m != 6 && d == 15) || (y == 1975 && m == 6 && d != 15) || (y == 1975 && m == 6 && d == 15)) {
                        csvPrinter.printRecord(++num, y, m, d, NextDate.theNextDate(y, m, d));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成最坏情况边界测试数据, 6n + 1
     *
     * @throws IOException
     */
    public static void worstCaseBoundaryValue() throws IOException {
        int year[] = {1899, 1900, 1901, 1975, 2049, 2050, 2051};
        int month[] = {0, 1, 2, 6, 11, 12, 13};
        int day[] = {0, 1, 2, 15, 30, 31, 32};
        CSVPrinter csvPrinter = createCSVPrinter("NextDate最坏情况测试用例.csv");
        int num = 0;
        for (int y : year) {
            for (int m : month) {
                for (int d : day) {
                    if ((y != 1975 && m == 6 && d == 15) || (y == 1975 && m != 6 && d == 15) || (y == 1975 && m == 6 && d != 15) || (y == 1975 && m == 6 && d == 15)) {
                        csvPrinter.printRecord(++num, y, m, d, NextDate.theNextDate(y, m, d));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成健壮边界测试数据, 5^n
     *
     * @throws IOException
     */
    public static void robustBoundaryValue() throws IOException {
        int year[] = {1900, 1901, 1975, 2049, 2050};
        int month[] = {1, 2, 6, 11, 12};
        int day[] = {1, 2, 15, 30, 31};
        CSVPrinter csvPrinter = createCSVPrinter("NextDate健壮测试用例.csv");
        int num = 0;
        for (int y : year) {
            for (int m : month) {
                for (int d : day) {
                    csvPrinter.printRecord(++num, y, m, d, NextDate.theNextDate(y, m, d));
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
        int year[] = {1899, 1900, 1901, 1975, 2049, 2050, 2051};
        int month[] = {0, 1, 2, 6, 11, 12, 13};
        int day[] = {0, 1, 2, 15, 30, 31, 32};
        CSVPrinter csvPrinter = createCSVPrinter("NextDate健壮最坏情况测试用例.csv");
        int num = 0;
        for (int y : year) {
            for (int m : month) {
                for (int d : day) {
                    csvPrinter.printRecord(++num, y, m, d, NextDate.theNextDate(y, m, d));
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
