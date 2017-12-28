package service.dataservice;

/**
 * 报损商品的数据类
 */

import objects.ResultMessage;
import po.GoodsLackPO;
public interface GoodsLackDataService {
    /**
     * 增加报损商品
     * @param po
     * @return
     */
    public ResultMessage add(GoodsLackPO po);


    /**
     * 删除报损商品
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsLackPO po);

    /**
     * 更新报损商品
     * @param po
     * @return
     */
    public ResultMessage update(GoodsLackPO po);
}
