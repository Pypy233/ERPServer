package service.dataservice;

import objects.ResultMessage;
import po.CommodityPO;

import java.util.ArrayList;

/**
 * Created by py on 2017/10/19.
 */
public interface CommodityDataService {
    /*
    * */
    public ResultMessage isInTime(String time);
    public ArrayList<CommodityPO> getComInfo(String date);
    public ArrayList<CommodityPO> getGoods(String goodsNode);
    public ArrayList<CommodityPO> createPresentList(String date);
    public ResultMessage submitPresentOrder(String date, ArrayList<CommodityPO> presentLst);
    public ResultMessage removeCom(String date, ArrayList<CommodityPO> presentLst);
    public ResultMessage submitBreakageRecepit(String date, ArrayList<CommodityPO> brkLst);
    public ResultMessage submitOverflowRecepit(String date, ArrayList<CommodityPO> overflowLst);
    public ResultMessage submitWarningRecepit(String date, ArrayList<CommodityPO> overflowLst);
}
