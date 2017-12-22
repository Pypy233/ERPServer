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
}
