package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.AdminPO;
import po.UserPO;
import service.VOChangeToPO;
import service.blservice.AdminBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.AdminVO;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AdminBLServiceImpl implements AdminBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    POtoVO pOtoVO = new POtoVO();
    VOChangeToPO voChangeToPO = new VOChangeToPO();

    @Override
    public ResultMessage addAdmin(AdminVO vo) throws RemoteException{
        AdminPO po = voChangeToPO.adminvo_to_adminpo(vo);
        ResultMessage msg = dataFactory.getAdminDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteAdmin(AdminVO vo) throws RemoteException {
        AdminPO po = voChangeToPO.adminvo_to_adminpo(vo);
        ResultMessage msg = dataFactory.getAdminDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage updateAdmin(AdminVO vo) throws RemoteException {
        AdminPO po = voChangeToPO.adminvo_to_adminpo(vo);
        ResultMessage msg = dataFactory.getAdminDataService().update(po);
        return msg;
    }

    @Override
    public ArrayList<UserVO> getAllUsers() throws RemoteException {
        ArrayList<UserVO> voList = new ArrayList<>();
        ArrayList<UserPO> poList = dataFactory.getAdminDataService().getUsers();

        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.userpo_to_uservo(poList.get(i)));
        }
        return voList;
    }

    @Override
    public ArrayList<UserVO> findByType(String type) throws RemoteException {
        ArrayList<UserVO> voList = new ArrayList<>();
        ArrayList<UserPO> poList = dataFactory.getAdminDataService().find(type);

        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.userpo_to_uservo(poList.get(i)));
        }
        return voList;
    }

    @Override
    public ResultMessage addAdvancedUser(UserVO vo) throws RemoteException {
        UserPO po = voChangeToPO.uservo_to_userpo(vo);
        ResultMessage msg = dataFactory.getAdminDataService().addAdvancedUser(po);
        return msg;
    }

    @Override
    public ResultMessage deleteUser(UserVO vo) throws RemoteException {
        UserPO po = voChangeToPO.uservo_to_userpo(vo);
        ResultMessage msg = dataFactory.getUserDataService().delete(po);
        return msg;
    }
}
