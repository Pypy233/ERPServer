package service.dataservice;

import objects.ResultMessage;
import po.MemberPO;
import po.PresentListPO;
import po.UserPO;
import vo.MemberVO;
import vo.PresentListVO;

import java.util.ArrayList;

public interface PresentListDataService {
    /**
     * 增加赠送单
     * @param po
     * @return
     */
    public ResultMessage add(PresentListPO po);

    /**
     * 删除赠送单
     * @param po
     * @return
     */
    public ResultMessage delete(PresentListPO po);

    /**
     * 更新赠送单
     * @param po
     * @return
     */
    public ResultMessage update(PresentListPO po);

    /**
     * 查找得到赠送单
     * @param startTime
     * @param endTime
     * @param userName
     * @param memberName
     * @return
     */
    public ArrayList<PresentListPO> getPresentList(String startTime, String endTime, String userName, String memberName);

    /**
     * 生成红冲
     * @param po
     * @return
     */
    public PresentListPO addRed(PresentListPO po);
}
