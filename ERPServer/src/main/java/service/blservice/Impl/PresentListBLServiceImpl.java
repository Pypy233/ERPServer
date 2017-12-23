package service.blservice.Impl;


import objects.POtoVO;
import objects.ResultMessage;
import po.PresentListPO;
import service.VOChangeToPO;
import service.blservice.PresentListBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;

import vo.PresentListVO;


import java.util.ArrayList;

public class PresentListBLServiceImpl implements PresentListBLService{
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addPresentList(PresentListVO vo) {
        PresentListPO po = voChangeToPO.presentListvo_to_presentListpo(vo);
        ResultMessage msg = dataFactory.getPresentListDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deletePresentList(PresentListVO vo) {
        PresentListPO po = voChangeToPO.presentListvo_to_presentListpo(vo);
        ResultMessage msg = dataFactory.getPresentListDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage update(PresentListVO vo) {
        PresentListPO po = voChangeToPO.presentListvo_to_presentListpo(vo);
        ResultMessage msg = dataFactory.getPresentListDataService().update(po);
        return msg;
    }

    @Override
    public ArrayList<PresentListVO> getOverflowList(String startTime, String endTime, String userName, String memberName) {
        ArrayList<PresentListPO> list = dataFactory.getPresentListDataService().getPresentList(startTime, endTime
                , userName, memberName);
        ArrayList<PresentListVO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            resultList.add(pOtoVO.presentListPO_to_presentListVO(list.get(i)));
        }
        return resultList;
    }

    @Override
    public PresentListVO addPresentListRed(PresentListVO vo) {
        PresentListPO po = voChangeToPO.presentListvo_to_presentListpo(vo);
        PresentListPO redPo = dataFactory.getPresentListDataService().addRed(po);
        PresentListVO vo1 = pOtoVO.presentListPO_to_presentListVO(redPo);
        return vo1;
    }
}
