package service.blservice;

import objects.ResultMessage;
import vo.GoodsStockVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by py on 2017/10/20.
 */
public interface StockBLService {

   /**
    * 增加库存单
    * @param vo
    * @return
    * @throws RemoteException
    */
   public ResultMessage add(StockVO vo) throws RemoteException;

   /**
    * 增加库存单，重载
    * @param provider
    * @param remark
    * @param set
    * @return
    * @throws RemoteException
    */
   public ResultMessage add(String provider, String remark, Set<GoodsStockVO> set) throws RemoteException;

   /**
    * 删除库存单
    * @param vo
    * @return
    * @throws RemoteException
    */
   public ResultMessage delete(StockVO vo) throws RemoteException;

   /**
    * 更新库存单
    * @param vo
    * @return
    * @throws RemoteException
    */
   public ResultMessage update(StockVO vo) throws RemoteException;

   /**
    * 得到所有提交的单据
    * @return
    */
   public ArrayList<StockVO> getProcessList() throws RemoteException;


   /**
    * 通过审批
    * @param vo
    * @throws RemoteException
    */
   public void passCheck(StockVO vo) throws RemoteException;

   /**
    * 没通过审批
    * @param vo
    * @throws RemoteException
    */
   public void failCheck(StockVO vo) throws  RemoteException;


}
