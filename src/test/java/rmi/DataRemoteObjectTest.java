package rmi;

import org.junit.Test;
import po.GoodsPO;
import vo.GoodsVO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataRemoteObjectTest {

    @Test
    public void findGoods() throws Exception {
        DataRemoteObject dataRemoteObject = new DataRemoteObject();
        ArrayList<GoodsVO> list = dataRemoteObject.findGoods("1", "" , "");

        assertEquals(1, list.size());
        assertEquals("s", list.get(0).getName());
        assertEquals("x", list.get(0).getType());
        assertEquals(1, list.get(0).getCommodityNum());

        ArrayList<GoodsVO> list1 = dataRemoteObject.findGoods("", "台", "");

            //ffffffuck

        assertEquals(3, list.size());
        System.out.println(list1.get(0).getName());

    }

}