package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsStockReturnPO;
import service.dataservice.GoodsStockReturnDataService;

public class GoodsStockReturnDataServiceImpl implements GoodsStockReturnDataService {

    @Override
    public ResultMessage add(GoodsStockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsStockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsStockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
