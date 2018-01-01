package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.GoodsPO;
import service.VOChangeToPO;
import service.blservice.GoodsBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GoodsBLServiceImpl implements GoodsBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    /**
     * po to vo and vo to po
     */
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO potoVO = new POtoVO();
    @Override
    public ResultMessage addGoods(GoodsVO vo) throws RemoteException {
        GoodsPO po = voChangeToPO.goodsvo_to_goodspo(vo);
        ResultMessage result = dataFactory.getGoodsDataService().add(po);
        return result;
    }

    @Override
    public ResultMessage deleteGoods(GoodsVO vo) throws RemoteException {
        GoodsPO po = voChangeToPO.goodsvo_to_goodspo(vo);
        ResultMessage result = dataFactory.getGoodsDataService().delete(po);
        return result;
    }

    @Override
    public ResultMessage updateGoods(GoodsVO vo) throws RemoteException {
        GoodsPO po = voChangeToPO.goodsvo_to_goodspo(vo);
        ResultMessage result = dataFactory.getGoodsDataService().update(po);
        return result;
    }

    @Override
    public ArrayList<GoodsVO> findGoods(String number, String name, String type) throws RemoteException {
        ArrayList<GoodsVO> voList = new ArrayList<>();
        ArrayList<GoodsPO> poList = dataFactory.getGoodsDataService().find(number, name, type);
        System.out.println(poList.size());
        if(poList.size() == 0)
            return null;
        for(int i = 0; i < poList.size(); i++){
                voList.add(potoVO.goodspo_to_goodsvo(poList.get(i)));
        }
        return voList;
    }

    @Override
    public ArrayList<GoodsVO> getCurrentGoods() throws RemoteException{
        ArrayList<GoodsPO> poList = dataFactory.getGoodsDataService().getCurrentGoods();
        ArrayList<GoodsVO> voList = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            voList.add(potoVO.goodspo_to_goodsvo(poList.get(i)));
        }
        return voList;
    }

   // public static void main(String[] args) throws RemoteException{
     //   GoodsBLService goodsBLService = new GoodsBLServiceImpl();
      //  ArrayList list = goodsBLService.findGoods("", "", "台");
    //}  debug finished


}
