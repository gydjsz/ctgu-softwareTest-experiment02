package com.ctgu.commission;

import com.ctgu.enums.CommissionEnum;

import java.math.BigDecimal;

public class Commission {
    // 枪机单价
    private static final double lockUnitPrice = 45;
    // 枪托单价
    private static final double stockUnitPrice = 30;
    // 枪管单价
    private static final double barrelUnitPrice = 25;

    /**
     * 输入枪机（lock）、枪托（stock）和枪管（barrel）的数量, 求出佣金
     * @param lock 枪机数
     * @param stock 枪托数
     * @param barrel 枪管数
     * @return 返回佣金的金额
     */
    public static String theCommission(int lock, int stock, int barrel) {
        // 判断输入参数是否在有效范围内
        if (!(0 <= lock && lock <= 70)) {
            return CommissionEnum.LOCKS_ERROR_NUM.toString();
        }
        if(!(0 <= stock && stock <= 80)){
            return CommissionEnum.STOCKS_ERROR_NUM.toString();
        }
        if(!(0 <= barrel && barrel <= 90)){
            return CommissionEnum.BARRELS_ERROR_NUM.toString();
        }
        // 求出各个配件的销售金额
        double lockPrice, stockPrice, barrelPrice;
        lockPrice = lock * lockUnitPrice;
        stockPrice = stock * stockUnitPrice;
        barrelPrice = barrel * barrelUnitPrice;
        // 求出总金额
        double total = lockPrice + stockPrice + barrelPrice;
        double commissionPrice = 0;
        // 根据条件计算佣金
        if (total <= 1000) {
            commissionPrice = total * 0.1;
        } else if (1000 <= commissionPrice && commissionPrice <= 1800) {
            commissionPrice = 1000 * 0.1 + (total - 1000) *0.15;
        } else {
            commissionPrice = 1000 * 0.1 + 800 * 0.15 + (total - 1800) * 0.2;
        }
        String price = new BigDecimal(commissionPrice).stripTrailingZeros().toPlainString();
        return price + "美元";
    }

}
