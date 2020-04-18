package com.ctgu.enums;

public enum CommissionEnum {
    LOCKS_ERROR_NUM("lock的取值不在有效范围1~70内"),
    STOCKS_ERROR_NUM("stock的取值不在有效范围1~80内"),
    BARRELS_ERROR_NUM("barrel的取值不在有效范围1~90内");

    private final String text;

    CommissionEnum(final String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
