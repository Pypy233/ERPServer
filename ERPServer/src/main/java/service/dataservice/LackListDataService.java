package service.dataservice;

import objects.ResultMessage;
import po.LackListPO;
import po.MemberPO;
import po.UserPO;
import vo.UserVO;

import java.util.ArrayList;

public interface LackListDataService {
    /**
     * 增加报损单
     * @param po
     * @return
     */
    public ResultMessage add(LackListPO po);


    /**
     * 减少报损单
     * @param po
     * @return
     */
    public ResultMessage delete(LackListPO po);

    /**
     * 更新报损单
     * @param po
     * @return
     */
    public ResultMessage update(LackListPO po);

    /**
     * 查找报损单
     * @param startTime
     * @param endTime
     * @param userName
     * @return
     */
    public ArrayList<LackListPO> getLackList(String startTime, String endTime, String userName);


    /**
     * 生成红冲
     * @param po
     * @return
     */
    public LackListPO addRed(LackListPO po);


}
