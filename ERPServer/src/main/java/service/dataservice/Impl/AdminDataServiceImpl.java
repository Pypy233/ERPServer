package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.AdminPO;
import po.UserPO;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.AdminDataService;

import java.util.ArrayList;

public class AdminDataServiceImpl implements AdminDataService {
    DataFactory dataFactory = new DataFactoryImpl();
    @Override
    public ResultMessage add(AdminPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(AdminPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(AdminPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<UserPO> getUsers() {
        ArrayList<UserPO> list = (ArrayList<UserPO>)HQLTools.find("from User");
        return list;
    }

    @Override
    public ArrayList<UserPO> find(String type) {
        ArrayList<UserPO> list = (ArrayList<UserPO>)HQLTools.find("from User where type ='" + type + "'");
        return list;
    }

    @Override
    public ResultMessage addAdvancedUser(UserPO po) {
        ResultMessage msg = dataFactory.getUserDataService().add(po);
        return msg;
    }
}
