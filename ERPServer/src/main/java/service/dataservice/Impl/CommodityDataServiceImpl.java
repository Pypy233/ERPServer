package service.dataservice.Impl;

import objects.ResultMessage;
import po.CommodityPO;
import service.dataservice.CommodityDataService;

import java.util.ArrayList;

public class CommodityDataServiceImpl implements CommodityDataService{
    @Override
    public ResultMessage isInTime(String time) {
        return null;
    }

    @Override
    public ArrayList<CommodityPO> getComInfo(String date) {
        return null;
    }

    @Override
    public ArrayList<CommodityPO> getGoods(String goodsNode) {
        return null;
    }

    @Override
    public ArrayList<CommodityPO> createPresentList(String date) {
        return null;
    }

    @Override
    public ResultMessage submitPresentOrder(String date, ArrayList<CommodityPO> presentLst) {
        return null;
    }

    @Override
    public ResultMessage removeCom(String date, ArrayList<CommodityPO> presentLst) {
        return null;
    }

    @Override
    public ResultMessage submitBreakageRecepit(String date, ArrayList<CommodityPO> brkLst) {
        return null;
    }

    @Override
    public ResultMessage submitOverflowRecepit(String date, ArrayList<CommodityPO> overflowLst) {
        return null;
    }

    @Override
    public ResultMessage submitWarningRecepit(String date, ArrayList<CommodityPO> overflowLst) {
        return null;
    }
}
