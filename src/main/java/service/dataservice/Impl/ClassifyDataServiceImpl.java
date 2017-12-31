package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.ClassifyPO;
import service.dataservice.ClassifyDataService;

import java.util.ArrayList;

public class ClassifyDataServiceImpl implements ClassifyDataService{
    /**
     *  /**
     * sql 语句：从数据库中获得Classify信息
     */

    private String operation = "from Classify";

    /**
     * classifyList 读取数据库中的goods信息，并随一次过程中更新自己，用内存换取效率
     */
    private ArrayList<ClassifyPO> classifyList = (ArrayList<ClassifyPO>) HQLTools.find(operation);



    @Override
    public ResultMessage add(ClassifyPO po) {
        if(contains(po))
            return ResultMessage.Fail;
        HQLTools.add(po);
        classifyList.add(po);
        return ResultMessage.Success;
    }

    /**
     * 将子分类添加到父分类上，一旦父分类存在商品就无法添加商品子分类
     * @param parentPO
     * @param sonPO
     * @return
     */
    @Override
    public ResultMessage add(ClassifyPO parentPO, ClassifyPO sonPO){
        if(contains(sonPO))
            return ResultMessage.Fail;
        if(parentPO.goodsSet.size() != 0)
            return ResultMessage.Fail;
        HQLTools.add(sonPO);
        classifyList.add(sonPO);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(ClassifyPO po) {
        if(!contains(po))
            return ResultMessage.Fail;
        HQLTools.delete(po);
        classifyList.remove(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(ClassifyPO po) {
        if(!contains(po))
            return ResultMessage.Fail;
        HQLTools.update(po);
        classifyList = (ArrayList<ClassifyPO>) HQLTools.find(operation);
        return ResultMessage.Success;
    }


    public boolean contains(ClassifyPO po){
        if(classifyList.size() > 0){
            for(int i = 0; i < classifyList.size(); i++){
                if(classifyList.get(i).getName().equals(po.getName()))
                    return true;
            }
        }
        return false;
    }
}
