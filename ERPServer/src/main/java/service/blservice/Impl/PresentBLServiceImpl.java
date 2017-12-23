package service.blservice.Impl;

import objects.ResultMessage;
import po.PresentPO;
import service.VOChangeToPO;
import service.blservice.PresentBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.PresentVO;

public class PresentBLServiceImpl implements PresentBLService {
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();

    @Override
    public ResultMessage addPresent(PresentVO vo) {
        PresentPO po = voChangeToPO.presentvo_to_presentpo(vo);
        ResultMessage msg = dataFactory.getPresentDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deletePresent(PresentVO vo) {
        PresentPO po = voChangeToPO.presentvo_to_presentpo(vo);
        ResultMessage msg = dataFactory.getPresentDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage updatePresent(PresentVO vo) {
        PresentPO po = voChangeToPO.presentvo_to_presentpo(vo);
        ResultMessage msg = dataFactory.getPresentDataService().update(po);
        return msg;
    }
}
