package com.ctgu.commission;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

public class CommissionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/佣金问题一般边界测试用例.csv", numLinesToSkip = 1)
    public void testNormalBoundary(int num, int lock, int stock, int barrel, String commissionPrice) {
        assertEquals(commissionPrice, Commission.theCommission(lock, stock, barrel));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/佣金问题最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testWorstCaseBoundary(int num, int lock, int stock, int barrel, String commissionPrice) {
        assertEquals(commissionPrice, Commission.theCommission(lock, stock, barrel));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/佣金问题健壮测试用例.csv", numLinesToSkip = 1)
    public void testRobustBoundary(int num, int lock, int stock, int barrel, String commissionPrice) {
        assertEquals(commissionPrice, Commission.theCommission(lock, stock, barrel));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/佣金问题健壮最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testRobustWorstCaseBoundary(int num, int lock, int stock, int barrel, String commissionPrice) {
        assertEquals(commissionPrice, Commission.theCommission(lock, stock, barrel));
    }

}