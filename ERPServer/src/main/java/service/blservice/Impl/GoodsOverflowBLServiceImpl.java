package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsOverflowPO;
import service.VOChangeToPO;
import service.blservice.GoodsOverflowBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsOverflowVO;

public class GoodsOverflowBLServiceImpl implements GoodsOverflowBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    @Override
    public ResultMessage addGoodsOverflow(GoodsOverflowVO vo) {
        GoodsOverflowPO po = voChangeToPO.goodsOverflowvo_to_goodsOverflowpo(vo);
        ResultMessage msg = dataFactory.getGoodsOverflowDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteGoodsOverflow(GoodsOverflowVO vo) {
        GoodsOverflowPO po = voChangeToPO.goodsOverflowvo_to_goodsOverflowpo(vo);
        ResultMessage msg = dataFactory.getGoodsOverflowDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage update(GoodsOverflowVO vo) {
        GoodsOverflowPO po = voChangeToPO.goodsOverflowvo_to_goodsOverflowpo(vo);
        ResultMessage msg = dataFactory.getGoodsOverflowDataService().update(po);
        return msg;
    }
}
