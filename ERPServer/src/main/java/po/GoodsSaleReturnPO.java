package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 封装了一个商品销售退货的类，包括商品编号和商品，总金额和备注
 */
@Entity(name = "GoodsSaleReturn")
public class GoodsSaleReturnPO implements Serializable {
    /**
     * id
     */
    private int id;

    /**
     * 对应销售退货的商品
     */
    private GoodsPO po;

    /**
     * 对应销售退货的商品数量
     */
    private int saleReturnNumber;

    /**
     * 对应销售退货商品价格
     */
    public double price;

    /**
     * 备注
     */
    String remark;

    /**
     * 总额
     */
    double totalPrice = price * saleReturnNumber;

    public GoodsSaleReturnPO() {
    }

    public GoodsSaleReturnPO(int id, GoodsPO po, int saleReturnNumber, double price, String remark, double totalPrice) {
        this.id = id;
        this.po = po;
        this.saleReturnNumber = saleReturnNumber;
        this.price = price;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public GoodsSaleReturnPO(GoodsPO po, int saleReturnNumber, double price, String remark, double totalPrice) {
        this.po = po;
        this.saleReturnNumber = saleReturnNumber;
        this.price = price;
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

    public int getSaleReturnNumber() {
        return saleReturnNumber;
    }

    public void setSaleReturnNumber(int saleReturnNumber) {
        this.saleReturnNumber = saleReturnNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
