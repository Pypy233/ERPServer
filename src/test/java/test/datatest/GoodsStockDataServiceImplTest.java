package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.GoodsPO;
import po.GoodsStockPO;
import service.dataservice.GoodsStockDataService;
import service.dataservice.Impl.GoodsStockDataServiceImpl;

import static org.junit.Assert.*;

public class GoodsStockDataServiceImplTest {

    GoodsStockDataService goodsStockDataService = new GoodsStockDataServiceImpl();
    GoodsPO po = new GoodsPO( "长管台灯", "Lamp-LP",
            200, 15, 100, 18, 200);
    GoodsPO po1 = new GoodsPO( "短管台灯", "Lamp-SP",
            200, 15, 100, 18, 200);
    GoodsStockPO goodsStockPO = new GoodsStockPO( po, 200, "无", 20000);
    GoodsStockPO goodsStockPO1 = new GoodsStockPO(po1, 200, "无", 20000);
    @Test
    public void add() throws Exception {

        ResultMessage msg = goodsStockDataService.add(goodsStockPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsStockDataService.add(goodsStockPO1);
        assertEquals(ResultMessage.Success, msg1);
    }

    @Test
    public void delete() throws Exception {
        GoodsStockPO goodsStockPO = new GoodsStockPO(1, po, 200, "无", 20000);
        GoodsStockPO goodsStockPO1 = new GoodsStockPO(2, po1, 200, "无", 20000);
        ResultMessage msg = goodsStockDataService.delete(goodsStockPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsStockDataService.delete(goodsStockPO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void update() throws Exception {
        GoodsStockPO goodsStockPO = new GoodsStockPO(1, po, 200, "修改备注", 20000);
        ResultMessage msg = goodsStockDataService.update(goodsStockPO);
        assertEquals(ResultMessage.Success, msg);

        GoodsStockPO goodsStockPO1 = new GoodsStockPO(2, po1, 200, "修改备注", 20000);
        ResultMessage msg1 = goodsStockDataService.update(goodsStockPO1);
        assertEquals(ResultMessage.Success, msg1);

    }



}