package objects;

import po.*;
import vo.*;

import java.util.ArrayList;
import java.util.Set;

/**
 * 获得增加清单帮助的辅助类
 */
public class AddHelper {
    DateHelper dateHelper = new DateHelper();

    public StockVO getStockAddHelp(String provider, String remark, Set<GoodsStockVO> set){
        String operation = "from Stock";
        String postString = "JHD-" + dateHelper.getDate() + "-";
        StockVO vo = new StockVO();
        vo.setProvider(provider);
        vo.setRemark(remark);
        vo.setDate(dateHelper.getDate());
        vo.setStockSet(set);
        double totalPrice = 0.0;
        for(GoodsStockVO goodsStockVO: set){
            totalPrice += goodsStockVO.getTotalPrice();
        }
        vo.setTotalPrice(totalPrice);

        /**
         * 寻找上一次记录的单据
         */
        ArrayList<StockPO> list = (ArrayList<StockPO>)HQLTools.find(operation);
        int idx = list.size() - 1;
        /**
         * 如果没有记录，直接作为1号单据存储
         */
        if(idx == -1){
            vo.setReceiptNumber(1);
            vo.setNumber( postString + addZero("1"));
            return vo;
        }
        StockPO po = list.get(idx);
        String lastDate = po.getDate();
        /**
         * 如果单据是第二天，作为第一号单据， id = 1，否则id++
         */
        if(isNextDay(lastDate)){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero("1"));
            return vo;
        }
        else{
            int lastID = po.getReceiptNumber();
            int id = lastID + 1;
            vo.setReceiptNumber(id);
            vo.setDate(dateHelper.getDate());
            vo.setNumber(postString + addZero(id + ""));
            return vo;
        }
    }

    public StockReturnVO getStockReturnHelp(String provider, String remark, Set<GoodsStockReturnVO> set){
        String operation = "from Restock";
        String postString = "JHTHD-" + dateHelper.getDate() + "-";
        StockReturnVO vo = new StockReturnVO();
        vo.setProvider(provider);
        vo.setRemark(remark);
        vo.setDate(dateHelper.getDate());
        vo.setStockSet(set);

        double totalPrice = 0.0;
        for(GoodsStockReturnVO goodsStockReturnVO: set){
            totalPrice += goodsStockReturnVO.getTotalPrice();
        }
        vo.setTotalPrice(totalPrice);
        /**
         * 寻找上一次记录的单据
         */
        ArrayList<StockReturnPO> list = (ArrayList<StockReturnPO>)HQLTools.find(operation);
        int idx = list.size() - 1;
        /**
         * 如果没有记录，直接作为1号单据存储
         */
        if(idx == -1){
            vo.setReceiptNumber(1);
            vo.setNumber( postString + addZero("1"));
            return vo;
        }
        StockReturnPO po = list.get(idx);
        String lastDate = po.getDate();
        /**
         * 如果单据是第二天，作为第一号单据， id = 1，否则id++
         */
        if(isNextDay(lastDate)){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero("1"));
            return vo;
        }
        else{
            int lastID = po.getReceiptNumber();
            int id = lastID + 1;
            vo.setDate(dateHelper.getDate());
            vo.setReceiptNumber(id);
            vo.setNumber(postString + addZero(id + ""));
            return vo;
        }
    }

    public SaleVO getSaleAddHelp(String retailer, String salesman, String operator,
                                 double discount, double voucher, String remark, Set<GoodsSaleVO> set){
        String operation = "from Sale";
        String postString = "XSD-" + dateHelper.getDate() + "-";
        SaleVO vo = new SaleVO();
        vo.setDate(dateHelper.getDate());
        vo.setRetailer(retailer);
        vo.setSalesman(salesman);
        vo.setOperator(operator);
        vo.setDiscount(discount);
        vo.setVoucher(voucher);
        vo.setRemark(remark);
        vo.setSaleSet(set);

        double totalPrice = 0.0;
        for(GoodsSaleVO goodsSaleVO : set){
            totalPrice += goodsSaleVO.getTotalPrice();
        }
        vo.setTotalPrice(totalPrice);

        double payPrice = totalPrice - discount - voucher;
        vo.setPayPrice(payPrice);

        ArrayList<SalePO> list = (ArrayList<SalePO>)HQLTools.find(operation);
        int idx = list.size() - 1;
        if(idx == -1){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero("1"));
            return vo;
        }
        SalePO po = list.get(idx);
        String lastDate = po.getDate();
        if(isNextDay(lastDate)){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero("1"));
            return vo;
        }
        else{
            int lastID = po.getReceiptNumber();
            int id = lastID + 1;
            vo.setReceiptNumber(id);
            vo.setNumber(postString + addZero(id + ""));
            return vo;
        }
    }

    public SaleReturnVO getSaleReturnHelp(String retailer, String salesman,
                                String operator, String remark, Set<GoodsSaleReturnVO> set){
        String operation = "from SaleReturn";
        String postString = "XSTHD-" + dateHelper.getDate() + "-";
        SaleReturnVO vo = new SaleReturnVO();
        vo.setRetailer(retailer);
        vo.setSalesman(salesman);
        vo.setOperator(operator);
        vo.setRemark(remark);
        vo.setSaleReturnSet(set);
        vo.setDate(dateHelper.getDate());

        double payPrice = 0.0;
        for(GoodsSaleReturnVO goodsSaleReturnVO : set){
            payPrice += goodsSaleReturnVO.getPrice();
        }
        vo.setPayPrice(payPrice);

        ArrayList<SaleReturnPO> list = (ArrayList<SaleReturnPO>)HQLTools.find(operation);
        int idx = list.size() - 1;
        if(idx == -1){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero("1"));
            return vo;
        }
        if(isNextDay(dateHelper.getDate())){
            vo.setReceiptNumber(1);
            vo.setNumber(postString + addZero(1 + ""));
            return vo;
        }
        int lastID = list.get(idx).getReceiptNumber();
        int id = lastID + 1;
        vo.setReceiptNumber(id);
        vo.setNumber(postString + addZero(id + ""));
        return vo;
    }

    public boolean isNextDay(String lastDate){
        String currentDate = dateHelper.getDate();
        return !(dateHelper.isSameDay(lastDate, currentDate));
    }

    public String addZero(String num){
        while (num.length() < 5)
            num = "0" + num;
        return num;
    }
}
