package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 封装了一个商品进货的类，包括商品编号和商品，备注和总价
 */
@Entity(name = "GoodsStock")
public class GoodsStockPO implements Serializable{
    /**
     * id
     */
    public int id;
    /**
     * 对应进货的商品类
     */
    public GoodsPO po;

    /**
     * 对应进货的商品数量
     */

    public int stockNumber;

    /**
     * 备注
     */
    String remark;

    /**
     * 总额合计
     */
    double totalPrice;


    public GoodsStockPO() {
    }

    public GoodsStockPO(GoodsPO po, int stockNumber, String remark, double totalPrice) {
        this.po = po;
        this.stockNumber = stockNumber;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public GoodsStockPO(int id, GoodsPO po, int stockNumber, String remark, double totalPrice) {
        this.id = id;
        this.po = po;
        this.stockNumber = stockNumber;
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

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
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
