package com.study.pattern.commandPattern;

/**
 * @author lwh
 * @date 2022/7/13 18:47
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
