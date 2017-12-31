package test.datatest;

import objects.ResultMessage;
import org.junit.Test;
import po.LogPO;
import service.dataservice.Impl.LogDataServiceImpl;
import service.dataservice.LogDataService;
import sun.rmi.runtime.Log;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LogDataServiceImplTest {
    /**
    LogDataService logDataService = new LogDataServiceImpl();

    @Test
    public void add() throws Exception {
        LogPO po = new LogPO();
        po.setResult("成功");
        po.setOperation("删除商品");
        po.setName("py");
        po.setDate("2017-12-28");
        ResultMessage msg = logDataService.add(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void delete() throws Exception {
        LogPO po = new LogPO();
        po.setId(1);
        po.setResult("成功");
        po.setOperation("删除商品");
        po.setName("py");
        po.setDate("2017-12-28");
        ResultMessage msg = logDataService.delete(po);
        assertEquals(ResultMessage.Success, msg);

    }

    @Test
    public void update() throws Exception {
        LogPO po = new LogPO();
        po.setResult("失败");
        po.setId(1);
        po.setOperation("删除商品");
        po.setName("py");
        po.setDate("2017-12-28");
        ResultMessage msg = logDataService.update(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void findByName() throws Exception {
        ArrayList<LogPO> list = logDataService.findByName("py");
        LogPO po = list.get(0);
        assertEquals(1, list.size());
        assertEquals("失败", po.getResult());
        assertEquals("2017-12-28", po.getDate());
        assertEquals("删除商品", po.getOperation());
    }

    @Test
    public void findByDate() throws Exception {
        ArrayList<LogPO> list = logDataService.findByDate("2017-12-28");
        assertEquals(2, list.size());
    }

    @Test
    public void findByOperation() throws Exception {
        ArrayList<LogPO> list = logDataService.findByOperation("删除商品");
        assertEquals(2, list.size());
    }**/

}