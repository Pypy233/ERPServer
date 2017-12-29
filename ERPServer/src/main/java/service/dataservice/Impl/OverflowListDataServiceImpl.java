package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsOverflowPO;
import po.GoodsPO;
import po.OverflowListPO;
import po.UserPO;
import service.dataservice.OverflowListDataService;
import vo.OverflowListVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OverflowListDataServiceImpl implements OverflowListDataService {
DateHelper dateHelper = new DateHelper();

    @Override
    public ResultMessage add(OverflowListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(OverflowListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(OverflowListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<OverflowListPO> getOverflowList(String startTime, String endTime, String userName) {
        ArrayList<OverflowListPO> list = (ArrayList<OverflowListPO>)HQLTools.find("from OverflowList");
        int size = list.size();

        if(size == 0)
            return  null;
        ArrayList<OverflowListPO> resultList = new ArrayList<>();
       for(int i = 0; i < size; i++){
           if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
               if(list.get(i).getOperator().equals(userName))
                   resultList.add(list.get(i));
           }
       }
        return resultList;
    }

    @Override
    public OverflowListPO addRed(OverflowListPO po) {
        OverflowListPO po1 = new OverflowListPO();
        po1.setDate(po.getDate());
        po1.setOperator(po.getOperator());

        Set<GoodsOverflowPO> set = po.getSet();
        Set<GoodsOverflowPO> set1 = new HashSet<>();

        for(GoodsOverflowPO po2: set){
            GoodsOverflowPO tmp = po2;
            GoodsPO goodsPO = po2.getPo();
            GoodsPO goodsPO1 = po2.getPo();
            goodsPO1.setCommodityNum(-1 * goodsPO.getCommodityNum());
            tmp.setPo(goodsPO1);
            tmp.setTrueNumber( -1 * po2.getTrueNumber());
            set1.add(tmp);
        }
        po1.setSet(set);
        HQLTools.add(set1);
        return po1;
    }

    @Override
    public ArrayList<OverflowListPO> getAllList() {
        ArrayList<OverflowListPO> list = (ArrayList<OverflowListPO>) HQLTools.find("from OverflowList");
        return list;
    }
}
