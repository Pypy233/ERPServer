package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsSaleReturnPO;
import service.dataservice.GoodsSaleReturnDataService;

public class GoodsSaleReturnDataServiceImpl implements GoodsSaleReturnDataService{

    @Override
    public ResultMessage add(GoodsSaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsSaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;

    }

    @Override
    public ResultMessage update(GoodsSaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
