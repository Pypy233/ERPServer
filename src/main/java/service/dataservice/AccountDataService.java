package service.dataservice;

import objects.ResultMessage;
import po.AccountPO;

import java.util.ArrayList;

/**
 *  by peng ,2017,12,4
 */
public interface AccountDataService {
	//created by peng 
	/**
	 * 
	 * 
	 * 由于都一样，所以只解释一遍。
	 */
	
	//依据sql语句 keywords，对数据库进行搜索，所得为Array List《accountPO》
	public ArrayList<AccountPO> retrieve(String keywords);
	
	//在account数据库中添加 accountpo
	public ResultMessage add(AccountPO account);
	
	//在account数据库中删除 accountpo
	public ResultMessage delete(AccountPO Account);
	
	//在account数据库中更新 accountpo
	public ResultMessage update(AccountPO Account);
	
}
