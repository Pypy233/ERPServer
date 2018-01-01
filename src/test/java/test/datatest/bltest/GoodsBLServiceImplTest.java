package test.datatest.bltest;

import org.junit.Test;
import service.blservice.GoodsBLService;
import service.blservice.Impl.GoodsBLServiceImpl;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoodsBLServiceImplTest {
    GoodsBLService goodsBLService = new GoodsBLServiceImpl();

    @Test
    public void addGoods() throws Exception {
    }

    @Test
    public void deleteGoods() throws Exception {
    }

    @Test
    public void updateGoods() throws Exception {
    }

    @Test
    public void findGoods() throws Exception {
        ArrayList list = goodsBLService.findGoods("", "", "台");
        assertEquals(3, list.size());
    }

    @Test
    public void getCurrentGoods() throws Exception {
    }

}