package com.ctgu.triangle;

import com.ctgu.enums.TriangleTypeEnum;

public class Triangle {
    /**
     * 输入三条边, 判断组成三角形的类型
     * @param a 边长
     * @param b 边长
     * @param c 边长
     * @return 三角形的类型
     */
    public static String classifyTriangle(int a, int b, int c){
        // 判断能否构成三角形
        if(!((a + b > c) && (a + c > b) && (b + c > a))){
            return TriangleTypeEnum.NotTriangle.toString();
        }
        // 判断等边三角形
        if(a == b && b == c && a == c){
            return TriangleTypeEnum.EquilateralTriangle.toString();
        }
        // 判断等腰三角形
        if(a == b || b == c || a == c){
            return TriangleTypeEnum.IsoscelesTriangle.toString();
        }
        // 一般三角形
        return TriangleTypeEnum.GeneratorTriangle.toString();
    }

}
