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
    public ResultMessage add(StockVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage add(String provider, String remark, Set<GoodsStockVO> set) throws RemoteException {
        StockVO vo = addHelper.getStockAddHelp(provider, remark, set);
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(StockVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(StockVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;
        StockPO po = voChangeToPO.stockvo_to_stockpo(vo);
        dataFactory.getStockDataService().update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<StockVO> getProcessList() throws RemoteException {
        ArrayList<StockPO> poList = dataFactory.getStockDataService().getProcessList();
        ArrayList<StockVO> list = new ArrayList<>();
        for(int  i = 0; i < poList.size(); i++){
            list.add(pOtoVO.stockpo_to_stockvo(poList.get(i)));
        }
        return list;
    }

    @Override
    public void passCheck(StockVO vo) throws RemoteException {
        dataFactory.getStockDataService().passCheck(voChangeToPO.stockvo_to_stockpo(vo));
    }

    @Override
    public void failCheck(StockVO vo) throws RemoteException {
        vo.setState("Fail");
        HQLTools.update(voChangeToPO.stockvo_to_stockpo(vo));
    }
}
