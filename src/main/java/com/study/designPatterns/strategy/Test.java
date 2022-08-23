package com.study.designPatterns.strategy;

/**
 * @author lwh
 * @description:
 * @date 2022/8/11 14:51
 */
public class Test {

    public static void main(String[] args) {
        GamePlay1 gamePlay1 = new GamePlay1();
        StrategyClass strategyClass = new StrategyClass(gamePlay1);
        strategyClass.executeGameStrategy();
        StrategyClass strategyClass1 = new StrategyClass(new GamePlay2());
        strategyClass1.executeGameStrategy();

    }
}
