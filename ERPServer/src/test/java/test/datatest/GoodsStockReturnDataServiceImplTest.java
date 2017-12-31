package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.GoodsPO;
import po.GoodsStockReturnPO;
import service.dataservice.GoodsStockReturnDataService;
import service.dataservice.Impl.GoodsStockReturnDataServiceImpl;

import static org.junit.Assert.*;

public class GoodsStockReturnDataServiceImplTest {
    /**
    GoodsStockReturnDataService goodsStockReturnDataService = new GoodsStockReturnDataServiceImpl();
    GoodsPO po = new GoodsPO("长管台灯", "Lamp-LP",
            200, 15, 100, 18, 200);
    GoodsPO po1 = new GoodsPO("短管台灯", "Lamp-SP",
            200, 15, 100, 18, 200);
    GoodsStockReturnPO goodsStockReturnPO = new GoodsStockReturnPO(po, 200,
            "无", 2000);
    GoodsStockReturnPO getGoodsStockReturnPO1 = new GoodsStockReturnPO(po1, 200,
            "无", 2000);

    @Test
    public void add() throws Exception {
        ResultMessage msg = goodsStockReturnDataService.add(goodsStockReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsStockReturnDataService.add(getGoodsStockReturnPO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void delete() throws Exception{
        GoodsStockReturnPO goodsStockReturnPO = new GoodsStockReturnPO(1, po, 200,
                "无", 2000);
        GoodsStockReturnPO getGoodsStockReturnPO1 = new GoodsStockReturnPO(2, po1, 200,
                "无", 2000);
        ResultMessage msg = goodsStockReturnDataService.delete(goodsStockReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsStockReturnDataService.delete(getGoodsStockReturnPO1);
        assertEquals(ResultMessage.Success, msg1);
    }

    @Test
    public void update() throws Exception {
        GoodsStockReturnPO goodsStockReturnPO = new GoodsStockReturnPO(1, po, 200,
                "修改备注", 2000);
        GoodsStockReturnPO getGoodsStockReturnPO1 = new GoodsStockReturnPO(2, po1, 200,
                "修改备注", 2000);

        ResultMessage msg = goodsStockReturnDataService.update(goodsStockReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsStockReturnDataService.update(getGoodsStockReturnPO1);
        assertEquals(ResultMessage.Success, msg1);
    }
**/
}