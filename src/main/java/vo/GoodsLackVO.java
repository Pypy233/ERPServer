package vo;

import java.io.Serializable;

public class GoodsLackVO implements Serializable {
    /**
     * id
     */
    public int id;

    /**
     * 溢出的商品
     */
    public GoodsVO vo;

    /**
     * 商品的真实数量
     */
    public int trueNumber;

    public GoodsLackVO() {
    }

    public GoodsLackVO(int id, GoodsVO vo, int trueNumber) {
        this.id = id;
        this.vo = vo;
        this.trueNumber = trueNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GoodsVO getVo() {
        return vo;
    }

    public void setVo(GoodsVO vo) {
        this.vo = vo;
    }

    public int getTrueNumber() {
        return trueNumber;
    }

    public void setTrueNumber(int trueNumber) {
        this.trueNumber = trueNumber;
    }
}
