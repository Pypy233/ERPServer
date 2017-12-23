package service.dataservice;

import objects.ResultMessage;
import po.StockReturnPO;
import service.blservice.StockReturnBLService;

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

    /**
     * 单据审批未通过
     * @param po
     */
    public void failCheck(StockReturnPO po);

    /**
     * 查找得到进货退货单
     * @param startTime
     * @param endTime
     * @param userName
     * @param memberName
     * @return
     */
    public ArrayList<StockReturnPO> getStockReturn(String startTime, String endTime, String userName, String memberName);

    /**
     * 得到未通过进货退货单
     * @return
     */
    public ArrayList<StockReturnPO> getFail();

    /**
     * 生成红冲
     * @param po
     * @return
     */
    public StockReturnPO addRed(StockReturnPO po);
}
