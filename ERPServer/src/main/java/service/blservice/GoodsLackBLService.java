package service.blservice;
/**
 * 报损商品的bl
 */

import objects.ResultMessage;
import vo.GoodsLackVO;

public interface GoodsLackBLService {
    /**
     * 赠送报损商品
     * @param vo
     * @return
     */
    public ResultMessage addGoodsLack(GoodsLackVO  vo);

    /**
     * 减少报损商品
     * @param vo
     * @return
     */
    public ResultMessage deleteGoodsLack(GoodsLackVO vo);

    /**
     * 更新报损商品
     * @param vo
     * @return
     */
    public ResultMessage update(GoodsLackVO vo);
}
