package service.blservice;

import objects.ResultMessage;
import vo.GoodsSaleReturnVO;
import vo.SaleReturnVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

public interface SaleReturnBLService {

    /**
     * 增加销售退货单
     * @param retailer
     * @param salesman
     * @param operator
     * @param remark
     * @param set
     * @return
     * @throws RemoteException
     */
    public ResultMessage add(String retailer, String salesman, String operator,
                             String remark, Set<GoodsSaleReturnVO> set) throws RemoteException;

    /**
     * 删除销售退货单
     * @param vo
     * @return
     * @throws RemoteException
     */
    public ResultMessage delete(SaleReturnVO vo) throws RemoteException;

    /**
     * 更新销售退货单
     * @param vo
     * @return
     * @throws RemoteException
     */
    public ResultMessage update(SaleReturnVO vo) throws RemoteException;

    /**
     * 得到所有提交的单据
     * @return
     */
    public ArrayList<SaleReturnVO> getProcessList() throws RemoteException;


    /**
     * 通过审批
     * @param vo
     * @throws RemoteException
     */
    public void passCheck(SaleReturnVO vo) throws RemoteException;

    /**
     * 没通过审批
     * @param vo
     * @throws RemoteException
     */
    public void failCheck(SaleReturnVO vo) throws  RemoteException;
}
