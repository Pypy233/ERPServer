package service.blservice.Impl;

import objects.AddHelper;
import objects.HQLTools;
import objects.POtoVO;
import objects.ResultMessage;
import po.StockPO;
import service.VOChangeToPO;
import service.blservice.StockBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsStockVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

public class StockBLServiceImpl implements StockBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();
    AddHelper addHelper = new AddHelper();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addStock(StockVO vo) throws RemoteException {
        if (vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage addStock(String provider, String remark, Set<GoodsStockVO> set) throws RemoteException {
        StockVO vo = addHelper.getStockAddHelp(provider, remark, set);
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteStock(StockVO vo) throws RemoteException {
        if (vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateStock(StockVO vo) throws RemoteException {
        if (vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<StockVO> getStockProcessList() throws RemoteException {
        ArrayList<StockPO> poList = dataFactory.getStockDataService().getProcessList();
        ArrayList<StockVO> list = new ArrayList<>();
        for (int i = 0; i < poList.size(); i++) {
            list.add(pOtoVO.stockpo_to_stockvo(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passStockCheck(StockVO vo) throws RemoteException {
        dataFactory.getStockDataService().passCheck(voChangeToPO.stockvo_to_stockpo(vo));
    }

    @Override
    public void failStockCheck(StockVO vo) throws RemoteException {
        vo.setState("fail");
        dataFactory.getStockDataService().update(voChangeToPO.stockvo_to_stockpo(vo));
    }

    @Override
    public ArrayList<StockVO> getStock(String startTime, String endTime, String userName, String memberName)
    throws RemoteException{
        ArrayList<StockPO> list = dataFactory.getStockDataService().getStock(startTime, endTime, userName, memberName);
        ArrayList<StockVO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            resultList.add(pOtoVO.stockpo_to_stockvo(list.get(i)));
        }
        return resultList;
    }

    @Override
    public ArrayList<StockVO> getStockFail() throws RemoteException{
        ArrayList<StockPO> list = dataFactory.getStockDataService().getFail();
        ArrayList<StockVO> voList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            voList.add(pOtoVO.stockpo_to_stockvo(list.get(i)));
        }
        return voList;
    }

    @Override
    public StockVO addStockRed(StockVO vo) {
        StockPO redPo = dataFactory.getStockDataService().addRed(voChangeToPO.stockvo_to_stockpo(vo));
        StockVO vo1 = pOtoVO.stockpo_to_stockvo(redPo);
        return vo1;
    }

}
