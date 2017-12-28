package service.dataservice;

import objects.ResultMessage;
import po.LogPO;

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
}
