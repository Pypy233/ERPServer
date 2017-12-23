package service.dataservice.Impl;

import objects.DateHelper;
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
import java.util.HashSet;
import java.util.Set;

public class SaleReturnDataServiceImpl implements SaleReturnDataService{
    DataFactory dataFactory = new DataFactoryImpl();
    DateHelper dateHelper = new DateHelper();

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

    @Override
    public void failCheck(SaleReturnPO po) {
        po.setState("fail");
        HQLTools.update(po);
    }


    @Override
    public ArrayList<SaleReturnPO> getSaleReturn(String startTime, String endTime, String userName, String memberName) {
        ArrayList<SaleReturnPO> list = (ArrayList<SaleReturnPO>)HQLTools.find("from SaleReturn");
        int size = list.size();
        if(size == 0)
            return null;
        ArrayList<SaleReturnPO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
                if(list.get(i).getSalesman().equals(userName) && list.get(i).getRetailer().equals(memberName))
                    resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    @Override
    public ArrayList<SaleReturnPO> getFail() {
        String operation = "from SaleReturn where state = fail";
        ArrayList<SaleReturnPO> list = (ArrayList<SaleReturnPO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public SaleReturnPO addRed(SaleReturnPO po) {
        SaleReturnPO po1 = po;
        Set<GoodsSaleReturnPO> poSet = po.getSaleReturnSet();
        Set<GoodsSaleReturnPO> poSet1 = new HashSet<>();
        for(GoodsSaleReturnPO goodsSalePO : poSet){
            GoodsSaleReturnPO po2 = goodsSalePO;
            po2.setSaleReturnNumber( -1 * goodsSalePO.getSaleReturnNumber());
            poSet1.add(po2);
        }
        po1.setSaleReturnSet(poSet1);
        return po1;
    }
}
