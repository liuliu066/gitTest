package com.study.pattern.commandPattern;

/**
 * @author lwh
 * @date 2022/7/13 18:47
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}