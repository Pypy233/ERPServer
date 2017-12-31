package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.LogPO;
import service.dataservice.LogDataService;

import java.util.ArrayList;

public class LogDataServiceImpl implements LogDataService {
    @Override
    public ResultMessage add(LogPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(LogPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(LogPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<LogPO> findByName(String name) {
        String operation = "from Log where name = '" + name + "'";
        ArrayList<LogPO> list = (ArrayList<LogPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public ArrayList<LogPO> findByDate(String date) {
        String operation = "from Log where date = '" + date + "'";
        ArrayList<LogPO> list = (ArrayList<LogPO>) HQLTools.find(operation);
        return list;
    }

    @Override
    public ArrayList<LogPO> findByOperation(String operationName) {
        String operation = "from Log where operation = '" + operationName + "'";
        ArrayList<LogPO> list = (ArrayList<LogPO>) HQLTools.find(operation);
        return list;
    }
}
