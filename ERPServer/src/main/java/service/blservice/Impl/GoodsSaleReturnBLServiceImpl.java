package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsSaleReturnPO;
import service.VOChangeToPO;
import service.blservice.GoodsSaleReturnBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsSaleReturnVO;
import vo.GoodsVO;

import java.rmi.RemoteException;

public class GoodsSaleReturnBLServiceImpl implements GoodsSaleReturnBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();

    @Override
    public ResultMessage add(GoodsVO vo, int saleReturnNumber, double price, String remark) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSaleReturnVO goodsSaleReturnVO = new GoodsSaleReturnVO();
        goodsSaleReturnVO.setVo(vo);
        goodsSaleReturnVO.setSaleReturnNumber(saleReturnNumber);
        goodsSaleReturnVO.setPrice(price);
        goodsSaleReturnVO.setRemark(remark);
        //初始化vo

        GoodsSaleReturnPO po = voChangeToPO.goodsSaleReturnvo_to_goodsSaleReturnpo(goodsSaleReturnVO);
        dataFactory.getGoodsSaleReturnDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsSaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSaleReturnPO po = voChangeToPO.goodsSaleReturnvo_to_goodsSaleReturnpo(vo);
        dataFactory.getGoodsSaleReturnDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsSaleReturnVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSaleReturnPO po = voChangeToPO.goodsSaleReturnvo_to_goodsSaleReturnpo(vo);
        dataFactory.getGoodsSaleReturnDataService().update(po);
        return ResultMessage.Success;
    }
}
