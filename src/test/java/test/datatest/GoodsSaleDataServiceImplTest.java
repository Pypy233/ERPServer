package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.GoodsPO;
import po.GoodsSalePO;
import service.dataservice.GoodsSaleDataService;
import service.dataservice.Impl.GoodsSaleDataServiceImpl;

import static org.junit.Assert.*;

public class GoodsSaleDataServiceImplTest {
/**
    GoodsSaleDataService goodsSaleDataService = new GoodsSaleDataServiceImpl();
    GoodsPO po = new GoodsPO( "长管台灯", "Lamp-LP",
            200, 15, 100, 18, 200);
    GoodsPO po1 = new GoodsPO( "短管台灯", "Lamp-SP",
            200, 15, 100, 18, 200);


    @Test
    public void add() throws Exception {
        GoodsSalePO goodsSalePO = new GoodsSalePO(1, po, 100, 200, "没有", 20000);
        ResultMessage msg = goodsSaleDataService.add(goodsSalePO);
        assertEquals(ResultMessage.Success, msg);

        GoodsSalePO goodsSalePO1 = new GoodsSalePO(2, po1, 100, 200, "无" , 20000);
        ResultMessage msg1 = goodsSaleDataService.add(goodsSalePO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void delete() throws Exception {
        GoodsSalePO goodsSalePO = new GoodsSalePO(1, po, 100, 200, "没有", 20000);
        ResultMessage msg = goodsSaleDataService.delete(goodsSalePO);
        assertEquals(ResultMessage.Success, msg);

        GoodsSalePO goodsSalePO1 = new GoodsSalePO(2, po1, 100, 200, "无" , 20000);
        ResultMessage msg1 = goodsSaleDataService.delete(goodsSalePO1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void update() throws Exception {
        GoodsSalePO goodsSalePO = new GoodsSalePO(1, po, 100, 200, "修改备注", 20000);
        ResultMessage msg = goodsSaleDataService.update(goodsSalePO);
        assertEquals(ResultMessage.Success, msg);

        GoodsSalePO goodsSalePO1 = new GoodsSalePO(2, po1, 100, 200, "修改备注" , 20000);
        ResultMessage msg1 = goodsSaleDataService.update(goodsSalePO1);
        assertEquals(ResultMessage.Success, msg1);

    }**/

}