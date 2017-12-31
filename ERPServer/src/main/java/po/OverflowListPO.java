package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 报溢单
 */
@Entity(name = "OverflowList")
public class OverflowListPO implements Serializable {

    /**
     * id
     */
    public int id;

    /**
     * 日期
     */
    public String date;

    /**
     *操作人员
     */
    public String operator;

    /**
     *
     */
    public Set<GoodsOverflowPO> set;

    public OverflowListPO() {
    }

    public OverflowListPO(int id, String date, String operator, Set<GoodsOverflowPO> set) {
        this.id = id;
        this.date = date;
        this.operator = operator;
        this.set = set;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<GoodsOverflowPO> getSet() {
        return set;
    }

    public void setSet(Set<GoodsOverflowPO> set) {
        this.set = set;
    }
}
