package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.ClassifyPO;
import po.GoodsPO;
import service.dataservice.ClassifyDataService;
import service.dataservice.Impl.ClassifyDataServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ClassifyDataServiceImplTest {
    ClassifyDataService classifyDataService = new ClassifyDataServiceImpl();
/**
    @Test
    public void add() throws Exception {
        GoodsPO po2 = new GoodsPO( "大台灯", "Lamp-L",
                100, 20, 100, 18, 100);
        Set<GoodsPO> set = new HashSet<>();
        ClassifyPO po = new ClassifyPO("台灯", set);
        set.add(po2);
        ResultMessage msg = classifyDataService.add(po);
        assertEquals(ResultMessage.Success, msg);

        ClassifyPO po1 = new ClassifyPO( "聚光灯", null);
        ResultMessage msg1 = classifyDataService.add(po1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void add1() throws Exception {
        ClassifyPO po = new ClassifyPO("不能添加的灯", null);
        Set<GoodsPO> set = new HashSet<>();
        GoodsPO po2 = new GoodsPO(1, "大镁光灯灯", "Flash-L",
                100, 20, 100, 18, 100);
        set.add(po2);
        ClassifyPO po3 = new ClassifyPO("镁光灯", set);
        ResultMessage msg = classifyDataService.add(po3, po);
        assertEquals(ResultMessage.Fail, msg);


    }

    @Test
    public void delete() throws Exception {
        ClassifyPO po = new ClassifyPO(1,"台灯", null);
        ResultMessage msg = classifyDataService.delete(po);
        assertEquals(ResultMessage.Success, msg);
        ClassifyPO po1 = new ClassifyPO( 2, "聚光灯", null);
        ResultMessage msg1 = classifyDataService.delete(po1);
        assertEquals(ResultMessage.Success, msg1);

    }

    @Test
    public void update() throws Exception {
        Set<GoodsPO> set = new HashSet<>();
        GoodsPO po2 = new GoodsPO(1, "大镁光灯", "Flash-L",
                100, 20, 100, 18, 100);
        set.add(po2);
        ClassifyPO po1 = new ClassifyPO(1, "台灯", set);
        ResultMessage msg = classifyDataService.update(po1);
        assertEquals(ResultMessage.Success, msg);

    }

    @Test
    public void contains() throws Exception {
    }
**/
}