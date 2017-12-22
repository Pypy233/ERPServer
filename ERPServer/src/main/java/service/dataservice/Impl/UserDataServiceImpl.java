package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.UserPO;
import service.dataservice.UserDataService;

import java.util.ArrayList;

public class UserDataServiceImpl implements UserDataService {
    String opeartion = "from User";
    ArrayList<UserPO> resultList = (ArrayList<UserPO>) HQLTools.find(opeartion);

    @Override
    public ResultMessage add(UserPO po) {
       if(po == null || contains(po.getName()))
        return ResultMessage.Fail;

        HQLTools.add(po);
        resultList.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(UserPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        resultList.remove(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(UserPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        resultList = (ArrayList<UserPO>) HQLTools.find(opeartion);
        return ResultMessage.Success;
    }

    @Override
    public UserPO find(String name) {
        String operation = "from User where name = '" + name + "'";
        ArrayList<UserPO> list = (ArrayList<UserPO>)HQLTools.find(operation);
        return list.get(0);
    }

    public boolean contains(String name){
        for(int i = 0; i < resultList.size(); i++){
            if(resultList.get(i).getName().equals(name))
                return true;
        }
        return false;
    }
}
