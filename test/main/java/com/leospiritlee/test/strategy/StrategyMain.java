package com.leospiritlee.test.strategy;

import com.leospiritlee.strategy.dto.BaseReqDto;
import com.leospiritlee.strategy.enums.HandlerTypeEnum;
import com.leospiritlee.strategy.factory.HandlerFactory;

/**
 * @Project: CodeSegment
 * @ClassName StrategyMain
 * @description: 策略入口
 * @author: leospiritlee
 * @create: 2020-03-20 23:10
 **/
public class StrategyMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        HandlerFactory.getHandlerClass(HandlerTypeEnum.HANDLER_A).facade(new BaseReqDto());
        HandlerFactory.getHandlerClass(HandlerTypeEnum.HANDLER_B).facade(new BaseReqDto());
        HandlerFactory.getHandlerClass(HandlerTypeEnum.HANDLER_C).facade(new BaseReqDto());
    }

}
