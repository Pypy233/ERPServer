package service.dataservice.Impl;

import objects.HQLTools;
import objects.ResultMessage;
import po.BankPO;
import service.dataservice.BankDataService;


import java.util.ArrayList;

public class BankDataServiceImpl implements BankDataService{

	@Override
	public ArrayList<BankPO> retrieve(String keywords) {
		return (ArrayList<BankPO>) HQLTools.find(keywords);
	}

	@Override
	public ResultMessage add(BankPO bank) {
		if(contain(bank))
			return ResultMessage.Fail;
		HQLTools.add(bank);
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage delete(BankPO bank) {
		if(!contain(bank))
			return ResultMessage.Fail;
		HQLTools.delete(bank);
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage update(BankPO bank) {
		if(!contain(bank))
			return ResultMessage.Fail;
		HQLTools.update(bank);
		return ResultMessage.Success;
	}
	
	private boolean contain(BankPO po){
		ArrayList<BankPO> bankList = (ArrayList<BankPO>) HQLTools.find("from Bank");
        if(bankList.size() > 0){
            for(int i = 0; i < bankList.size(); i++){
                if(bankList.get(i).getName().equals(po.getName()))
                    return true;
            }
        }
        return false;
    }

}
