package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.*;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.StockReturnDataService;

import java.util.ArrayList;
import java.util.Set;

/**
 * 库存退货单的数据类
 */
public class StockReturnDataServiceImpl implements StockReturnDataService {
    DataFactory dataFactory = new DataFactoryImpl();

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
}
