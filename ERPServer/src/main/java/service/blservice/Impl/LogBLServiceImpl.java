package service.blservice.Impl;

import objects.DateHelper;
import objects.POtoVO;
import objects.ResultMessage;
import po.LogPO;
import service.VOChangeToPO;
import service.blservice.LogBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.LogVO;
import vo.UserVO;

import java.util.ArrayList;

public class LogBLServiceImpl implements LogBLService {
    DateHelper dateHelper = new DateHelper();
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addLog(UserVO vo, String operation, ResultMessage msg) {
        LogVO logVO = new LogVO();
        String date = dateHelper.getDate();
        logVO.setName(vo.getName());
        logVO.setOperation(operation);
        logVO.setDate(date);
        if(msg == ResultMessage.Success)
            logVO.setResult("成功");
        else
            logVO.setResult("失败");
        ResultMessage resultMessage = dataFactory.getLogDataService().add(voChangeToPO.logvo_to_logpo(logVO));
        return resultMessage;
    }

    @Override
    public ResultMessage delete(LogVO vo) {
        if(vo == null)
            return ResultMessage.Fail;
        ResultMessage msg = dataFactory.getLogDataService().delete(voChangeToPO.logvo_to_logpo(vo));
        return msg;
    }

    @Override
    public ResultMessage update(LogVO vo) {
        if(vo == null)
            return ResultMessage.Fail;
        ResultMessage msg = dataFactory.getLogDataService().update(voChangeToPO.logvo_to_logpo(vo));
        return msg;
    }

    @Override
    public ArrayList<LogVO> getLog(UserVO vo) {
        String name = vo.getName();
        return findByName(name);
    }

    @Override
    public ArrayList<LogVO> findByName(String name) {
        ArrayList<LogPO> poList = dataFactory.getLogDataService().findByName(name);
        ArrayList<LogVO> voList = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.logPO_to_logVO(poList.get(i)));
        }
        return voList;
    }

    @Override
    public ArrayList<LogVO> findByDate(String date) {
        ArrayList<LogPO> poList = dataFactory.getLogDataService().findByDate(date);
        ArrayList<LogVO> voList = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.logPO_to_logVO(poList.get(i)));
        }
        return voList;
    }

    @Override
    public ArrayList<LogVO> findByOperation(String operation) {
        ArrayList<LogPO> poList = dataFactory.getLogDataService().findByOperation(operation);
        ArrayList<LogVO> voList = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.logPO_to_logVO(poList.get(i)));
        }
        return voList;
    }
}
