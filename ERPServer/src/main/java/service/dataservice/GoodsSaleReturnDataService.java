package service.dataservice;

import objects.ResultMessage;
import po.GoodsSaleReturnPO;

public interface GoodsSaleReturnDataService {
    /**
     *增加销售退货商品
     * @param po
     * @return
     */
    public ResultMessage add(GoodsSaleReturnPO po);


    /**
     *删除销售退货商品
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsSaleReturnPO po);


    /**
     *更新销售退货商品
     * @param po
     * @return
     */
    public ResultMessage update(GoodsSaleReturnPO po);
}
