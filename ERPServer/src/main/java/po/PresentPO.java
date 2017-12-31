package po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Entity (name = "Present")
public class PresentPO implements Serializable {
    /**
     * id
     */
    public int id;
    /**
     * 赠送商品数量
     */
    public int number;

    /**
     * 赠送商品
     */
    public GoodsPO po;

    public PresentPO() {
    }

    public PresentPO(int id, int number, GoodsPO po) {
        this.id = id;
        this.number = number;
        this.po = po;
    }
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @OneToOne(cascade = CascadeType.ALL)
    public GoodsPO getPo() {
        return po;
    }

    public void setPo(GoodsPO po) {
        this.po = po;
    }
}
