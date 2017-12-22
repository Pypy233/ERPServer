package service.dataservice;

import objects.ResultMessage;
import po.SalePO;

import java.util.ArrayList;

/**
 * Created by py on 2017/10/20.
 */
public interface SaleDataService {
    /**
     * 增加销售商品
     * @param po
     * @return
     */
   public ResultMessage add(SalePO po);

    /**
     * 减少销售商品
     * @param po
     * @return
     */
   public ResultMessage delete(SalePO po);

    /**
     * 更新销售商品
     * @param po
     * @return
     */
   public ResultMessage update(SalePO po);


    /**
     * 得到所有待审批单据
     * @return
     */
    public ArrayList<SalePO> getProcessList();

    /**
     * 进行单据审批同意后的处理
     * @param po
     */
    public void passCheck(SalePO po);

}
