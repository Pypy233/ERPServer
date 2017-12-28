package service.blservice.Impl;

import objects.AddHelper;
import objects.POtoVO;
import objects.ResultMessage;
import po.SaleReturnPO;
import service.VOChangeToPO;
import service.blservice.SaleReturnBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsSaleReturnVO;
import vo.SaleReturnVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

public class SaleReturnBLServiceImpl implements SaleReturnBLService {

    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();
    AddHelper addHelper = new AddHelper();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addSaleReturn(String retailer, String salesman, String operator,
                             String remark, Set<GoodsSaleReturnVO> set) throws RemoteException {
        SaleReturnVO vo = addHelper.getSaleReturnHelp(retailer, salesman, operator, remark, set);
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteSaleReturn(SaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateSaleReturn(SaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnProcessList() throws RemoteException {
        ArrayList<SaleReturnPO> poList = dataFactory.getSaleReturnDataService().getProcessList();
        ArrayList<SaleReturnVO> list = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            list.add(pOtoVO.saleReturnPO_to_saleReturnVO(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
        dataFactory.getSaleReturnDataService().passCheck(voChangeToPO.saleReturnvo_to_saleReturnpo(vo));
    }

    @Override
    public void failSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
        vo.setState("fail");
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().failCheck(po);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturn(String startTime, String endTime, String userName, String memberName)
    throws RemoteException{
        ArrayList<SaleReturnPO> list = dataFactory.getSaleReturnDataService().getSaleReturn(startTime, endTime, userName, memberName);
        ArrayList<SaleReturnVO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            resultList.add(pOtoVO.saleReturnPO_to_saleReturnVO(list.get(i)));
        }
        return resultList;
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnFail() throws RemoteException{
        ArrayList<SaleReturnPO> list = dataFactory.getSaleReturnDataService().getFail();
        ArrayList<SaleReturnVO> voList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            voList.add(pOtoVO.saleReturnPO_to_saleReturnVO(list.get(i)));
        }
        return voList;
    }

    @Override
    public SaleReturnVO addSaleReturnRed(SaleReturnVO vo) throws RemoteException {
        SaleReturnPO redPo = dataFactory.getSaleReturnDataService().
                addRed(voChangeToPO.saleReturnvo_to_saleReturnpo(vo));

        SaleReturnVO vo1 = pOtoVO.saleReturnPO_to_saleReturnVO(redPo);

        return vo1;
    }


}
