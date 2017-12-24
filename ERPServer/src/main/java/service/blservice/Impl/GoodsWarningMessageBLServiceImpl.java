package service.blservice.Impl;

import objects.HQLTools;
import objects.POtoVO;
import po.GoodsPO;

import service.blservice.GoodsWarningMessageBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.GoodsVO;


import java.rmi.RemoteException;
import java.util.ArrayList;

public class GoodsWarningMessageBLServiceImpl implements GoodsWarningMessageBLService{
    POtoVO pOtoVO = new POtoVO();
    DataFactory dataFactory = new DataFactoryImpl();
    @Override
    public ArrayList<GoodsVO> getWarningMessage(int number) throws RemoteException {
        ArrayList<GoodsPO> list = (ArrayList<GoodsPO>) HQLTools.find("from Goods");
        ArrayList<GoodsVO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCommodityNum() < number) {
                resultList.add(pOtoVO.goodspo_to_goodsvo(list.get(i)));
                GoodsPO po = list.get(i);
                po.setCommodityNum(number);
                dataFactory.getGoodsDataService().update(po);
            }
        }

        return resultList;
    }
}
