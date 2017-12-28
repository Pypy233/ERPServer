package service.datafactory;
/**
 *
 * factory 模式，提供各种数据服务
 */

import po.LackListPO;
import po.OverflowListPO;
import service.dataservice.*;

public interface DataFactory {

    public UserDataService getUserDataService();

    public ClassifyDataService getClassifyDataService();


    public GoodsDataService getGoodsDataService();

    public MemberDataService getMemberDataService();

    public GoodsSaleDataService getGoodsSaleDataService();

    public GoodsSaleReturnDataService getGoodsSaleReturnDataService();

    public GoodsStockDataService getGoodsStockDataService();

    public GoodsStockReturnDataService getGoodsStockReturnDataService();

    public SaleDataService getSaleDataService();

    public SaleReturnDataService getSaleReturnDataService();

    public StockDataService getStockDataService();

    public StockReturnDataService getStockReturnDataService();

    public GoodsLackDataService getGoodsLackDataService();

    public LackListDataService getLackListDataService();

    public GoodsOverflowDataService getGoodsOverflowDataService();

    public OverflowListDataService getOverflowListDataService();

    public PresentDataService getPresentDataService();

    public PresentListDataService getPresentListDataService();

    public LogDataService getLogDataService();

}
