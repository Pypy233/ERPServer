package service.dataservice;

import objects.ResultMessage;
import po.GoodsStockPO;

/**
 * 库存商品数据类
 */
public interface GoodsStockDataService {
    /**
     *增加库存商品
     * @param po
     * @return
     */
    public ResultMessage add(GoodsStockPO po);


    /**
     *删除库存商品
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsStockPO po);


    /**
     *更新库存商品
     * @param po
     * @return
     */
    public ResultMessage update(GoodsStockPO po);
}
