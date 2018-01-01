package rmi;

import com.sun.org.apache.regexp.internal.RE;
import objects.ResultMessage;
import po.GoodsOverflowPO;
import service.blservice.*;
import service.blservice.Impl.*;
import vo.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

public class DataRemoteObject extends UnicastRemoteObject implements ClassifyBLService , GoodsBLService,
    GoodsSaleBLService, GoodsSaleReturnBLService, GoodsStockBLService, GoodsStockReturnBLService, MemberBLService,
    SaleBLService, SaleReturnBLService, StockBLService, StockReturnBLService, UserBLService, GoodsLackBLService,
        GoodsOverflowBLService, PresentBLService, LackListBLService, OverflowListBLService, PresentListBLService,
        GoodsWarningMessageBLService, LogBLService, AdminBLService{
    private static final long serialVersionUID = 4029039744279087114L;

    private ClassifyBLService classifyBLService;

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

    private GoodsLackBLService goodsLackBLService;
    private GoodsOverflowBLService goodsOverflowBLService;
    private PresentBLService presentBLService;

    private LackListBLService lackListBLService;
    private OverflowListBLService overflowListBLService;
    private PresentListBLService presentListBLService;
    private GoodsWarningMessageBLService goodsWarningMessageBLService;

    private LogBLService logBLService;

    private AdminBLService adminBLService;


    protected DataRemoteObject() throws RemoteException{
        super();
        classifyBLService = new ClassifyBLServiceImpl();


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

        goodsLackBLService = new GoodsLackBLServiceImpl();
        goodsOverflowBLService = new GoodsOverflowBLServiceImpl();
        presentBLService = new PresentBLServiceImpl();

        lackListBLService = new LackListBLServiceImpl();
        overflowListBLService = new OverflowListBLServiceImpl();
        presentBLService = new PresentBLServiceImpl();
        presentListBLService = new PresentListBLServiceImpl();
        goodsWarningMessageBLService = new GoodsWarningMessageBLServiceImpl();

        logBLService = new LogBLServiceImpl();

        adminBLService = new AdminBLServiceImpl();
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
    public ArrayList<GoodsVO> getCurrentGoods() throws RemoteException{
        return goodsBLService.getCurrentGoods();
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
    public ResultMessage addGoodsSaleReturn(GoodsVO vo, int saleReturnNumber, double price, String remark)
            throws RemoteException {
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
    public ResultMessage addGoodsStockReturn(GoodsVO vo, int stockReturnNumber, double price, String remark)
            throws RemoteException {
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
    public MemberVO findMember(int number)throws RemoteException {
        return memberBLService.findMember(number);
    }

    @Override
    public ArrayList<MemberVO> find(String memberClass, int level, String name, String managePerson)
            throws RemoteException {
        return memberBLService.find(memberClass, level, name, managePerson);
    }

    @Override
    public ArrayList<MemberVO> findMemberByName(String name) throws RemoteException {
        return memberBLService.findMemberByName(name);
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
    public ArrayList<GoodsSaleVO> checkSale(String startTime, String endTime, String goodsName,
                                            String userName, String memberName) throws RemoteException {
        return saleBLService.checkSale(startTime, endTime, goodsName, userName, memberName);
    }

    @Override
    public SaleVO addSaleRed(SaleVO vo) throws RemoteException {
        return saleBLService.addSaleRed(vo);
    }

    @Override
    public ArrayList<SaleVO> getSale(String startTime, String endTime, String userName, String memberName)
            throws RemoteException {
        return saleBLService.getSale(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<SaleVO> getSaleFail() throws RemoteException {
        return saleBLService.getSaleFail();
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
    public ArrayList<SaleReturnVO> getSaleReturn(String startTime, String endTime, String userName,
                                                 String memberName) throws RemoteException {
        return saleReturnBLService.getSaleReturn(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnFail() throws RemoteException {
        return saleReturnBLService.getSaleReturnFail();
    }

    @Override
    public SaleReturnVO addSaleReturnRed(SaleReturnVO vo) throws RemoteException {
        return saleReturnBLService.addSaleReturnRed(vo);
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
    public ArrayList<StockVO> getStock(String startTime, String endTime, String userName, String memberName) throws RemoteException {
        return stockBLService.getStock(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<StockVO> getStockFail() throws RemoteException {
        return stockBLService.getStockFail();
    }

    @Override
    public StockVO addStockRed(StockVO vo) throws RemoteException {
        return stockBLService.addStockRed(vo);
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
    public ArrayList<StockReturnVO> getStockReturn(String startTime, String endTime,
                                                   String userName, String memberName) throws RemoteException {
        return stockReturnBLService.getStockReturn(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<StockReturnVO> getStockReturnFail() throws RemoteException {
        return stockReturnBLService.getStockReturnFail();
    }

    @Override
    public StockReturnVO addStockReturnRed(StockReturnVO vo) throws RemoteException {
        return stockReturnBLService.addStockReturnRed(vo);
    }

    @Override
    public ResultMessage register(UserVO vo)throws RemoteException {
        return userBLService.register(vo);
    }

    @Override
    public ResultMessage check(String name, String password)throws RemoteException {
        return userBLService.check(name, password);
    }

    @Override
    public ResultMessage updatePassword(String name, String password, String type)throws RemoteException {
        return userBLService.updatePassword(name, password, type);
    }

    @Override
    public UserVO getUserVO(String name)throws RemoteException {
        return userBLService.getUserVO(name);
    }

    @Override
    public ResultMessage addGoodsLack(GoodsLackVO vo)throws RemoteException {
        return goodsLackBLService.addGoodsLack(vo);
    }

    @Override
    public ResultMessage deleteGoodsLack(GoodsLackVO vo)throws RemoteException {
        return goodsLackBLService.deleteGoodsLack(vo);
    }

    @Override
    public ResultMessage update(GoodsLackVO vo)throws RemoteException {
        return goodsLackBLService.update(vo);
    }

    @Override
    public ResultMessage addLackList(LackListVO vo)throws RemoteException {
        return lackListBLService.addLackList(vo);
    }

    @Override
    public ResultMessage deleteLackList(LackListVO vo)throws RemoteException {
        return lackListBLService.deleteLackList(vo);
    }

    @Override
    public ResultMessage update(LackListVO vo)throws RemoteException {
        return lackListBLService.update(vo);
    }

    @Override
    public ArrayList<LackListVO> getLackList(String startTime, String endTime, String userName)
            throws RemoteException {
        return lackListBLService.getLackList(startTime, endTime, userName);
    }

    @Override
    public LackListVO addLackListRed(LackListVO vo)throws RemoteException {
        return lackListBLService.addLackListRed(vo);
    }

    @Override
    public ArrayList<LackListVO> getAllLackList() throws RemoteException {
        return lackListBLService.getAllLackList();
    }

    @Override
    public ResultMessage addOverflowList(OverflowListVO vo)throws RemoteException {
        return overflowListBLService.addOverflowList(vo);
    }

    @Override
    public ResultMessage deleteOverlowList(OverflowListVO vo)throws RemoteException {
        return overflowListBLService.deleteOverlowList(vo);
    }

    @Override
    public ResultMessage updateOverflowList(OverflowListVO vo)throws RemoteException {
        return overflowListBLService.updateOverflowList(vo);
    }

    @Override
    public ArrayList<OverflowListVO> getOverflowList(String startTime, String endTime, String userName)
            throws RemoteException{
        return overflowListBLService.getOverflowList(startTime, endTime, userName);
    }

    @Override
    public OverflowListVO addOverflowListRed(OverflowListVO vo)throws RemoteException {
        return overflowListBLService.addOverflowListRed(vo);
    }

    @Override
    public ArrayList<OverflowListVO> getAllOverflowList() throws RemoteException {
        return overflowListBLService.getAllOverflowList();
    }

    @Override
    public ResultMessage addPresent(PresentVO vo)throws RemoteException {
        return presentBLService.addPresent(vo);
    }

    @Override
    public ResultMessage deletePresent(PresentVO vo)throws RemoteException {
        return presentBLService.deletePresent(vo);
    }

    @Override
    public ResultMessage updatePresent(PresentVO vo)throws RemoteException {
        return presentBLService.updatePresent(vo);
    }

    @Override
    public ResultMessage addPresentList(PresentListVO vo)throws RemoteException {
        return presentListBLService.addPresentList(vo);
    }

    @Override
    public ResultMessage deletePresentList(PresentListVO vo)throws RemoteException {
        return presentListBLService.deletePresentList(vo);
    }

    @Override
    public ResultMessage update(PresentListVO vo)throws RemoteException {
        return presentListBLService.update(vo);
    }

    @Override
    public ArrayList<PresentListVO> getPresentList(String startTime, String endTime, String userName,
                                                   String memberName) throws RemoteException {
        return presentListBLService.getPresentList(startTime, endTime, userName, memberName);
    }


    @Override
    public PresentListVO addPresentListRed(PresentListVO vo)throws RemoteException {
        return presentListBLService.addPresentListRed(vo);
    }

    @Override
    public ArrayList<PresentListVO> getAllPresentList() throws RemoteException {
        return presentListBLService.getAllPresentList();

    }

    @Override
    public ResultMessage addGoodsOverflow(GoodsOverflowVO vo)throws RemoteException {
        return goodsOverflowBLService.addGoodsOverflow(vo);
    }

    @Override
    public ResultMessage deleteGoodsOverflow(GoodsOverflowVO vo)throws RemoteException {
        return goodsOverflowBLService.deleteGoodsOverflow(vo);
    }

    @Override
    public ResultMessage update(GoodsOverflowVO vo)throws RemoteException {
        return goodsOverflowBLService.update(vo);
    }

    @Override
    public ArrayList<GoodsVO> getWarningMessage(int number) throws RemoteException{
        return goodsWarningMessageBLService.getWarningMessage(number);
    }

    @Override
    public ResultMessage addLog(UserVO vo, String operation, ResultMessage msg) {
        return logBLService.addLog(vo, operation, msg);
    }

    @Override
    public ResultMessage delete(LogVO vo) {
        return logBLService.delete(vo);
    }

    @Override
    public ResultMessage update(LogVO vo) {
        return logBLService.update(vo);
    }

    @Override
    public ArrayList<LogVO> getLog(UserVO vo) {
        return logBLService.getLog(vo);
    }

    @Override
    public ArrayList<LogVO> findByName(String name) {
        return logBLService.findByName(name);
    }

    @Override
    public ArrayList<LogVO> findByDate(String date) {
        return logBLService.findByDate(date);
    }

    @Override
    public ArrayList<LogVO> findByOperation(String operation) {
        return logBLService.findByOperation(operation);
    }

    @Override
    public ResultMessage addAdmin(AdminVO vo) throws RemoteException {
        return adminBLService.addAdmin(vo);
    }

    @Override
    public ResultMessage deleteAdmin(AdminVO vo) throws RemoteException {
        return adminBLService.deleteAdmin(vo);
    }

    @Override
    public ResultMessage updateAdmin(AdminVO vo) throws RemoteException {
        return adminBLService.updateAdmin(vo);
    }

    @Override
    public ArrayList<UserVO> getAllUsers() throws RemoteException {
        return adminBLService.getAllUsers();
    }

    @Override
    public ArrayList<UserVO> findByType(String type) throws RemoteException {
        return adminBLService.findByType(type);
    }

    @Override
    public ResultMessage addAdvancedUser(UserVO vo) throws RemoteException {
        return adminBLService.addAdvancedUser(vo);
    }

    @Override
    public ResultMessage deleteUser(UserVO vo) throws RemoteException {
        return adminBLService.deleteUser(vo);
    }
}
