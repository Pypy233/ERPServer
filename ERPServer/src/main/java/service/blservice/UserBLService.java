package service.blservice;

import objects.ResultMessage;
import vo.UserVO;

public interface UserBLService {
    /**
     * 登录
     * @param vo
     * @return
     */
    public ResultMessage register(UserVO vo);

    /**
     * 检查用户名密码
     * @param name
     * @param password
     * @return
     */
    public ResultMessage check(String name, String password);

    /**
     * 修改密码
     * @param name
     * @param password
     * @param type
     * @return
     */
    public ResultMessage updatePassword(String name, String password, String type);

    /**
     * 得到用户信息
     * @param name
     * @return
     */
    public UserVO getUserVO(String name);
}
