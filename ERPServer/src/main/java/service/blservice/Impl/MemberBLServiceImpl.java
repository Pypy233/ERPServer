package service.blservice.Impl;

import objects.ResultMessage;
import po.MemberPO;
import service.VOChangeToPO;
import service.blservice.MemberBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.MemberVO;

import java.rmi.RemoteException;

public class MemberBLServiceImpl implements MemberBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();

    @Override
    public ResultMessage add(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().update(po);
        return ResultMessage.Success;
    }
}
