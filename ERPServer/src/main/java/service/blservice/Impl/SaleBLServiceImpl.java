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
    public ResultMessage addSale(String retailer, String salesman, String operator, double discount,
                             double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException {
        SaleVO vo = addHelper.getSaleAddHelp(retailer, salesman, operator, discount, voucher, remark, set);
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteSale(SaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateSale(SaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        SalePO po = voChangeToPO.salevo_to_salepo(vo);
        dataFactory.getSaleDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SaleVO> getSaleProcessList() throws RemoteException {
        ArrayList<SalePO> poList = dataFactory.getSaleDataService().getProcessList();
        ArrayList<SaleVO> list = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++) {
            list.add(pOtoVO.salepo_to_salevo(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passSaleCheck(SaleVO vo) throws RemoteException {
        dataFactory.getSaleDataService().passCheck(voChangeToPO.salevo_to_salepo(vo));
    }

    @Override
    public void failSaleCheck(SaleVO vo) throws RemoteException {
        vo.setState("Fail");
        dataFactory.getSaleDataService().update(voChangeToPO.salevo_to_salepo(vo));

    }

    @Override
    public SaleVO addSaleRed (SaleVO vo) throws RemoteException{
        SalePO po = dataFactory.getSaleDataService().addRed(voChangeToPO.salevo_to_salepo(vo));
        SaleVO vo1 = pOtoVO.salepo_to_salevo(po);
        return vo1;
    }

    @Override
    public ArrayList<SaleVO> getSale(String startTime, String endTime, String userName, String memberName)
    throws RemoteException{
        ArrayList<SalePO> list = dataFactory.getSaleDataService().getSale(startTime, endTime, userName, memberName);
        ArrayList<SaleVO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            resultList.add(pOtoVO.salepo_to_salevo(list.get(i)));
        }
        return resultList;
    }

    @Override
    public ArrayList<SaleVO> getSalFail() throws RemoteException{
        ArrayList<SalePO> list = dataFactory.getSaleDataService().getFail();
        ArrayList<SaleVO> voList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            voList.add(pOtoVO.salepo_to_salevo(list.get(i)));
        }
        return voList;
    }
}
