package service.dataservice;

import objects.ResultMessage;
import po.ClassifyPO;

/**
 * Created by py on 2017/10/19.
 */
public interface ClassifyDataService {
    /**
     * 增加商品分类
     * @param po
     * @return
     */
    public ResultMessage add(ClassifyPO po);

    /**
     * 将子分类添加到父分类上，一旦父分类存在商品就无法添加商品子分类
     * @param parentPO
     * @param sonPO
     * @return
     */
    public ResultMessage add(ClassifyPO parentPO, ClassifyPO sonPO);

    /**
     * 删除商品分类
     * @param po
     * @return
     */
    public ResultMessage delete(ClassifyPO po);

    /**
     * 修改商品分类
     * @param po
     * @return
     */
    public ResultMessage update(ClassifyPO po);


}
