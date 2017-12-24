package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsStockPO;
import service.dataservice.GoodsStockDataService;

public class GoodsStockDataServiceImpl implements GoodsStockDataService {
    @Override
    public ResultMessage add(GoodsStockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsStockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsStockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
