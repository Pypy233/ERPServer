package service.blservice;

import objects.ResultMessage;
import vo.GoodsOverflowVO;

public interface GoodsOverflowBLService {

    /**
     * 增加报溢商品
     * @param vo
     * @return
     */
    public ResultMessage addGoodsOverflow(GoodsOverflowVO vo);

    /**
     * 删除报溢商品
     * @param vo
     * @return
     */
    public ResultMessage deleteGoodsOverflow(GoodsOverflowVO vo);

    /**
     * 更新报溢商品
     * @param vo
     * @return
     */
    public ResultMessage update(GoodsOverflowVO vo);
}
