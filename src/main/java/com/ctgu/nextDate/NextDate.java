package com.ctgu.nextDate;

public class NextDate {
    private static final String ERROR_INFO = "Invalid date";

    /**
     * 输入年、月、日, 返回下一天的日期
     * @param year 年份
     * @param month 月份
     * @param day 日
     * @return 下一天的日期
     */
    public static String theNextDate(int year, int month, int day) {
        // 判断输入的日期是否合法
        if (!(1900 <= year && year <= 2050 && 1 <= month && month <= 12 && 1 <= day && day <= 31)) {
            return ERROR_INFO;
        }
        int two = 28;
        // 闰年29天
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            two = 29;
        }
        // 判断该月份的天数
        int d = 31;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                d = 31;
                break;
            case 2:
                d = two;
                break;
            default:
                d = 30;
        }
        // 如果输入的天数与月份拥有的天数不一致
        if(day > d){
            return ERROR_INFO;
        }
        int yy, mm, dd;
        day += 1;
        // 这里已经判断day在有效范围内，所以+1后只可能超出1天, 如果天数比该月天数大1，则天数变为1, 否则不变
        dd = day > d ? 1 : day;
        // 如果天数超出范围则月份+1, 否则不变
        mm = day > d ? month + 1 : month;
        // 月份变为13，则年份+1
        yy = mm == 13 ? year + 1 : year;
        // 如果月份为13，则修改为1
        mm = mm == 13 ? 1 : mm;
        return yy + "年" + mm + "月" + dd + "日";
    }

}
