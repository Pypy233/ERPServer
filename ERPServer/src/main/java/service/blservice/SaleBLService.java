package service.blservice;

import objects.ResultMessage;
import vo.GoodsSaleVO;
import vo.SaleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by py on 2017/10/20.
 *
 */
public interface SaleBLService {
    /**
     * 增加销售单
     * @param retailer
     * @param salesman
     * @param operator
     * @param discount
     * @param voucher
     * @param remark
     * @param set
     * @return
     * @throws RemoteException
     */
    public ResultMessage addSale(String retailer, String salesman, String operator, double discount,
                             double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException;

    /**
     * 删除销售单
     * @return
     * @throws RemoteException
     */
    public ResultMessage deleteSale(SaleVO vo) throws RemoteException;

    /**
     * 更新销售单
     * @return
     * @throws RemoteException
     */
    public ResultMessage updateSale(SaleVO vo) throws RemoteException;

    /**
     * 得到所有提交的单据
     * @return
     */
    public ArrayList<SaleVO> getSaleProcessList() throws RemoteException;


    /**
     * 通过审批
     * @param vo
     * @throws RemoteException
     */
    public void passSaleCheck(SaleVO vo) throws RemoteException;

    /**
     * 没通过审批
     * @param vo
     * @throws RemoteException
     */
    public void failSaleCheck(SaleVO vo) throws  RemoteException;





}
