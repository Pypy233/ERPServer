package test.datatest;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import objects.ResultMessage;
import org.junit.Test;
import po.UserPO;
import service.dataservice.Impl.UserDataServiceImpl;
import service.dataservice.UserDataService;

import static org.junit.Assert.*;

public class UserDataServiceImplTest {
    UserDataService userDataService = new UserDataServiceImpl();
    UserPO userPO = new UserPO("总经理", "py", "12", false);
    @Test
    public void add() throws Exception {
        ResultMessage msg = userDataService.add(userPO);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void find() throws Exception {
    }

    @Test
    public void contains() throws Exception {
    }

}