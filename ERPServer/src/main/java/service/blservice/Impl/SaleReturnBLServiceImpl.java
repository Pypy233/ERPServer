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
    public ResultMessage add(String retailer, String salesman, String operator,
                             String remark, Set<GoodsSaleReturnVO> set) throws RemoteException {
        SaleReturnVO vo = addHelper.getSaleReturnHelp(retailer, salesman, operator, remark, set);
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(SaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(SaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SaleReturnPO po = voChangeToPO.saleReturnvo_to_saleReturnpo(vo);
        dataFactory.getSaleReturnDataService().update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SaleReturnVO> getProcessList() throws RemoteException {
        ArrayList<SaleReturnPO> poList = dataFactory.getSaleReturnDataService().getProcessList();
        ArrayList<SaleReturnVO> list = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            list.add(pOtoVO.saleReturnPO_to_saleReturnVO(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passCheck(SaleReturnVO vo) throws RemoteException {
        dataFactory.getSaleReturnDataService().passCheck(voChangeToPO.saleReturnvo_to_saleReturnpo(vo));
    }

    @Override
    public void failCheck(SaleReturnVO vo) throws RemoteException {
        vo.setState("Fail");
        dataFactory.getSaleReturnDataService().update(voChangeToPO.saleReturnvo_to_saleReturnpo(vo));
    }
}
