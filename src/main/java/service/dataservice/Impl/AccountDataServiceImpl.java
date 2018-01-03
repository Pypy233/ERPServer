package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.AccountPO;
import service.dataservice.AccountDataService;

import java.util.ArrayList;

public class AccountDataServiceImpl implements AccountDataService {

	
	@Override
	public ArrayList<AccountPO> retrieve(String keywords) {
		return (ArrayList<AccountPO>) HQLTools.find(keywords);
	}

	@Override
	public ResultMessage add(AccountPO account) {
		if(contain(account))
			return ResultMessage.Fail;
		HQLTools.add(account);
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage delete(AccountPO account) {
		if(!contain(account))
			return ResultMessage.Fail;
		HQLTools.delete(account);
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage update(AccountPO account) {
		if(!contain(account))
			return ResultMessage.Fail;
		HQLTools.update(account);
		return ResultMessage.Success;
	}
	
	private boolean contain(AccountPO po){
		ArrayList<AccountPO> accountList = (ArrayList<AccountPO>) HQLTools.find("from Account");
        if(accountList.size() > 0){
            for(int i = 0; i < accountList.size(); i++){
                if(accountList.get(i).getDate().equals(po.getDate()))
                    return true;
            }
        }
        return false;
    }

}
