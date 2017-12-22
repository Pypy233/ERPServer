package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity (name = "GoodsLack")
public class GoodsLackPO  implements Serializable{
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

    public GoodsLackPO() {
    }

    public GoodsLackPO(int id, GoodsPO po, int trueNumber) {
        this.id = id;
        this.po = po;
        this.trueNumber = trueNumber;
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

    public int getTrueNumber() {
        return trueNumber;
    }

    public void setTrueNumber(int trueNumber) {
        this.trueNumber = trueNumber;
    }
}
