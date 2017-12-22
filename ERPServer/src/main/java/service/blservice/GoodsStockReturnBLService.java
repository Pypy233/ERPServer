package service.blservice;

import objects.ResultMessage;
import vo.GoodsStockReturnVO;
import vo.GoodsVO;

import java.rmi.RemoteException;

public interface GoodsStockReturnBLService {
    /**
     * 增加进货退货商品，默认更改价格
     * @param vo
     * @param stockReturnNumber
     * @param price
     * @param remark
     * @return
     */
    public ResultMessage add(GoodsVO vo, int stockReturnNumber, double price, String remark) throws RemoteException;


    /**
     * 删除进货退货商品
     * @param vo
     * @return
     */
    public ResultMessage delete(GoodsStockReturnVO vo) throws RemoteException;

    /**
     * 更新进货退货商品
     * @param vo
     * @return
     * @throws RemoteException
     */
    public ResultMessage update(GoodsStockReturnVO vo) throws RemoteException;

}
