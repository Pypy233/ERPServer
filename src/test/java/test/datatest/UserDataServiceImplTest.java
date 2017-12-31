package test.datatest;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import objects.ResultMessage;
import org.junit.Test;
import po.UserPO;
import service.dataservice.Impl.UserDataServiceImpl;
import service.dataservice.UserDataService;

import static org.junit.Assert.*;

public class UserDataServiceImplTest {
    /**
    UserDataService userDataService = new UserDataServiceImpl();
    UserPO userPO = new UserPO("总经理", "py", "12", false);
    UserPO userPO1 = new UserPO("总经理", "py", "121212", false);
    @Test
    public void add() throws Exception {
        ResultMessage msg = userDataService.add(userPO);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void delete() throws Exception {
        ResultMessage msg = userDataService.delete(userPO);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void update() throws Exception {
        ResultMessage msg = userDataService.update(userPO1);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void find() throws Exception {
        UserPO po = userDataService.find("py");
        assertEquals("总经理", po.getType());
        assertEquals("121212", po.getPassword());
    }
**/
}