package service.dataservice;

import objects.ResultMessage;
import po.GoodsOverflowPO;

public interface GoodsOverflowDataService {

    /**
     * 增加商品分类
     * @param po
     * @return
     */
    public ResultMessage add(GoodsOverflowPO po);

    /**
     * 删除商品分类
     * @param po
     * @return
     */
    public ResultMessage delete(GoodsOverflowPO po);

    /**
     * 更新商品分类
     * @param po
     * @return
     */
    public ResultMessage update(GoodsOverflowPO po);
}
