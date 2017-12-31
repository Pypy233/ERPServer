package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.PresentPO;
import service.dataservice.PresentDataService;

public class PresentDataServiceImpl implements PresentDataService {


    @Override
    public ResultMessage add(PresentPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(PresentPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(PresentPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }
}
