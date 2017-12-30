package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.AdminPO;
import po.UserPO;
import service.dataservice.AdminDataService;

import java.util.ArrayList;

public class AdminDataServiceImpl implements AdminDataService {
    @Override
    public ResultMessage add(AdminPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(AdminPO po) {
        return null;
    }

    @Override
    public ResultMessage update(AdminPO po) {
        return null;
    }

    @Override
    public ArrayList<UserPO> getUsers() {
        return null;
    }

    @Override
    public ArrayList<UserPO> find(String type) {
        return null;
    }

    @Override
    public ResultMessage addAdvancedUser(UserPO po) {
        return null;
    }
}
