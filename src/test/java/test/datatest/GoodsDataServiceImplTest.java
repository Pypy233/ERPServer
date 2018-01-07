package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.GoodsPO;
import service.dataservice.Impl.GoodsDataServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoodsDataServiceImplTest {
    GoodsDataServiceImpl goodsDataServiceImpl = new GoodsDataServiceImpl();

    @Test
    public void add() throws Exception {

        GoodsPO po = new GoodsPO( "长管台灯", "Lamp-LP",
                200, 15, 100, 18, 200);
        ResultMessage msg = goodsDataServiceImpl.add(po);
        assertEquals(msg, ResultMessage.Success);

        GoodsPO po1 = new GoodsPO( "短管台灯", "Lamp-SP",
                200, 15, 100, 18, 200);
        ResultMessage msg1 = goodsDataServiceImpl.add(po1);


        GoodsPO po2 = new GoodsPO("大台灯", "Lamp-L",
                100, 20, 100, 18, 100);
        ResultMessage msg2 = goodsDataServiceImpl.add(po2);

        assertEquals(msg, ResultMessage.Success);
        assertEquals(msg1, ResultMessage.Success);
        assertEquals(msg2, ResultMessage.Success);


        GoodsPO po3 = new GoodsPO("s", "x",1, 1,
            1, 1,1);
        ResultMessage message = goodsDataServiceImpl.add(po3);
        assertEquals(ResultMessage.Success, message);
    }

    @Test
    public void delete() throws Exception {

        GoodsPO po1 = new GoodsPO(7, "", "demo",
                200, 15, 100, 18, 200);
        GoodsPO po2 = new GoodsPO(9, "demo", "demo",
                200, 15, 100, 18, 200);
        ResultMessage msg = goodsDataServiceImpl.delete(po1);
        ResultMessage msg1 = goodsDataServiceImpl.delete(po2);

        assertEquals(ResultMessage.Fail, msg);
        assertEquals(ResultMessage.Fail, msg1);


        GoodsPO po3 = new GoodsPO(1,  "长管台灯", "Lamp-LP",
                200, 15, 100, 18, 200);
        ResultMessage msg3 = goodsDataServiceImpl.delete(po3);
        assertEquals(ResultMessage.Success, msg3);

        GoodsPO po4 = new GoodsPO( 2, "短管台灯", "Lamp-SP",
                200, 15, 100, 18, 200);
        ResultMessage msg4 = goodsDataServiceImpl.delete(po4);

        GoodsPO po5 = new GoodsPO(3, "大台灯", "Lamp-L",
                100, 20, 100, 18, 100);
        ResultMessage msg5 = goodsDataServiceImpl.delete(po5);

        assertEquals(ResultMessage.Success, msg3);
        assertEquals(ResultMessage.Success, msg4);
        assertEquals(ResultMessage.Success, msg5);
    }

    @Test
    public void update() throws Exception {

           GoodsPO po = new GoodsPO( 1, "短管台灯", "Lamp-SP",
           200, 15, 100, 18, 200);
          ResultMessage msg = goodsDataServiceImpl.update(po);
        assertEquals(ResultMessage.Success, msg);

        GoodsPO po1 = new GoodsPO( 1, "长管台灯", "Lamp-LP",
                200, 15, 100, 18, 200);
        ResultMessage msg1 = goodsDataServiceImpl.update(po1);
        assertEquals(ResultMessage.Success, msg);

        GoodsPO po2 = new GoodsPO(7, "不存在的台灯", "Lamp-NonExist",
                200, 15, 100, 18, 200);

        ResultMessage msg2 = goodsDataServiceImpl.update(po2);
        assertEquals(ResultMessage.Fail, msg1);
    }

    //@Test
    public void retrive() throws Exception {
    }

    @Test
    public void find() throws Exception {
        /**
         * 测试根据编号准确查找
         */

        String str = "1 长管台灯 台灯 200 15.0 100.0 18.0 200.0";
        ArrayList list = goodsDataServiceImpl.find("0001" ,"","");
        ArrayList list1 = goodsDataServiceImpl.find("", "长", "");
        ArrayList list2 = goodsDataServiceImpl.find("", "", "台灯");

        GoodsPO po = (GoodsPO)list.get(0);

        String str1 = po.getNumber() + " " + po.getName() + " " + po.getType() +" "+ po.getCommodityNum() + " " +
                po.getPurchasePrice() + " " + po.getRetailPrice() + " " + po.getRecentPurPrice()+ " " +
                po.getRecentRetPrice();
        assertEquals(str, str1);


        GoodsPO po1 = (GoodsPO)list.get(0);

        String str2 = po1.getNumber() + " " + po1.getName() + " " + po1.getType() +" "+ po1.getCommodityNum() + " " +
                po1.getPurchasePrice() + " " + po1.getRetailPrice() + " " + po1.getRecentPurPrice()+ " " +
                po1.getRecentRetPrice();
        assertEquals(str2, str1);


        /**
         * 测试根据名称和型号模糊查找
         */

        GoodsPO po2 = (GoodsPO) list1.get(0);
        assertEquals(1, list1.size());
        assertEquals("长管台灯", po.getName());
        assertEquals("台灯" +
                "", po.getType());
        assertEquals(200, po.getCommodityNum());

        assertEquals(3, list2.size());

    }

}