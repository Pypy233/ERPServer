package service.blservice;

import objects.ResultMessage;
import vo.AdminVO;
import vo.UserVO;

import java.util.ArrayList;

public interface AdminBLService {

    /**
     * 增加神奇的管理员
     * @param vo
     * @return
     */
    public ResultMessage addAdmin(AdminVO vo);

    /**
     * 增加神奇的管理员
     * @param vo
     * @return
     */
    public ResultMessage deleteAdmin(AdminVO vo);


    /***
     * 增加神奇的管理员
     * @param vo
     * @return
     */
    public ResultMessage updateAdmin(AdminVO vo);

    /**
     * 神奇的管理员得到所有用户信息
     * @return
     */
    public ArrayList<UserVO> getAllUsers();

    /**
     * 按类别查找用户
     * @param type
     * @return
     */
    public ArrayList<UserVO> findByType(String type);

    /**
     * 增加高权限用户
     * @param vo
     * @return
     */
    public ResultMessage addAdvancedUser(UserVO vo);

    /**
     * 删除用户
     * @param vo
     * @return
     */
    public ResultMessage deleteUser(UserVO vo);
}
