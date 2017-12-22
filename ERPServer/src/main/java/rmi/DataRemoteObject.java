package rmi;

import objects.ResultMessage;
import service.blservice.*;
import service.blservice.Impl.*;
import vo.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

public class DataRemoteObject extends UnicastRemoteObject implements ClassifyBLService, CommodityBLService, GoodsBLService,
    GoodsSaleBLService, GoodsSaleReturnBLService, GoodsStockBLService, GoodsStockReturnBLService, MemberBLService,
    SaleBLService, SaleReturnBLService, StockBLService, StockReturnBLService, UserBLService{
    private static final long serialVersionUID = 4029039744279087114L;

    private ClassifyBLService classifyBLService;
    private CommodityBLService commodityBLService;

    private GoodsBLService goodsBLService;

    private GoodsSaleBLService goodsSaleBLService;
    private GoodsSaleReturnBLService goodsSaleReturnBLService;
    private GoodsStockBLService goodsStockBLService;
    private GoodsStockReturnBLService goodsStockReturnBLService;

    private MemberBLService memberBLService;

    private SaleBLService saleBLService;
    private SaleReturnBLService saleReturnBLService;
    private StockBLService stockBLService;
    private StockReturnBLService stockReturnBLService;

    private UserBLService userBLService;

    protected DataRemoteObject() throws RemoteException{
        classifyBLService = new ClassifyBLServiceImpl();
        commodityBLService = new CommodityBLServiceImpl();

        goodsBLService = new GoodsBLServiceImpl();

        goodsSaleBLService = new GoodsSaleBLServiceImpl();
        goodsSaleReturnBLService = new GoodsSaleReturnBLServiceImpl();
        goodsStockBLService = new GoodsStockBLServiceImpl();
        goodsStockReturnBLService = new GoodsStockReturnBLServiceImpl();

        memberBLService = new MemberBLServiceImpl();

        saleBLService = new SaleBLServiceImpl();
        saleReturnBLService = new SaleReturnBLServiceImpl();
        stockBLService = new StockBLServiceImpl();
        stockReturnBLService = new StockReturnBLServiceImpl();

        userBLService = new UserBLServiceImpl();
    }


    @Override
    public ResultMessage addClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.addClassify(vo);
    }

    @Override
    public ResultMessage deleteClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.deleteClassify(vo);
    }

    @Override
    public ResultMessage updateClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.updateClassify(vo);
    }

    @Override
    public ArrayList<GoodsVO> getGoods(ClassifyVO vo) throws RemoteException {
        return classifyBLService.getGoods(vo);
    }


    @Override
    public void check(String date) {
        commodityBLService.check(date);
    }

    @Override
    public PresentListVO getPresentList(String startTime, String endTime) {
        return commodityBLService.getPresentList(startTime, endTime);
    }

    @Override
    public OverflowListVO getOverflowList(String startTime, String endTime) {
        return commodityBLService.getOverflowList(startTime, endTime);
    }

    @Override
    public LackListVO getLackList(String startTime, String endTime) {
        return commodityBLService.getLackList(startTime, endTime);
    }

    @Override
    public ArrayList<GoodsVO> getWarningList(int warningNumber) {
        return commodityBLService.getWarningList(warningNumber);
    }

    @Override
    public ResultMessage addGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.addGoods(vo);
    }

    @Override
    public ResultMessage deleteGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.deleteGoods(vo);
    }

    @Override
    public ResultMessage updateGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.updateGoods(vo);
    }

    @Override
    public ArrayList<GoodsVO> findGoods(String number, String name, String type) throws RemoteException {
        return goodsBLService.findGoods(number, name, type);
    }

    @Override
    public ResultMessage addGoodsSale(GoodsVO vo, int saleNumber, double price, String remark) throws RemoteException {
        return goodsSaleBLService.addGoodsSale(vo, saleNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsSale(GoodsSaleVO vo) throws RemoteException {
        return goodsSaleBLService.deleteGoodsSale(vo);
    }

    @Override
    public ResultMessage updateGoodsSale(GoodsSaleVO vo) throws RemoteException {
        return goodsSaleBLService.updateGoodsSale(vo);
    }

    @Override
    public ResultMessage addGoodsSaleReturn(GoodsVO vo, int saleReturnNumber, double price, String remark) throws RemoteException {
        return goodsSaleReturnBLService.addGoodsSaleReturn(vo, saleReturnNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsSaleReturn(GoodsSaleReturnVO vo) throws RemoteException {
        return goodsSaleReturnBLService.deleteGoodsSaleReturn(vo);
    }

    @Override
    public ResultMessage updateGoodsSaleReturn(GoodsSaleReturnVO vo) throws RemoteException {
        return goodsSaleReturnBLService.updateGoodsSaleReturn(vo);
    }

    @Override
    public ResultMessage addGoodsStock(GoodsVO vo, int stockNumber, String remark) throws RemoteException {
        return goodsStockBLService.addGoodsStock(vo, stockNumber, remark);
    }

    @Override
    public ResultMessage addGoodsStock(GoodsVO vo, int stockNumber, double price, String remark) throws RemoteException {
        return goodsStockBLService.addGoodsStock(vo, stockNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsStock(GoodsStockVO vo) throws RemoteException {
        return goodsStockBLService.deleteGoodsStock(vo);
    }

    @Override
    public ResultMessage updateGoodsStock(GoodsStockVO vo) throws RemoteException {
        return goodsStockBLService.updateGoodsStock(vo);
    }

    @Override
    public ResultMessage addGoodsStockReturn(GoodsVO vo, int stockReturnNumber, double price, String remark) throws RemoteException {
        return goodsStockReturnBLService.addGoodsStockReturn(vo, stockReturnNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsStockReturn(GoodsStockReturnVO vo) throws RemoteException {
        return goodsStockReturnBLService.deleteGoodsStockReturn(vo);
    }

    @Override
    public ResultMessage updateGoodsStockReturn(GoodsStockReturnVO vo) throws RemoteException {
        return goodsStockReturnBLService.updateGoodsStockReturn(vo);
    }

    @Override
    public ResultMessage addMember(MemberVO vo) throws RemoteException {
        return memberBLService.addMember(vo);
    }

    @Override
    public ResultMessage deleteMember(MemberVO vo) throws RemoteException {
        return memberBLService.deleteMember(vo);
    }

    @Override
    public ResultMessage updateMember(MemberVO vo) throws RemoteException {
        return memberBLService.updateMember(vo);
    }

    @Override
    public ResultMessage addSale(String retailer, String salesman, String operator, double discount,
                                 double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException {

        return saleBLService.addSale(retailer, salesman, operator, discount, voucher, remark, set);
    }

    @Override
    public ResultMessage deleteSale(SaleVO vo) throws RemoteException {
        return saleBLService.deleteSale(vo);
    }

    @Override
    public ResultMessage updateSale(SaleVO vo) throws RemoteException {
        return saleBLService.updateSale(vo);
    }

    @Override
    public ArrayList<SaleVO> getSaleProcessList() throws RemoteException {
        return saleBLService.getSaleProcessList();
    }

    @Override
    public void passSaleCheck(SaleVO vo) throws RemoteException {
        saleBLService.passSaleCheck(vo);
    }

    @Override
    public void failSaleCheck(SaleVO vo) throws RemoteException {
        saleBLService.failSaleCheck(vo);
    }

    @Override
    public ResultMessage addSaleReturn(String retailer, String salesman, String operator, String remark,
                                       Set<GoodsSaleReturnVO> set) throws RemoteException {
        return saleReturnBLService.addSaleReturn(retailer, salesman, operator, remark, set);
    }

    @Override
    public ResultMessage deleteSaleReturn(SaleReturnVO vo) throws RemoteException {
        return saleReturnBLService.deleteSaleReturn(vo);
    }

    @Override
    public ResultMessage updateSaleReturn(SaleReturnVO vo) throws RemoteException {
        return saleReturnBLService.updateSaleReturn(vo);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnProcessList() throws RemoteException {
        return saleReturnBLService.getSaleReturnProcessList();
    }

    @Override
    public void passSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
         saleReturnBLService.passSaleReturnCheck(vo);
    }

    @Override
    public void failSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
        saleReturnBLService.failSaleReturnCheck(vo);
    }

    @Override
    public ResultMessage addStock(StockVO vo) throws RemoteException {
        return stockBLService.addStock(vo);
    }

    @Override
    public ResultMessage addStock(String provider, String remark, Set<GoodsStockVO> set) throws RemoteException {
        return stockBLService.addStock(provider, remark, set);
    }

    @Override
    public ResultMessage deleteStock(StockVO vo) throws RemoteException {
        return stockBLService.deleteStock(vo);
    }

    @Override
    public ResultMessage updateStock(StockVO vo) throws RemoteException {
        return stockBLService.updateStock(vo);
    }

    @Override
    public ArrayList<StockVO> getStockProcessList() throws RemoteException {
        return stockBLService.getStockProcessList();
    }

    @Override
    public void passStockCheck(StockVO vo) throws RemoteException {
        stockBLService.passStockCheck(vo);
    }

    @Override
    public void failStockCheck(StockVO vo) throws RemoteException {
        stockBLService.failStockCheck(vo);
    }

    @Override
    public ResultMessage addStockReturn(String provider, String remark, Set<GoodsStockReturnVO> set) throws RemoteException {
        return stockReturnBLService.addStockReturn(provider, remark, set);
    }

    @Override
    public ResultMessage deleteStockReturn(StockReturnVO vo) throws RemoteException {
        return stockReturnBLService.deleteStockReturn(vo);
    }

    @Override
    public ResultMessage updateStockReturn(StockReturnVO vo) throws RemoteException {
        return stockReturnBLService.updateStockReturn(vo);
    }

    @Override
    public ArrayList<StockReturnVO> getStockReturnProcessList() throws RemoteException {
        return stockReturnBLService.getStockReturnProcessList();
    }

    @Override
    public void passStockReturnCheck(StockReturnVO vo) throws RemoteException {
        stockReturnBLService.passStockReturnCheck(vo);
    }

    @Override
    public void failStockReturnCheck(StockReturnVO vo) throws RemoteException {
        stockReturnBLService.failStockReturnCheck(vo);
    }

    @Override
    public ResultMessage register(UserVO vo) {
        return userBLService.register(vo);
    }

    @Override
    public ResultMessage check(String name, String password) {
        return userBLService.check(name, password);
    }

    @Override
    public ResultMessage updatePassword(String name, String password, String type) {
        return userBLService.updatePassword(name, password, type);
    }

    @Override
    public UserVO getUserVO(String name) {
        return userBLService.getUserVO(name);
    }
}
