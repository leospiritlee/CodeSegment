package com.leospiritlee.strategy.handler;

import com.leospiritlee.strategy.annotation.HandlerType;
import com.leospiritlee.strategy.dto.BaseReqDto;
import com.leospiritlee.strategy.enums.HandlerTypeEnum;

/**
 * @Project: CodeSegment
 * @ClassName Handler_B
 * @description: 业务处理B
 * @author: leospiritlee
 * @create: 2020-03-19 22:46
 **/
@HandlerType(HandlerTypeEnum.HANDLER_B)
public class Handler_B extends AbstractHandler{

    @Override
    protected void handler(BaseReqDto baseReqDto) {

    }
}
