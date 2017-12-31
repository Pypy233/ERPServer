package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.UserPO;
import service.VOChangeToPO;
import service.blservice.UserBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.UserVO;

import java.rmi.RemoteException;

public class UserBLServiceImpl implements UserBLService {
DataFactory dataFactory = new DataFactoryImpl();
VOChangeToPO voChangeToPO = new VOChangeToPO();
POtoVO pOtoVO = new POtoVO();
    @Override
    public ResultMessage register(UserVO vo) throws RemoteException {
        ResultMessage msg = dataFactory.getUserDataService().add(voChangeToPO.uservo_to_userpo(vo));
        return msg;
    }

    @Override
    public ResultMessage check(String name, String password) throws RemoteException{
        UserPO po = dataFactory.getUserDataService().find(name);
        if(po.getPassword().equals(password))
            return ResultMessage.Success;
        return ResultMessage.Fail;
    }

    @Override
    public ResultMessage updatePassword(String name, String password, String type) throws RemoteException{
        UserVO vo = new UserVO();
        vo.setName(name);
        vo.setPassword(password);
        vo.setType(type);
        vo.setLogin(false);
        dataFactory.getUserDataService().update(voChangeToPO.uservo_to_userpo(vo));
        return ResultMessage.Success;
    }

    @Override
    public UserVO getUserVO(String name) throws RemoteException{
        UserPO po = dataFactory.getUserDataService().find(name);
        UserVO vo = pOtoVO.userpo_to_uservo(po);
        return vo;
    }
}
