package service.dataservice;

import objects.ResultMessage;
import po.UserPO;

public interface UserDataService {

    /**
     * 增加用户
     * @param po
     * @return
     */
    public ResultMessage add(UserPO po);

    /**
     * 删除用户
     * @param po
     * @return
     */
    public ResultMessage delete(UserPO po);

    /**
     * 修改用户信息
     * @param po
     * @return
     */
    public ResultMessage update(UserPO po);

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    public UserPO find(String name);
}
