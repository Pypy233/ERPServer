package service.dataservice;

import objects.ResultMessage;
import po.AdminPO;
import po.UserPO;
import java.util.ArrayList;

public interface AdminDataService {


    /**
     * 增加神奇的管理员
     * @param po
     * @return
     */
    public ResultMessage add(AdminPO po);


    /**
     * 增加神奇的管理员
     * @param po
     * @return
     */
    public ResultMessage delete(AdminPO po);

    /**
     * 增加神奇的管理员
     * @param po
     * @return
     */
    public ResultMessage update(AdminPO po);

    /**
     * 神奇的管理员得到所有用户信息
     * @return
     */
    public ArrayList<UserPO> getUsers();

    /**
     * 按类别查找用户
     * @param type
     * @return
     */
    public ArrayList<UserPO> find(String type);

    /**
     * 增加高权限用户
     * @return
     */
    public ResultMessage addAdvancedUser(UserPO po);
}
