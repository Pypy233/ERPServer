package service.blservice;

import vo.GoodsVO;

import java.util.ArrayList;

/**
 * 库存不足报警并补充到正常数量
 */
public interface GoodsWarningMessageBLService {
    public ArrayList<GoodsVO> getWarningMessage(int number);
}
