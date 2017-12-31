package service.dataservice;

import objects.ResultMessage;
import po.SaleReturnPO;

import java.util.ArrayList;

/**
 * 销售退货的数据服务类
 */
public interface SaleReturnDataService {
    /**
     * 增加销售退货商品
     * @param po
     * @return
     */
    public ResultMessage add(SaleReturnPO po);

    /**
     * 删除销售退货商品
     * @param po
     * @return
     */
    public ResultMessage delete(SaleReturnPO po);

    /**
     * 更新销售货商品
     * @param po
     * @return
     */
    public ResultMessage update(SaleReturnPO po);

    /**
     * 得到所有待审批单据
     * @return
     */
    public ArrayList<SaleReturnPO> getProcessList();

    /**
     * 进行单据审批同意后的处理
     * @param po
     */
    public void passCheck(SaleReturnPO po);

    /**
     * 单据未通过审批
     * @param po
     */
    public void failCheck(SaleReturnPO po);

    /**
     * 查找得到销售退货单
     * @param startTime
     * @param endTime
     * @param userName
     * @param memberName
     * @return
     */
    public ArrayList<SaleReturnPO> getSaleReturn(String startTime, String endTime, String userName, String memberName);

    /**
     * 得到维通过销售退货单
     * @return
     */
    public ArrayList<SaleReturnPO> getFail();


    /**
     * 生成红冲
     * @param po
     * @return
     */
    public SaleReturnPO addRed(SaleReturnPO po);
}
