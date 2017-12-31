package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.*;
import service.dataservice.LackListDataService;
import vo.UserVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LackListDataServiceImpl implements LackListDataService {
    DateHelper dateHelper = new DateHelper();
    @Override
    public ResultMessage add(LackListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(LackListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(LackListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<LackListPO> getLackList(String startTime, String endTime, String userName) {
        ArrayList<LackListPO> list = (ArrayList<LackListPO>)HQLTools.find("from LackList");
        int size = list.size();
        ArrayList<LackListPO> resultList = new ArrayList<>();
        if(size == 0)
            return null;
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
                if(list.get(i).getOperator().equals(userName))
                    resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    @Override
    public LackListPO addRed(LackListPO po) {
        LackListPO po1 = new LackListPO();
        po1.setOperator(po.getOperator());
        po1.setDate(po.getDate());

        Set<GoodsLackPO> poSet = po.getSet();
        Set<GoodsLackPO> poSet1 = new HashSet<>();

        for(GoodsLackPO po2: poSet){
            GoodsLackPO tmp = new GoodsLackPO();
            GoodsPO goodsPO = po2.getPo();
            GoodsPO goodsPO1 = goodsPO;
            goodsPO1.setCommodityNum(-1 * goodsPO.getCommodityNum());
            tmp.setPo(goodsPO1);
            tmp.setTrueNumber(-1 * po2.getTrueNumber());
            poSet1.add(tmp);
        }
        po1.setSet(poSet1);
        HQLTools.add(po1);
        return po1;
    }

    @Override
    public ArrayList<LackListPO> getAllList() {
        ArrayList<LackListPO> list = (ArrayList<LackListPO>)HQLTools.find("from LackList");
        return list;
    }
}
