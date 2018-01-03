package service.dataservice;

import objects.ResultMessage;
import po.BankPO;

import java.util.ArrayList;

/*
 *  by peng ,2017,12,4
 */
public interface BankDataService {
	//created by peng 
	
	public ResultMessage add(BankPO bank);
	public ResultMessage update(BankPO bank);
	public ResultMessage delete(BankPO bank);
	public ArrayList<BankPO> retrieve(String keywords);

	
	
}
