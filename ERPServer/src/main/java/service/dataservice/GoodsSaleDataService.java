package service.dataservice;

import objects.ResultMessage;
import po.GoodsSalePO;

/**
 * 销售商品数据的类
 */
public interface GoodsSaleDataService {
    /**
     * 增加销售商品
     * @param po
     * @return
     */
    public ResultMessage add(GoodsSalePO po);

    /**
     * 删除销售商品
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsSalePO po);

    /**
     * 更新销售商品
     * @param po
     * @return
     */
    public ResultMessage update(GoodsSalePO po);


}
