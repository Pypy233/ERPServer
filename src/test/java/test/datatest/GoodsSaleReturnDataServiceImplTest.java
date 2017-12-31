package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.GoodsPO;
import po.GoodsSaleReturnPO;
import service.dataservice.GoodsSaleReturnDataService;
import service.dataservice.Impl.GoodsSaleReturnDataServiceImpl;

import static org.junit.Assert.*;

public class GoodsSaleReturnDataServiceImplTest {
    /**
    GoodsSaleReturnDataService goodsSaleReturnDataService = new GoodsSaleReturnDataServiceImpl();
    GoodsPO po = new GoodsPO( "长管台灯", "Lamp-LP",
            200, 15, 100, 18, 200);
    GoodsPO po1 = new GoodsPO( "短管台灯", "Lamp-SP",
            200, 15, 100, 18, 200);
    GoodsSaleReturnPO goodsSaleReturnPO = new GoodsSaleReturnPO(po, 200, 100,
            "无", 20000);
    GoodsSaleReturnPO goodsSaleReturnPO1 = new GoodsSaleReturnPO(po1, 200,
            100, "无", 20000);
    @Test
    public void add() throws Exception {
        ResultMessage msg = goodsSaleReturnDataService.add(goodsSaleReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsSaleReturnDataService.add(goodsSaleReturnPO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void delete() throws Exception {
        GoodsSaleReturnPO goodsSaleReturnPO = new GoodsSaleReturnPO(1, po, 200, 100,
                "无", 20000);
        GoodsSaleReturnPO goodsSaleReturnPO1 = new GoodsSaleReturnPO(2, po1, 200,
                100, "无", 20000);
        ResultMessage msg = goodsSaleReturnDataService.delete(goodsSaleReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsSaleReturnDataService.delete(goodsSaleReturnPO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void update() throws Exception {
        GoodsSaleReturnPO goodsSaleReturnPO = new GoodsSaleReturnPO(1, po, 200, 100,
                "修改备注", 20000);
        GoodsSaleReturnPO goodsSaleReturnPO1 = new GoodsSaleReturnPO(2, po1, 200,
                100, "修改备注", 20000);
        ResultMessage msg = goodsSaleReturnDataService.update(goodsSaleReturnPO);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = goodsSaleReturnDataService.update(goodsSaleReturnPO1);
        assertEquals(ResultMessage.Success, msg1);
    }
**/

}