package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.LackListPO;
import service.VOChangeToPO;
import service.blservice.LackListBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.LackListVO;
import vo.UserVO;

import java.util.ArrayList;

public class LackListBLServiceImpl implements LackListBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addLackList(LackListVO vo) {
        LackListPO po = voChangeToPO.lackListvo_to_lackListpo(vo);
        ResultMessage  msg = dataFactory.getLackListDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteLackList(LackListVO vo) {
        LackListPO po = voChangeToPO.lackListvo_to_lackListpo(vo);
        ResultMessage msg = dataFactory.getLackListDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage update(LackListVO vo) {
        LackListPO po = voChangeToPO.lackListvo_to_lackListpo(vo);
        ResultMessage msg = dataFactory.getLackListDataService().update(po);
        return msg;
    }

    @Override
    public ArrayList<LackListVO> getLackList(String startTime, String endTime, String userName) {
        ArrayList<LackListPO> list = dataFactory.getLackListDataService().getLackList(startTime,
                endTime, userName);
        ArrayList<LackListVO> list1 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            list1.add(pOtoVO.lackListPO_to_lackListVO(list.get(i)));
        }
        return list1;
    }

    @Override
    public LackListVO addLackListRed(LackListVO vo) {
        LackListPO po = voChangeToPO.lackListvo_to_lackListpo(vo);
        LackListPO redPo =  dataFactory.getLackListDataService().addRed(voChangeToPO.lackListvo_to_lackListpo(vo));
        LackListVO vo1 = pOtoVO.lackListPO_to_lackListVO(redPo);
        return vo1;
    }
}
