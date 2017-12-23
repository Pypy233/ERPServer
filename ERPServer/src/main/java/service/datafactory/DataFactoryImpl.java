package service.datafactory;

import service.blservice.Impl.GoodsLackDataServiceImpl;
import service.dataservice.*;
import service.dataservice.Impl.*;


public class DataFactoryImpl implements DataFactory{
    @Override
    public UserDataService getUserDataService() {
        UserDataService user = new UserDataServiceImpl();
        return user;
    }

    @Override
    public ClassifyDataService getClassifyDataService(){
        ClassifyDataService classify = new ClassifyDataServiceImpl();
        return classify;
    }

    @Override
    public CommodityDataService getCommodityDataService(){
        CommodityDataService commodity = new CommodityDataServiceImpl();
        return commodity;
    }

    @Override
    public GoodsDataService getGoodsDataService(){
        GoodsDataService goods = new GoodsDataServiceImpl();
        return goods;
    }

    @Override
    public MemberDataService getMemberDataService(){
        MemberDataService member = new MemberDataServiceImpl();
        return member;
    }

    @Override
    public GoodsSaleDataService getGoodsSaleDataService() {
        GoodsSaleDataService goodsSaleData = new GoodsSaleDataServiceImpl();
        return goodsSaleData;
    }

    @Override
    public GoodsSaleReturnDataService getGoodsSaleReturnDataService() {
        GoodsSaleReturnDataService goodsSaleReturnData = new GoodsSaleReturnDataServiceImpl();
        return goodsSaleReturnData;
    }

    @Override
    public GoodsStockDataService getGoodsStockDataService() {
        GoodsStockDataService goodsStockData = new GoodsStockDataServiceImpl();
        return goodsStockData;
    }

    @Override
    public GoodsStockReturnDataService getGoodsStockReturnDataService() {
        GoodsStockReturnDataService goodsStockReturnData = new GoodsStockReturnDataServiceImpl();
        return goodsStockReturnData;
    }

    @Override
    public SaleDataService getSaleDataService() {
        SaleDataService saleData = new SaleDataServiceImpl();
        return saleData;
    }


    @Override
    public SaleReturnDataService getSaleReturnDataService() {
        SaleReturnDataService saleReturnData = new SaleReturnDataServiceImpl();
        return saleReturnData;
    }

    @Override
    public StockDataService getStockDataService(){
        StockDataService stock = new StockDataServiceImpl();
        return stock;
    }

    @Override
    public StockReturnDataService getStockReturnDataService() {
        StockReturnDataService stockReturnData = new StockReturnDataServiceImpl();
        return stockReturnData;
    }

    @Override
    public GoodsLackDataService getGoodsLackDataService() {
        GoodsLackDataService goodsLackData = new GoodsLackDataServiceImpl();
        return goodsLackData;
    }

    @Override
    public LackListDataService getLackListDataService() {
        LackListDataService lackListData = new LackListDataServiceImpl();
        return lackListData;
    }

    @Override
    public GoodsOverflowDataService getGoodsOverflowDataService() {
        GoodsOverflowDataService goodsOverflowData = new GoodsOverflowDataServiceImpl();
        return goodsOverflowData;
    }

    @Override
    public OverflowListDataService getOverflowListDataService() {
        OverflowListDataService overflowListData = new OverflowListDataServiceImpl();
        return overflowListData;
    }

    @Override
    public PresentDataService getPresentDataService() {
        PresentDataService presentData = new PresentDataServiceImpl();
        return presentData;
    }

    @Override
    public PresentListDataService getPresentListDataService() {
        PresentListDataService presentListData = new PresentListDataServiceImpl();
        return presentListData;
    }
}
