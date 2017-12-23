package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsPO;
import po.GoodsStockPO;
import po.MemberPO;
import po.StockPO;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.StockDataService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StockDataServiceImpl implements StockDataService {
    DataFactory dataFactory = new DataFactoryImpl();
    DateHelper dateHelper = new DateHelper();

    @Override
    public ResultMessage add(StockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(StockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(StockPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<StockPO> getProcessList() {
        String operation = "from Stock where state = process";
        ArrayList<StockPO> list = (ArrayList<StockPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public void passCheck(StockPO po) {
        ArrayList<MemberPO> list = dataFactory.getMemberDataService().find
                ("", po.getProvider(), "供货商");
        MemberPO memberPO = list.get(0);
        HQLTools.update(memberPO);
        memberPO.setCollection(po.getTotalPrice());

        Set<GoodsStockPO> set = po.getStockSet();
        for(GoodsStockPO goodsStockPO : set){
            GoodsPO goodsPO = goodsStockPO.getPo();
            goodsPO.setCommodityNum(goodsPO.getCommodityNum() + goodsStockPO.getStockNumber());
            HQLTools.update(goodsPO);
        }

    }

    @Override
    public void failCheck(StockPO po) {
        po.setState("fail");
        HQLTools.update(po);
    }

    @Override
    public ArrayList<StockPO> getStock(String startTime, String endTime, String userName, String memberName) {
        ArrayList<StockPO> list = (ArrayList<StockPO>)HQLTools.find("from Stock");
        int size = list.size();
        if(size == 0)
            return null;
        ArrayList<StockPO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
                if(list.get(i).getOperator().equals(userName) && list.get(i).getProvider().equals(memberName))
                    resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    @Override
    public ArrayList<StockPO> getFail() {
        String operation = "from Stock where state = fail";
        ArrayList<StockPO> list = (ArrayList<StockPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public StockPO addRed(StockPO po) {
        StockPO po1 = po;
        Set<GoodsStockPO> poSet = po.getStockSet();
        Set<GoodsStockPO> poSet1 = new HashSet<>();
        for(GoodsStockPO goodsSalePO : poSet){
            GoodsStockPO po2 = goodsSalePO;
            po2.setStockNumber( -1 * goodsSalePO.getStockNumber());
            poSet1.add(po2);
        }
        po1.setStockSet(poSet1);
        return po1;
    }
}
