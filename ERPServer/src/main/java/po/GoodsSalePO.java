package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 封装了一个商品销售的类，包括商品编号，商品，商品售出价格，备注和总价格
 */
@Entity(name = "GoodsSale")

public class GoodsSalePO implements Serializable {
    /**
     * id
     */
    public int id;


    /**
     * 对应售出的商品
     */
    public GoodsPO po;

    /**
     * 对应售出的商品数量
     */
    public int saleNumber;

    /**
     * 对应售出商品价格
     */
    public double price;

    /**
     * 备注
     */
    String remark;

    /**
     * 总额
     */
    double totalPrice = price * saleNumber;

    public GoodsSalePO() {
    }

    public GoodsSalePO(int id, GoodsPO po, int saleNumber, double price, String remark) {
        this.id = id;
        this.po = po;
        this.saleNumber = saleNumber;
        this.price = price;
        this.remark = remark;
    }

    public GoodsSalePO(int id, GoodsPO po, int saleNumber, double price, String remark, double totalPrice) {
        this.id = id;
        this.po = po;
        this.saleNumber = saleNumber;
        this.price = price;
        this.remark = remark;
        this.totalPrice = totalPrice;
    }

    public GoodsSalePO(GoodsPO po, int saleNumber, double price, String remark, double totalPrice) {
        this.po = po;
        this.saleNumber = saleNumber;
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

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
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
