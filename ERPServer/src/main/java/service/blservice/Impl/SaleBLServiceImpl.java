package service.blservice.Impl;


import objects.AddHelper;
import objects.POtoVO;
import objects.ResultMessage;
import po.SalePO;
import service.VOChangeToPO;
import service.blservice.SaleBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsSaleVO;
import vo.SaleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

public class SaleBLServiceImpl implements SaleBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();
    AddHelper addHelper = new AddHelper();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage add(String retailer, String salesman, String operator, double discount,
                             double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException {
        SaleVO vo = addHelper.getSaleAddHelp(retailer, salesman, operator, discount, voucher, remark, set);
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(SaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(SaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SaleVO> getProcessList() throws RemoteException {
        ArrayList<SalePO> poList = dataFactory.getSaleDataService().getProcessList();
        ArrayList<SaleVO> list = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++) {
            list.add(pOtoVO.salepo_to_salevo(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passCheck(SaleVO vo) throws RemoteException {
        dataFactory.getSaleDataService().passCheck(voChangeToPO.salevo_to_salepo(vo));
    }

    @Override
    public void failCheck(SaleVO vo) throws RemoteException {
        vo.setState("Fail");
        dataFactory.getSaleDataService().update(voChangeToPO.salevo_to_salepo(vo));

    }
}
