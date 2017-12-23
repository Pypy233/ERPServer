package service.blservice;

import objects.ResultMessage;
import vo.OverflowListVO;
import vo.UserVO;

import java.util.ArrayList;

public interface OverflowListBLService {
    /**
     * 增加报溢单
     * @param vo
     * @return
     */
    public ResultMessage addOverflowList(OverflowListVO vo);

    /**
     * 删除报溢单
     * @param vo
     * @return
     */
    public ResultMessage deleteOverlowList(OverflowListVO vo);

    /**
     * 更新报溢单
     * @param vo
     * @return
     */
    public ResultMessage updateOverflowList(OverflowListVO vo);

    /**
     * 查找得到报溢单
     * @param startTime
     * @param endTime
     * @param user
     * @return
     */
    public ArrayList<OverflowListVO> getOverflowList(String startTime, String endTime,  String userName);

    /**
     * 生成红冲
     * @param vo
     * @return
     */
    public OverflowListVO addOverflowListRed(OverflowListVO vo);
}
