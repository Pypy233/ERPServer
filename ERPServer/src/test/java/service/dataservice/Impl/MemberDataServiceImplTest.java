package service.dataservice.Impl;

import objects.ResultMessage;
import org.junit.Test;
import po.MemberPO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberDataServiceImplTest {
    MemberDataServiceImpl memberDataService = new MemberDataServiceImpl();
    @Test
    public void add() throws Exception {
        MemberPO po = new MemberPO(2, "pgZero", "销售商", 5,
                "00008001", "NJU", "210000", "pgzero@gmail.com",
                20000, 3000, 100, "积尘");
        ResultMessage msg = memberDataService.add(po);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = memberDataService.add(po);
        assertEquals(ResultMessage.Fail, msg1);

        MemberPO po1 = new MemberPO(3, "XiaoYunfan", "销售商", 5,
                "00008002", "NJU", "210000", "XiaoYunfan@163.com",
                10000, 2000, 1000, "积尘");
        ResultMessage msg2 = memberDataService.add(po1);
        assertEquals(ResultMessage.Success, msg2);

        MemberPO po2 = new MemberPO(4, "XiongYiHeng", "销售商", 5,
                "00008003", "NJU", "210000", "XiongYiheng@qq.com",
                10000, 2000, 1000, "积尘");
        ResultMessage msg3 = memberDataService.add(po2);
        assertEquals(ResultMessage.Success, msg3);


    }

    @Test
    public void delete() throws Exception {
        MemberPO po = new MemberPO(2, "pgZero", "销售商", 5,
                "00008001", "NJU", "210000", "pgzero@gmail.com",
                20000, 3000, 100, "积尘");
        ResultMessage msg = memberDataService.delete(po);
        assertEquals(ResultMessage.Success, msg);

        ResultMessage msg1 = memberDataService.add(po);
        assertEquals(ResultMessage.Fail, msg1);


        MemberPO po2 = new MemberPO(4, "XiongYiHeng", "销售商", 5,
                "00008003", "NJU", "210000", "XiongYiheng@qq.com",
                10000, 2000, 1000, "积尘");
        ResultMessage msg3 = memberDataService.delete(po2);
        assertEquals(ResultMessage.Success, msg3);
    }

    @Test
    public void update() throws Exception {
        MemberPO po = new MemberPO(3, "XiaoYunfan", "销售商", 4,
                "00008003", "NJU", "210000", "XiaoYunfan@qq.com",
                10000, 2000, 1000, "积尘");
        ResultMessage msg = memberDataService.update(po);
        assertEquals(ResultMessage.Success, msg);
    }

    @Test
    public void find() throws Exception {
        String number = "0001";
        String name = "py";
        String memberClass = "销售商";
        ArrayList<MemberPO> list1, list2, list3;
        /**
         * 测试按编号准确查找
         */
        list1 = memberDataService.find(number, "", "");
        MemberPO po = list1.get(0);
        assertEquals(1, list1.size());
        assertEquals("py", po.getName());
        assertEquals("销售商", po.getMemberClass());
        assertEquals(5, po.getLevel());
        assertEquals("210000", po.getPostcode());
        assertEquals("panyuyuyu@outlook.com", po.getMailAddress());
        assertEquals(10000, po.getCollectionLimit());
        assertEquals(1000, po.getCollection());
        assertEquals(500, po.getPayment());
        assertEquals("积尘", po.getManagePerson());

        /**
         * 测试按名字和分类模糊查找
         */
        list2 = memberDataService.find("0001", "p", "");
        MemberPO po1 = list1.get(0);
        assertEquals(1, list2.size());
        assertEquals("py", po1.getName());
        assertEquals("销售商", po1.getMemberClass());
        assertEquals(5, po1.getLevel());
        assertEquals("210000", po1.getPostcode());
        assertEquals("panyuyuyu@outlook.com", po1.getMailAddress());
        assertEquals(10000, po1.getCollectionLimit());
        assertEquals(1000, po1.getCollection());
        assertEquals(500, po1.getPayment());
        assertEquals("积尘", po1.getManagePerson());


    }

}