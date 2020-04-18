package com.ctgu.nextDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.*;

public class NextDateTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/NextDate一般边界测试用例.csv", numLinesToSkip = 1)
    public void testNormalBoundary(int num, int year, int month, int day, String type) {
        assertEquals(type, NextDate.theNextDate(year, month, day));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/NextDate最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testWorstCaseBoundary(int num, int year, int month, int day, String type) {
        assertEquals(type, NextDate.theNextDate(year, month, day));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/NextDate健壮测试用例.csv", numLinesToSkip = 1)
    public void testRobustBoundary(int num, int year, int month, int day, String type) {
        assertEquals(type, NextDate.theNextDate(year, month, day));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/NextDate健壮最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testRobustWorstCaseBoundary(int num, int year, int month, int day, String type) {
        assertEquals(type, NextDate.theNextDate(year, month, day));
    }

}