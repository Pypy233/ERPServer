package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.MemberPO;
import po.PresentListPO;
import po.PresentPO;
import po.UserPO;
import service.blservice.PresentListBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.PresentListDataService;
import vo.PresentListVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PresentListDataServiceImpl implements PresentListDataService {
   DateHelper dateHelper = new DateHelper();

    @Override
    public ResultMessage add(PresentListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(PresentListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(PresentListPO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<PresentListPO> getPresentList(String startTime, String endTime, String userName, String memberName) {
        ArrayList<PresentListPO> list = (ArrayList<PresentListPO>)HQLTools.find("from PresentList");
        int size = list.size();
        if(size == 0)
            return null;
        ArrayList<PresentListPO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate()))
                if(list.get(i).getClient().equals(memberName) && list.get(i).getOperator().equals(userName))
                    resultList.add(list.get(i));
        }
        return resultList;
    }

    @Override
    public PresentListPO addRed(PresentListPO po) {
        PresentListPO po1 = new PresentListPO();
        po1.setDate(po.getDate());
        po1.setOperator(po.getOperator());
        po1.setClient(po.getClient());

        Set<PresentPO> set = po.getSet();
        Set<PresentPO> set1 = new HashSet<>();
        for(PresentPO presentPO : set){
            PresentPO tmp = presentPO;
            tmp.setNumber( -1 * presentPO.getNumber());
            set1.add(tmp);
        }
        po1.setSet(set1);
        return po1;
    }

    @Override
    public ArrayList<PresentListPO> getAllList() {
        ArrayList<PresentListPO> list = (ArrayList<PresentListPO>) HQLTools.find("from PresentList");
        return list;
    }
}
