package service.dataservice;

import objects.ResultMessage;
import po.StockReturnPO;

import java.util.ArrayList;

public interface StockReturnDataService {
    /**
     * 增加库存退货商品
     * @param po
     * @return
     */
    public ResultMessage add(StockReturnPO po);

    /**
     * 删除库存退货商品
     * @param po
     * @return
     */
    public ResultMessage delete(StockReturnPO po);

    /**
     * 更新库存退货商品
     * @param po
     * @return
     */
    public ResultMessage update(StockReturnPO po);

    /**
     * 得到所有待审批单据
     * @return
     */
    public ArrayList<StockReturnPO> getProcessList();

    /**
     * 进行单据审批同意后的处理
     * @param po
     */
    public void passCheck(StockReturnPO po);
}
