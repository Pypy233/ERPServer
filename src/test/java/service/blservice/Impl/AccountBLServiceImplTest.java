package service.blservice.Impl;

import objects.HQLTools;
import org.junit.Test;
import po.AccountPO;
import po.BankPO;
import service.blservice.AccountBLService;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

public class AccountBLServiceImplTest {

    @Test
    public void create() throws RemoteException{
        AccountBLService accountBLService = new AccountBLServiceImpl();
        Set<BankPO> bankSet = new HashSet<>();
        BankPO po = new BankPO("x", 0);
        bankSet.add(po);
        AccountPO po1 = new AccountPO(null, bankSet, null, "xddxxxxxxx");
        HQLTools.add(po1);

    }
}