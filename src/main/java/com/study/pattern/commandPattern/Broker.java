package com.study.pattern.commandPattern;

/**
 * 创建命令调用类。
 * @author lwh
 * @date 2022/7/13 18:47
 */
import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}