package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsPO;
import po.GoodsSalePO;
import service.dataservice.GoodsDataService;

import java.util.ArrayList;

public class GoodsDataServiceImpl implements GoodsDataService  {
    /**
     * sql 语句：从数据库中获得Goods信息
     */
    String operation = "from Goods";

    /**
     *  goodsList 读取数据库中的goods信息，并随一次过程中更新自己，用内存换取效率
     */
    private ArrayList<GoodsPO> goodsList = (ArrayList<GoodsPO>)HQLTools.find(operation);

    /**
     * resultList 存储单次查询的结果，不需要保存到数据库
     */
    private ArrayList<GoodsPO> resultList = new ArrayList<>();

    @Override
    public ResultMessage add(GoodsPO po) {
        if(contains(po))
            return ResultMessage.Fail;
        HQLTools.add(po);
        goodsList.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(GoodsPO po) {
        if(!contains(po))
            return ResultMessage.Fail;
        HQLTools.delete(po);
        goodsList.remove(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(GoodsPO po) {
        // throw warning
        if(!contains(po))
            return ResultMessage.Fail;
        
        HQLTools.update(po);
        goodsList = (ArrayList<GoodsPO>)HQLTools.find(operation);
        return ResultMessage.Success;
    }



    @Override
    public ArrayList<GoodsPO> find(String number, String name, String type) {
        if(number == "" && name == "")
            operation = "from Goods where type like '%" + type + "%'";
        else if(number == "" && type == "")
            operation = "from Goods where name like '%" + name + "'%";
        else if(number == "" && type != "" && name != "")
            operation = "from Goods where name like '%" + name + "'% and type like'%" + type + "%'";
        else if(number != "" && name == "" && type == "")
            operation = "from Goods where number = '" + number + "'" ;

        resultList = (ArrayList<GoodsPO>) HQLTools.find(operation);
        // Ought to be discussed, finished
        return resultList;
    }

    @Override
    public ArrayList<GoodsPO> getCurrentGoods() {
        ArrayList<GoodsPO> list = (ArrayList<GoodsPO>) HQLTools.find("from Goods");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCommodityNum() == 0)
                list.remove(i);
        }
        return list;
    }

    public boolean contains(GoodsPO po){
        if(goodsList.size() > 0){
            for(int i = 0; i < goodsList.size(); i++){
                if(goodsList.get(i).getNumber() == (po.getNumber()))
                    return true;
            }
        }
        return false;
    }

}
