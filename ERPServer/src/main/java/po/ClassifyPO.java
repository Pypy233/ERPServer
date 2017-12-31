package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by py on 2017/10/19.
 * 商品分类的类
 */
@Entity(name = "Classify")
public class ClassifyPO implements Serializable {
    /**
     * 分类id
     */
    public int id;

    /**
     * 分类名称
     */
    public String name;

    /**
     * 分类下的商品
     */

    public Set<GoodsPO> goodsSet = new HashSet<GoodsPO>();

    public ClassifyPO() {
    }

    public ClassifyPO(String name, Set<GoodsPO> goodsSet) {
        this.name = name;
        this.goodsSet = goodsSet;
    }

    public ClassifyPO(int id, String name, Set<GoodsPO> goodsSet) {
        this.id = id;
        this.name = name;
        this.goodsSet = goodsSet;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<GoodsPO> getGoodsSet() {
        return goodsSet;
    }
    public void setGoodsSet(Set<GoodsPO> goodsSet) {
        this.goodsSet = goodsSet;
    }
}