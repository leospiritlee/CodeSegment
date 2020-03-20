package com.leospiritlee.strategy.handler;

import com.leospiritlee.strategy.annotation.HandlerType;
import com.leospiritlee.strategy.dto.BaseReqDto;
import com.leospiritlee.strategy.enums.HandlerTypeEnum;

/**
 * @Project: CodeSegment
 * @ClassName Handler_C
 * @description: 业务处理C
 * @author: leospiritlee
 * @create: 2020-03-19 22:46
 **/
@HandlerType(HandlerTypeEnum.HANDLER_C)
public class Handler_C extends AbstractHandler{

    @Override
    protected void handler(BaseReqDto baseReqDto) {

    }
}
