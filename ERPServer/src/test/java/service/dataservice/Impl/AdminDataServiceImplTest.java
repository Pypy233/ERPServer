package service.dataservice.Impl;

import objects.ResultMessage;
import org.junit.Test;
import po.AdminPO;
import po.UserPO;
import service.dataservice.AdminDataService;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminDataServiceImplTest {
    AdminDataService dataService = new AdminDataServiceImpl();

    @Test
    public void add() throws Exception {
        AdminPO po = new AdminPO();
        po.setName("py");
        po.setPassword("1");
        ResultMessage msg = dataService.add(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void delete() throws Exception {
        AdminPO po = new AdminPO();
        po.setId(1);
        po.setName("py");
        po.setPassword("1");
        ResultMessage msg = dataService.delete(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void update() throws Exception {
        AdminPO po = new AdminPO();
        po.setName("py");
        po.setPassword("1212hjkl");
        ResultMessage msg = dataService.update(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void getUsers() throws Exception {
        ArrayList<UserPO> list = dataService.getUsers();
        assertEquals(7, list.size());
    }

    @Test
    public void find() throws Exception {
        ArrayList<UserPO> list = dataService.find("销售人员");
        ArrayList<UserPO> list1 = dataService.find("总经理");
        ArrayList<UserPO> list2 = dataService.find("财务人员");
        ArrayList<UserPO> list3 = dataService.find("库存管理人员");

        assertEquals(1, list.size());
        assertEquals(1, list1.size());
        assertEquals(2, list2.size());
        assertEquals(2, list3.size());
    }

    @Test
    public void addAdvancedUser() throws Exception {
        UserPO po = new UserPO();
        po.setType("销售经理");
        po.setName("演员");
        po.setPassword("null");
        ResultMessage msg = dataService.addAdvancedUser(po);
        assertEquals(ResultMessage.Success, msg);
    }

}