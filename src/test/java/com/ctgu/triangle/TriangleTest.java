package com.ctgu.triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/三角形一般边界测试用例.csv", numLinesToSkip = 1)
    public void testNormalBoundary(int num, int a, int b, int c, String type) {
        assertEquals(type, Triangle.classifyTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/三角形最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testWorstCaseBoundary(int num, int a, int b, int c, String type) {
        assertEquals(type, Triangle.classifyTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/三角形健壮测试用例.csv", numLinesToSkip = 1)
    public void testRobustBoundary(int num, int a, int b, int c, String type) {
        assertEquals(type, Triangle.classifyTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/三角形健壮最坏情况测试用例.csv", numLinesToSkip = 1)
    public void testRobustWorstCaseBoundary(int num, int a, int b, int c, String type) {
        assertEquals(type, Triangle.classifyTriangle(a, b, c));
    }

}