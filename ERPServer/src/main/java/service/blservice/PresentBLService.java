package service.blservice;

import objects.ResultMessage;
import po.PresentPO;
import vo.PresentVO;

public interface PresentBLService {
    /**
     * 增加赠送商品
     * @param vo
     * @return
     */s
    public ResultMessage addPresent(PresentVO vo);

    /**
     * 删除赠送商品
     * @param vo
     * @return
     */
    public ResultMessage deletePresent(PresentVO vo);

    /**
     * 更新赠送商品
     * @param vo
     * @return
     */
    public ResultMessage updatePresent(PresentVO vo);
}
