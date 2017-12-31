package po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by py on 2017/10/20.
 * 进货单数据类
 */
@Entity(name = "Stock")
public class StockPO implements Serializable {
    /**
     * 单据编号
     */
    String number;

    /**
     * 当天日期
     */
    String date;

    /**
     * 当天单据号码
     */

    int receiptNumber;

    /**
     * 供应商
     */
    String provider;

    /**
     * 仓库
     */
    int commodityNumber;

    /**
     * 操作员
     */
    String operator;

    /**
     * 入库商品
     */
    Set<GoodsStockPO> stockSet = new HashSet<>();

    /**
     * 备注
     */
    String remark;

    /**
     * 总额
     */
    double totalPrice;

    /**
     * 单据状态
     */
    String state;

    public StockPO() {
    }

    /**
     *
     * @param number
     * @param date
     * @param receiptNumber
     * @param provider
     * @param commodityNumber
     * @param operator
     * @param stockSet
     * @param remark
     * @param totalPrice
     */
    public StockPO(String number, String date, int receiptNumber, String provider, int commodityNumber,
                   String operator, Set<GoodsStockPO> stockSet, String remark, double totalPrice) {
        this.number = number;
        this.date = date;
        this.receiptNumber = receiptNumber;
        this.provider = provider;
        this.commodityNumber = commodityNumber;
        this.operator = operator;
        this.stockSet = stockSet;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public StockPO(String provider, int commodityNumber, String operator, Set<GoodsStockPO> stockSet,
                   String remark, double totalPrice) {
        this.provider = provider;
        this.commodityNumber = commodityNumber;
        this.operator = operator;
        this.stockSet = stockSet;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public StockPO(String number, String date, int receiptNumber, String provider,
                   int commodityNumber, String operator, Set<GoodsStockPO> stockSet,
                   String remark, double totalPrice, String state) {
        this.number = number;
        this.date = date;
        this.receiptNumber = receiptNumber;
        this.provider = provider;
        this.commodityNumber = commodityNumber;
        this.operator = operator;
        this.stockSet = stockSet;
        this.remark = remark;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    @Id
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<GoodsStockPO> getStockSet() {
        return stockSet;
    }

    public void setStockSet(Set<GoodsStockPO> stockSet) {
        this.stockSet = stockSet;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}