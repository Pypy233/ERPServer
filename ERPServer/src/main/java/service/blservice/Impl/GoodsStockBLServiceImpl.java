package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsStockPO;
import service.VOChangeToPO;
import service.blservice.GoodsStockBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsStockVO;
import vo.GoodsVO;

import java.rmi.RemoteException;

public class GoodsStockBLServiceImpl implements GoodsStockBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();

    @Override
    public ResultMessage add(GoodsVO vo, int stockNumber, String remark) throws RemoteException {
        GoodsStockVO goodsStockVO = new GoodsStockVO();
        goodsStockVO.setStockNumber(stockNumber);
        goodsStockVO.setRemark(remark);
        goodsStockVO.setVo(vo);
        double price = vo.getPurchasePrice();
        goodsStockVO.setTotalPrice(price * stockNumber);
        //初始化vo

        GoodsStockPO po  = voChangeToPO.goodsStockvo_to_goodsStockpo(goodsStockVO);
        dataFactory.getGoodsStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage add(GoodsVO vo, int stockNumber, double price, String remark) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockVO goodsStockVO = new GoodsStockVO();
        goodsStockVO.setStockNumber(stockNumber);
        goodsStockVO.setRemark(remark);
        goodsStockVO.setVo(vo);
        goodsStockVO.setTotalPrice(price * stockNumber);
        //初始化vo

        GoodsStockPO po  = voChangeToPO.goodsStockvo_to_goodsStockpo(goodsStockVO);
        dataFactory.getGoodsStockDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsStockVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockPO po = voChangeToPO.goodsStockvo_to_goodsStockpo(vo);
        dataFactory.getGoodsStockDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsStockVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsStockPO po = voChangeToPO.goodsStockvo_to_goodsStockpo(vo);
        dataFactory.getGoodsStockDataService().update(po);
        return ResultMessage.Success;
    }
}
