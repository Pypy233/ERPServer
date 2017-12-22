package service.blservice;

import po.GoodsPO;
import vo.LackListVO;
import vo.OverflowListVO;
import vo.PresentListVO;

import java.util.ArrayList;

/**
 * Created by py on 2017/10/19.
 */
public interface CommodityBLService {
   /**
    * 盘点当天库存
    * @param date
    */
   public void check(String date);

   /**
    * 得到一段时间的赠送单
    * @param startTime
    * @param endTime
    * @return
    */
   public PresentListVO getPresentList(String startTime, String endTime);

   /**
    * 得到一段时间的报溢单
    * @param startTime
    * @param endTime
    * @return
    */
   public OverflowListVO getOverflowList(String startTime, String endTime);

   /**
    * 得到一段时间的报损单
    * @param startTime
    * @param endTime
    * @return
    */
   public LackListVO getLackList(String startTime, String endTime);


   /**
    * 库存报警
    * @param warningNumber
    * @return
    */
   public ArrayList<GoodsPO> getWarningList(int warningNumber);

}
