package service.blservice;

import objects.ResultMessage;
import vo.LackListVO;
import vo.UserVO;

import java.util.ArrayList;

public interface LackListBLService {

    /**
     * 增加报损单
     * @param vo
     * @return
     */
    public ResultMessage addLackList(LackListVO vo);

    /**
     * 删除报损单
     * @param vo
     * @return
     */
    public ResultMessage deleteLackList(LackListVO vo);

    /**
     * 更新报损单
     * @param vo
     * @return
     */
    public ResultMessage update(LackListVO vo);

    /**
     * 查找报损单
     * @param startTime
     * @param endTime
     * @param userName
     * @return
     */
    public ArrayList<LackListVO> getLackList(String startTime, String endTime,  String userName);

    /**
     * 增加红冲
     * @param vo
     * @return
     */
    public LackListVO addLackListRed(LackListVO vo);
}
