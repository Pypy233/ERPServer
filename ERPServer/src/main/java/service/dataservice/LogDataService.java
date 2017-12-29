package service.dataservice;

import objects.ResultMessage;
import po.LackListPO;
import po.LogPO;

import java.util.ArrayList;

public interface LogDataService {
    /**
     * 增加日志
     * @param po
     * @return
     */
    public ResultMessage add(LogPO po);

    /**
     * 删除日志
     * @param po
     * @return
     */
    public ResultMessage delete(LogPO po);

    /**
     * 更新日志
     * @param po
     * @return
     */
    public ResultMessage update(LogPO po);

    /**
     * 按照用户名查找日志
     * @param name
     * @return
     */
    public ArrayList<LogPO> findByName(String name);

    /**
     * 按照日期查找日志
     * @param date
     * @return
     */
    public ArrayList<LogPO> findByDate(String date);

    /**
     * 按操作查找日志
     * @param operation
     * @return
     */
    public ArrayList<LogPO> findByOperation(String operation);


}
