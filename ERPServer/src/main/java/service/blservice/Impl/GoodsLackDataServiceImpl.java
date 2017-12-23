package service.blservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsLackPO;
import service.dataservice.GoodsLackDataService;

public class GoodsLackDataServiceImpl implements GoodsLackDataService {
    @Override
    public ResultMessage add(GoodsLackPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsLackPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsLackPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
