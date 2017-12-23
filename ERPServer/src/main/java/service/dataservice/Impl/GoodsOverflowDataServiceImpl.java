package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsOverflowPO;
import service.dataservice.GoodsOverflowDataService;

public class GoodsOverflowDataServiceImpl implements GoodsOverflowDataService {


    @Override
    public ResultMessage add(GoodsOverflowPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsOverflowPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsOverflowPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
