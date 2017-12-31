package service.dataservice;

import objects.ResultMessage;
import po.GoodsSalePO;
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

    /**
     * 审批失败
     * @param po
     */
    public void failCheck(SalePO po);

    /**
     * 生成红冲
     * @param po
     * @return
     */
    public SalePO addRed(SalePO po);

    /**
     * 查看销售明细
     * @param startTime
     * @param endTime
     * @param goodsName
     * @param userName
     * @param memberName
     * @return
     */
    public ArrayList<GoodsSalePO> checkSale(String startTime, String endTime, String goodsName, String userName,
                                            String memberName);


    /**
     * 查找得到销售单
     * @param startTime
     * @param endTime
     * @param userName
     * @param memberName
     * @return
     */
    public ArrayList<SalePO> getSale(String startTime, String endTime, String userName, String memberName);

    /**
     * 得到维通过销售单
     * @return
     */
    public ArrayList<SalePO> getFail();



}
