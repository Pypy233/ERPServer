package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsStockReturnPO;
import service.VOChangeToPO;
import service.blservice.GoodsStockReturnBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsStockReturnVO;
import vo.GoodsVO;

import java.rmi.RemoteException;

public class GoodsStockReturnBLServiceImpl implements GoodsStockReturnBLService {

    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();

    @Override
    public ResultMessage add(GoodsVO vo, int stockReturnNumber, double price, String remark) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockReturnVO goodsStockReturnVO = new GoodsStockReturnVO();
        goodsStockReturnVO.setVo(vo);
        goodsStockReturnVO.setStockReturnNumber(stockReturnNumber);
        goodsStockReturnVO.setTotalPrice(price * stockReturnNumber);
        goodsStockReturnVO.setRemark(remark);
        //初始化vo

        GoodsStockReturnPO po = voChangeToPO.goodsStockReturnvo_to_goodsStockReturnpo(goodsStockReturnVO);
        dataFactory.getGoodsStockReturnDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsStockReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockReturnPO po = voChangeToPO.goodsStockReturnvo_to_goodsStockReturnpo(vo);
        dataFactory.getGoodsStockReturnDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsStockReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockReturnPO po = voChangeToPO.goodsStockReturnvo_to_goodsStockReturnpo(vo);
        dataFactory.getGoodsStockReturnDataService().update(po);
        return ResultMessage.Success;
    }
}
