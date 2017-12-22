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
    public ResultMessage add(String retailer, String salesman, String operator, double discount,
                             double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException;

    /**
     * 删除销售单
     * @return
     * @throws RemoteException
     */
    public ResultMessage delete(SaleVO vo) throws RemoteException;

    /**
     * 更新销售单
     * @return
     * @throws RemoteException
     */
    public ResultMessage update(SaleVO vo) throws RemoteException;

    /**
     * 得到所有提交的单据
     * @return
     */
    public ArrayList<SaleVO> getProcessList() throws RemoteException;


    /**
     * 通过审批
     * @param vo
     * @throws RemoteException
     */
    public void passCheck(SaleVO vo) throws RemoteException;

    /**
     * 没通过审批
     * @param vo
     * @throws RemoteException
     */
    public void failCheck(SaleVO vo) throws  RemoteException;





}
