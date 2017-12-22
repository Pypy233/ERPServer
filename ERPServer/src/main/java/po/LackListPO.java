package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LackListPO implements Serializable {
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

    public Set<GoodsLackPO> set = new HashSet<>();


    public LackListPO() {
    }

    public LackListPO(int id, String date, String operator, Set<GoodsLackPO> set) {
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
    public Set<GoodsLackPO> getSet() {
        return set;
    }

    public void setSet(Set<GoodsLackPO> set) {
        this.set = set;
    }
}
