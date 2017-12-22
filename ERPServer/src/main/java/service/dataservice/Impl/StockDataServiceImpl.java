package service.dataservice.Impl;

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
import java.util.Set;

public class StockDataServiceImpl implements StockDataService {
    DataFactory dataFactory = new DataFactoryImpl();

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
}
