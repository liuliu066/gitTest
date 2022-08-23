package com.study.designPatterns.strategy;

/**
 * @author lwh
 * @description:
 * @date 2022/8/11 14:48
 */
public class StrategyClass {

    private GameStrategy gameStrategy;
    public StrategyClass(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }
    public void executeGameStrategy(){
        gameStrategy.play();
    }

}
