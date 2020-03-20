package com.leospiritlee.strategy.handler;

import com.leospiritlee.strategy.annotation.HandlerType;
import com.leospiritlee.strategy.dto.BaseReqDto;
import com.leospiritlee.strategy.enums.HandlerTypeEnum;

/**
 * @Project: CodeSegment
 * @ClassName Handler_A
 * @description: 业务处理A
 * @author: leospiritlee
 * @create: 2020-03-19 22:46
 **/
@HandlerType(HandlerTypeEnum.HANDLER_A)
public class Handler_A extends AbstractHandler{

    @Override
    protected void handler(BaseReqDto baseReqDto) {
        System.out.println("Handler_A handler");
    }
}
