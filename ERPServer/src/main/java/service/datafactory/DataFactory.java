package service.datafactory;
/**
 *
 * factory 模式，提供各种数据服务
 */

import service.dataservice.*;

public interface DataFactory {

    public UserDataService getUserDataService();

    public ClassifyDataService getClassifyDataService();

    public CommodityDataService getCommodityDataService();

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


}
