package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsLackPO;
import service.VOChangeToPO;
import service.blservice.GoodsLackBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsLackVO;

public class GoodsLackBLServiceImpl implements GoodsLackBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();

    @Override
    public ResultMessage addGoodsLack(GoodsLackVO vo) {
        GoodsLackPO po = voChangeToPO.goodsLackvo_to_goodsLackpo(vo);
        ResultMessage msg = dataFactory.getGoodsLackDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteGoodsLack(GoodsLackVO vo) {
        GoodsLackPO po = voChangeToPO.goodsLackvo_to_goodsLackpo(vo);
        ResultMessage msg = dataFactory.getGoodsLackDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage update(GoodsLackVO vo) {
        GoodsLackPO po = voChangeToPO.goodsLackvo_to_goodsLackpo(vo);
        ResultMessage msg = dataFactory.getGoodsLackDataService().update(po);
        return msg;
    }
}
