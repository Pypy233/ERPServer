package service.dataservice;

import objects.ResultMessage;
import po.GoodsStockReturnPO;

public interface GoodsStockReturnDataService {
    /**
     *增加库存退货商品
     * @param po
     * @return
     */
    public ResultMessage add(GoodsStockReturnPO po);


    /**
     *删除库存退货商品
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsStockReturnPO po);


    /**
     *更新库存退货商品
     * @param po
     * @return
     */
    public ResultMessage update(GoodsStockReturnPO po);
}
