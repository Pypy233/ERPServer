package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.MemberPO;
import service.dataservice.MemberDataService;

import java.util.ArrayList;

public class MemberDataServiceImpl implements MemberDataService{
    String operation = "from Member";
    /**
     * memberList读取数据库中的member信息，并随一次过程中更新自己，用内存换取效率
     */
    private ArrayList<MemberPO> memberList = (ArrayList<MemberPO>) HQLTools.find(operation);

    /**
     *  resultList 存储单次查询的结果，不需要保存到数据库
     */
    private ArrayList<MemberPO> resultList = new ArrayList<>();

    @Override
    public ResultMessage add(MemberPO po) {
        if(contains(po))
            return ResultMessage.Fail;
        HQLTools.add(po);
        memberList.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(MemberPO po) {
        if(!contains(po))
            return ResultMessage.Fail;
        HQLTools.delete(po);
        memberList.remove(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(MemberPO po) {
        if(!contains(po))
            return ResultMessage.Fail;
        HQLTools.update(po);
        memberList = (ArrayList<MemberPO>)HQLTools.find(operation);
        //维持代码简洁性直接读取数据库
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<MemberPO> find(String number, String name, String memberClass) {
        String operation = "";
        if(number == "")
            operation = "from Member where name like '%" +
                    name + "%' and memberClass like '%" + memberClass + "%'";
        else
            operation = "from Member where number = '" + number + "'";

        resultList = (ArrayList<MemberPO>) HQLTools.find(operation);
        return resultList;
    }

    public boolean contains(MemberPO po){
        if(memberList.size() > 0){
            for(int i = 0; i < memberList.size(); i++){
                if(memberList.get(i).getNumber() == (po.getNumber()))
                    return true;
            }
        }
        return false;
    }
}
