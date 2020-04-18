package com.ctgu.dataGenerator;

import com.ctgu.commission.Commission;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CommissionDataGenerator {
    // 测试样例存放路径
    private static final String dir = "src/test/resources/commission/";

    /**
     * 创建一个CSVPrinter对象
     *
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
        int locks[] = {1, 2, 35, 69, 70};
        int stocks[] = {1, 2, 40, 79, 80};
        int barrels[] = {1, 2, 45, 89, 90};
        CSVPrinter csvPrinter = createCSVPrinter("佣金问题一般边界测试用例.csv");
        int num = 0;
        for (int lock : locks) {
            for (int stock : stocks) {
                for (int barrel : barrels) {
                    if ((lock != 35 && stock == 40 && barrel == 45) || (lock == 35 && stock != 40 && barrel == 45) || (lock == 35 && stock == 40 && barrel != 45) || (lock == 35 && stock == 40 && barrel == 45)) {
                        csvPrinter.printRecord(++num, lock, stock, barrel, Commission.theCommission(lock, stock, barrel));
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
        int locks[] = {0, 1, 2, 35, 69, 70, 71};
        int stocks[] = {0, 1, 2, 40, 79, 80, 81};
        int barrels[] = {0, 1, 2, 45, 89, 90, 91};
        CSVPrinter csvPrinter = createCSVPrinter("佣金问题最坏情况测试用例.csv");
        int num = 0;
        for (int lock : locks) {
            for (int stock : stocks) {
                for (int barrel : barrels) {
                    if ((lock != 35 && stock == 40 && barrel == 45) || (lock == 35 && stock != 40 && barrel == 45) || (lock == 35 && stock == 40 && barrel != 45) || (lock == 35 && stock == 40 && barrel == 45)) {
                        csvPrinter.printRecord(++num, lock, stock, barrel, Commission.theCommission(lock, stock, barrel));
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
        int locks[] = {1, 2, 35, 69, 70};
        int stocks[] = {1, 2, 40, 79, 80};
        int barrels[] = {1, 2, 45, 89, 90};
        CSVPrinter csvPrinter = createCSVPrinter("佣金问题健壮测试用例.csv");
        int num = 0;
        for (int lock : locks) {
            for (int stock : stocks) {
                for (int barrel : barrels) {
                    csvPrinter.printRecord(++num, lock, stock, barrel, Commission.theCommission(lock, stock, barrel));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 生成健壮最坏情况测试用例, 7^n
     *
     * @throws IOException
     */
    public static void robustWorstCaseBoundaryValue() throws IOException {
        int locks[] = {0, 1, 2, 35, 69, 70, 71};
        int stocks[] = {0, 1, 2, 40, 79, 80, 81};
        int barrels[] = {0, 1, 2, 45, 89, 90, 91};
        CSVPrinter csvPrinter = createCSVPrinter("佣金问题健壮最坏情况测试用例.csv");
        int num = 0;
        for (int lock : locks) {
            for (int stock : stocks) {
                for (int barrel : barrels) {
                    csvPrinter.printRecord(++num, lock, stock, barrel, Commission.theCommission(lock, stock, barrel));
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
