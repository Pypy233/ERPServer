package service.blservice.Impl;

import objects.ResultMessage;
import org.junit.Test;
import service.blservice.UserBLService;
import vo.UserVO;

import static org.junit.Assert.*;

public class UserBLServiceImplTest {
    UserBLService userBLService = new UserBLServiceImpl();
    UserVO vo  = new UserVO("财务人员", "xiao", "12");
    @Test
    public void register() throws Exception {
        ResultMessage msg = userBLService.register(vo);
        assertEquals(ResultMessage.Fail, msg);

        UserVO vo2 = new UserVO("non-exist", "non-exist", "12");
        ResultMessage msg2 = userBLService.register(vo2);
        assertEquals(ResultMessage.Fail, msg2);
    }

    @Test
    public void check() throws Exception {

    }

    @Test
    public void updatePassword() throws Exception {
    }

    @Test
    public void getUserVO() throws Exception {
    }

}