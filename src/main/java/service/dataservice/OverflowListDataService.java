package service.dataservice;

import objects.ResultMessage;
import po.OverflowListPO;
import po.UserPO;
import vo.OverflowListVO;
import vo.UserVO;

import java.util.ArrayList;

public interface OverflowListDataService {
    /**
     * 增加报溢单
     * @param po
     * @return
     */
    public ResultMessage add(OverflowListPO po);


    /**
     * 删除报溢单
     * @param po
     * @return
     */
    public ResultMessage delete(OverflowListPO po);

    /**
     * 更新报溢单
     * @param po
     * @return
     */
    public ResultMessage update(OverflowListPO po);

    /**
     * 查找得到报溢单
     * @param startTime
     * @param endTime
     * @param userName
     * @return
     */
    public ArrayList<OverflowListPO> getOverflowList(String startTime, String endTime, String userName);

    /**
     * 生成红冲
     * @param po
     * @return
     */
    public OverflowListPO addRed(OverflowListPO po);
}
