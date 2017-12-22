package service.dataservice;

import objects.ResultMessage;
import po.MemberPO;

import java.util.ArrayList;

/**
 * Created by py on 2017/10/19.
 */
public interface MemberDataService {
    /**
     * 增加客户
     * @param po
     * @return
     */
    public ResultMessage add(MemberPO po);

    /**
     * 删除客户
     * @param po
     * @return
     */
    public ResultMessage delete(MemberPO po);

    /**
     * 修改客户信息
     * @param po
     * @return
     */
    public ResultMessage update(MemberPO po);

    /**
     * 寻找客户信息
     * @param number
     * @param name
     * @param memberClass
     * @return
     */
    public ArrayList<MemberPO> find(String number, String name, String memberClass);
}
