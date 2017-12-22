package service.blservice.Impl;

import service.blservice.CommodityBLService;
import vo.GoodsVO;
import vo.LackListVO;
import vo.OverflowListVO;
import vo.PresentListVO;

import java.util.ArrayList;

public class CommodityBLServiceImpl implements CommodityBLService {
    @Override
    public void check(String date) {

    }

    @Override
    public PresentListVO getPresentList(String startTime, String endTime) {
        return null;
    }

    @Override
    public OverflowListVO getOverflowList(String startTime, String endTime) {
        return null;
    }

    @Override
    public LackListVO getLackList(String startTime, String endTime) {
        return null;
    }

    @Override
    public ArrayList<GoodsVO> getWarningList(int warningNumber) {
        return null;
    }
}
