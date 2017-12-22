package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 封装了一个商品进货退货的类，包括商品编号和商品，备注和总金额
 */
@Entity(name = "GoodsStockReturn")
public class GoodsStockReturnPO implements Serializable {
    /**
     * id
     */
    public int id;


    /**
     * 对应进货退货的商品
     */
    public GoodsPO po;

    /**
     * 对应进货退货的商品数量
     */
    public int stockReturnNumber;

    /**
     * 备注
     */
    String remark;

    /**
     * 总额
     */
    double totalPrice;

    public GoodsStockReturnPO() {
    }

    public GoodsStockReturnPO(int id, GoodsPO po, int stockReturnNumber, String remark, double totalPrice) {
        this.id = id;
        this.po = po;
        this.stockReturnNumber = stockReturnNumber;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public GoodsStockReturnPO(GoodsPO po, int stockReturnNumber, String remark, double totalPrice) {
        this.po = po;
        this.stockReturnNumber = stockReturnNumber;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public GoodsPO getPo() {
        return po;
    }

    public void setPo(GoodsPO po) {
        this.po = po;
    }

    public int getStockReturnNumber() {
        return stockReturnNumber;
    }

    public void setStockReturnNumber(int stockReturnNumber) {
        this.stockReturnNumber = stockReturnNumber;
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
}
