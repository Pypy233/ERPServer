package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.AdminPO;
import service.VOChangeToPO;
import service.blservice.AdminBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.AdminVO;
import vo.UserVO;

import java.util.ArrayList;

public class AdminBLServiceImpl implements AdminBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    POtoVO pOtoVO = new POtoVO();
    VOChangeToPO voChangeToPO = new VOChangeToPO();

    @Override
    public ResultMessage addAdmin(AdminVO vo) {
        AdminPO po = voChangeToPO.adminvo_to_adminpo(vo);
        ResultMessage msg = dataFactory.getAdminDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteAdmin(AdminVO vo) {
        return null;
    }

    @Override
    public ResultMessage updateAdmin(AdminVO vo) {
        return null;
    }

    @Override
    public ArrayList<UserVO> getAllUsers() {
        return null;
    }

    @Override
    public ArrayList<UserVO> findByType(String type) {
        return null;
    }

    @Override
    public ResultMessage addAdvancedUser(UserVO vo) {
        return null;
    }
}
