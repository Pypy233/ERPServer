package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.ClassifyPO;
import po.GoodsPO;
import service.VOChangeToPO;
import service.blservice.ClassifyBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.ClassifyVO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

public class ClassifyBLServiceImpl implements ClassifyBLService{

    DataFactory dataFactory = new DataFactoryImpl();

    /**
     * po to vo and vo to po
     */
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO potoVO = new POtoVO();

    @Override
    public ResultMessage addClassify(ClassifyVO vo) throws RemoteException {
        ClassifyPO po = voChangeToPO.classifyvo_to_classifypo(vo);
        ResultMessage result = dataFactory.getClassifyDataService().add(po);
        return result;
    }

    @Override
    public ResultMessage deleteClassify(ClassifyVO vo) throws RemoteException {
        ClassifyPO po = voChangeToPO.classifyvo_to_classifypo(vo);
        ResultMessage result = dataFactory.getClassifyDataService().delete(po);
        return result;
    }

    @Override
    public ResultMessage updateClassify(ClassifyVO vo) throws RemoteException {
        ClassifyPO po = voChangeToPO.classifyvo_to_classifypo(vo);
        ResultMessage result = dataFactory.getClassifyDataService().update(po);
        return result;
    }

    @Override
    public ArrayList<GoodsVO> getGoods(ClassifyVO vo) throws RemoteException {
        ArrayList<GoodsVO> goodsList = new ArrayList<>();

        ClassifyPO po = voChangeToPO.classifyvo_to_classifypo(vo);
        Set<GoodsPO> set = po.getGoodsSet();
        for(GoodsPO goodsPO:set){
            goodsList.add(potoVO.goodspo_to_goodsvo(goodsPO));
        }
        return goodsList;
    }
}
