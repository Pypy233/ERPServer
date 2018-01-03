package service.blservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.POtoVO;
import objects.ResultMessage;
import po.AccountPO;
import po.BankPO;
import po.GoodsPO;
import po.MemberPO;
import service.VOChangeToPO;
import service.blservice.AccountBLService;
import service.dataservice.Impl.AccountDataServiceImpl;
import vo.AccountVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//finished
public class AccountBLServiceImpl extends UnicastRemoteObject implements AccountBLService {

	/**
	 * 
	 */


	public AccountBLServiceImpl() throws RemoteException {
		
		// TODO Auto-generated constructor stub
	}

	AccountDataServiceImpl impl = new AccountDataServiceImpl();
	POtoVO po2vo = new POtoVO();
	VOChangeToPO vo2po = new VOChangeToPO();
	
	@Override
	public ArrayList<AccountVO> getList() {
		ArrayList<AccountPO> poList=impl.retrieve("From Account");
		ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
		for(AccountPO po:poList){

		}
		return voList;
		
	}

	@Override
	public ResultMessage create() {
		// TODO Auto-generated method stub
		DateHelper helper=new DateHelper();
		HQLTools tool=new HQLTools();
		ResultMessage rs= ResultMessage.Fail;
		
		ArrayList<GoodsPO> goodsList=(ArrayList<GoodsPO> )tool.find("from Goods");
		ArrayList<BankPO> bankList=(ArrayList<BankPO>)tool.find("from Bank");
		ArrayList<MemberPO> memberList=(ArrayList<MemberPO>)tool.find("from Member");
		
		if(goodsList==null)rs= ResultMessage.Fail;
		if(bankList==null)rs= ResultMessage.Fail;
		if(bankList==null)rs= ResultMessage.Fail;

		Set<GoodsPO> goodsset=new HashSet<GoodsPO>(goodsList);
		Set<BankPO> bankset=new HashSet<BankPO>(bankList);
		Set<MemberPO> memberset=new HashSet<MemberPO>(memberList);


		AccountPO accountpo=new AccountPO(goodsset,bankset,memberset,helper.getDate());
		impl.add(accountpo);
		
		return rs;
	}
	

}
