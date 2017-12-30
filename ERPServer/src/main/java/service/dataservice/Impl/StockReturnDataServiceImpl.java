package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.*;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.StockReturnDataService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 库存退货单的数据类
 */
public class StockReturnDataServiceImpl implements StockReturnDataService {
    DataFactory dataFactory = new DataFactoryImpl();
    DateHelper dateHelper = new DateHelper();

    @Override
    public ResultMessage add(StockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(StockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        po.setState("process");
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(StockReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<StockReturnPO> getProcessList() {
        String operation = "from StockReturn where state = process";
        ArrayList<StockReturnPO> list = (ArrayList<StockReturnPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public void passCheck(StockReturnPO po) {
        po.setState("pass");
        update(po);

        ArrayList<MemberPO> list = dataFactory.getMemberDataService().find
                ("", po.getProvider(), "供货商");
        MemberPO memberPO = list.get(0);
        HQLTools.update(memberPO);
        memberPO.setPayment(po.getTotalPrice());

        Set<GoodsStockReturnPO> set = po.getStockSet();
        for(GoodsStockReturnPO goodsStockReturnPO : set){
            GoodsPO goodsPO = goodsStockReturnPO.getPo();
            goodsPO.setCommodityNum(goodsPO.getCommodityNum() - goodsStockReturnPO.getStockReturnNumber());
            HQLTools.update(goodsPO);
        }
    }

    @Override
    public void failCheck(StockReturnPO po) {
        po.setState("fail");
        HQLTools.update(po);
    }

    @Override
    public ArrayList<StockReturnPO> getStockReturn(String startTime, String endTime,
                                                   String userName, String memberName) {
        ArrayList<StockReturnPO> list = (ArrayList<StockReturnPO>)HQLTools.find("from StockReturn");
        int size = list.size();
        if(size == 0)
            return null;
        ArrayList<StockReturnPO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
                if(list.get(i).getOperator().equals(userName) && list.get(i).getProvider().equals(memberName))
                    resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    @Override
    public ArrayList<StockReturnPO> getFail() {
        String operation = "from StockReturn where state = fail";
        ArrayList<StockReturnPO> list = (ArrayList<StockReturnPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public StockReturnPO addRed(StockReturnPO po) {
        StockReturnPO po1 = po;
        Set<GoodsStockReturnPO> poSet = po.getStockSet();
        Set<GoodsStockReturnPO> poSet1 = new HashSet<>();
        for(GoodsStockReturnPO goodsSalePO : poSet){
            GoodsStockReturnPO po2 = goodsSalePO;
            po2.setStockReturnNumber( -1 * goodsSalePO.getStockReturnNumber());
            poSet1.add(po2);
        }
        po1.setStockSet(poSet1);
        return po1;
    }
}
