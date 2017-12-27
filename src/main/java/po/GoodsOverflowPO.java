package po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * 库存溢出的商品类
 */
@Entity (name = "GoodsOverflow")
public class GoodsOverflowPO implements Serializable{
    /**
     * id
     */
    public int id;

    /**
     * 溢出的商品
     */
    public GoodsPO po;

    /**
     * 商品的真实数量
     */
    public int trueNumber;

    public GoodsOverflowPO() {
    }

    public GoodsOverflowPO(int id, GoodsPO po, int trueNumber) {
        this.id = id;
        this.po = po;
        this.trueNumber = trueNumber;
    }

    @Id
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

    public int getTrueNumber() {
        return trueNumber;
    }

    public void setTrueNumber(int trueNumber) {
        this.trueNumber = trueNumber;
    }
}
