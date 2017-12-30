package service.blservice.Impl;

import objects.ResultMessage;
import service.blservice.AdminBLService;
import vo.AdminVO;
import vo.UserVO;

import java.util.ArrayList;

public class AdminBLServiceImpl implements AdminBLService {
    @Override
    public ResultMessage addAdmin(AdminVO vo) {
        return null;
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
