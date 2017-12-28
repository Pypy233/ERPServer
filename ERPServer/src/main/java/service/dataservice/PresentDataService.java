package service.dataservice;

import objects.ResultMessage;
import po.PresentPO;

public interface PresentDataService {
    /**
     * 增加赠送商品
     * @param po
     * @return
     */
    public ResultMessage add(PresentPO po);

    /**
     * 删除赠送商品
     * @param po
     * @return
     */
    public ResultMessage delete(PresentPO po);

    /**
     * 更新赠送商品
     * @param po
     * @return
     */
    public ResultMessage update(PresentPO po);

}
