package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsPO;
import po.GoodsSalePO;
import po.MemberPO;
import po.SalePO;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.SaleDataService;

import java.util.ArrayList;
import java.util.Set;

public class SaleDataServiceImpl implements SaleDataService {
DataFactory dataFactory = new DataFactoryImpl();
    @Override
    public ResultMessage add(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SalePO> getProcessList() {
        String operation = "from Sale where state = process";
        ArrayList<SalePO> list = (ArrayList<SalePO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public void passCheck(SalePO po) {
        ArrayList<MemberPO> list = dataFactory.getMemberDataService().find
                ("", po.getRetailer(), "销售商");
        MemberPO memberPO = list.get(0);
        HQLTools.update(memberPO);

        memberPO.setPayment(po.getTotalPrice());
        Set<GoodsSalePO> set = po.getSaleSet();
        for(GoodsSalePO goodsSalePO : set){
            GoodsPO goodsPO = goodsSalePO.getPo();
            goodsPO.setCommodityNum(goodsPO.getCommodityNum() - goodsSalePO.getSaleNumber());
            HQLTools.update(goodsPO);
        }

    }
}
