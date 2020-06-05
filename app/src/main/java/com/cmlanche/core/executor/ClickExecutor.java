package com.cmlanche.core.executor;

import com.cmlanche.core.executor.data.SwipScreenData;
import com.cmlanche.core.utils.ActionUtils;

public class ClickExecutor extends StepExecutor<SwipScreenData> {

    public ClickExecutor(SwipScreenData data) {
        super(data);
    }

    @Override
    public boolean execute() {
        int fromX = getData().getBusData().getStart().x;
        int fromY = getData().getBusData().getStart().y;
        return ActionUtils.click(fromX,fromY);
    }

}
