package service.blservice.Impl;

import objects.ResultMessage;
import po.GoodsSalePO;
import service.VOChangeToPO;
import service.blservice.GoodsSaleBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsSaleVO;
import vo.GoodsVO;

import java.rmi.RemoteException;

public class GoodsSaleBLServiceImpl implements GoodsSaleBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();

    @Override
    public ResultMessage add(GoodsVO vo, int saleNumber, double price, String remark) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSaleVO goodsSaleVO = new GoodsSaleVO();
        goodsSaleVO.setVo(vo);
        goodsSaleVO.setSaleNumber(saleNumber);
        goodsSaleVO.setPrice(price);
        goodsSaleVO.setRemark(remark);
        //初始化vo

        GoodsSalePO po = voChangeToPO.goodsSalevo_to_goodsSalepo(goodsSaleVO);
        dataFactory.getGoodsSaleDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsSaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSalePO po = voChangeToPO.goodsSalevo_to_goodsSalepo(vo);
        dataFactory.getGoodsSaleDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsSaleVO vo) throws RemoteException {
        if(vo == null)
            return ResultMessage.Fail;

        GoodsSalePO po = voChangeToPO.goodsSalevo_to_goodsSalepo(vo);
        dataFactory.getGoodsSaleDataService().update(po);
        return ResultMessage.Success;
    }
}
