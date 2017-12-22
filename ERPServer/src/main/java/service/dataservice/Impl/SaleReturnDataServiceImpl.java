package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsPO;
import po.GoodsSaleReturnPO;
import po.MemberPO;
import po.SaleReturnPO;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.SaleReturnDataService;

import java.util.ArrayList;
import java.util.Set;

public class SaleReturnDataServiceImpl implements SaleReturnDataService{
    DataFactory dataFactory = new DataFactoryImpl();

    @Override
    public ResultMessage add(SaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(SaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(SaleReturnPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SaleReturnPO> getProcessList() {
        String operation = "from SaleReturn where state = process";
        ArrayList<SaleReturnPO> list = (ArrayList<SaleReturnPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public void passCheck(SaleReturnPO po) {
        ArrayList<MemberPO> list = dataFactory.getMemberDataService().find
                ("", po.getRetailer(), "销售商");
        MemberPO memberPO = list.get(0);
        HQLTools.update(memberPO);

        memberPO.setCollection(po.getPayPrice());
        Set<GoodsSaleReturnPO> set = po.getSaleReturnSet();
        for(GoodsSaleReturnPO goodsSaleReturnPO : set){
            GoodsPO goodsPO = goodsSaleReturnPO.getPo();
            goodsPO.setCommodityNum(goodsPO.getCommodityNum() + goodsSaleReturnPO.getSaleReturnNumber());
            HQLTools.update(goodsPO);
        }
    }
}
