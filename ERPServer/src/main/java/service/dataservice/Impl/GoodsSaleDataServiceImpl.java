package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsSalePO;
import service.dataservice.GoodsSaleDataService;

public class GoodsSaleDataServiceImpl implements GoodsSaleDataService {

    @Override
    public ResultMessage add(GoodsSalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsSalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsSalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
