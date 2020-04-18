package com.ctgu.enums;

public enum TriangleTypeEnum {
    GeneratorTriangle("一般三角形"),
    NotTriangle("非三角形"),
    IsoscelesTriangle("等腰三角形"),
    EquilateralTriangle("等边三角形");

    private final String text;

    TriangleTypeEnum(final String type){
        this.text = type;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
