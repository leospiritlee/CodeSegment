package com.leospiritlee.strategy.handler;

import com.leospiritlee.strategy.dto.BaseReqDto;

/**
 * @Project: CodeSegment
 * @ClassName AbstractHandler
 * @description: handler 抽象类
 * @author: leospiritlee
 * @create: 2020-03-19 22:46
 **/
public abstract class AbstractHandler {

    protected abstract void handler(BaseReqDto baseReqDto);

}
