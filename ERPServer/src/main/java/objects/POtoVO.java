package objects;

import po.*;
import vo.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 将pO转化为vO的类，统一方法为po名 + "_to_" + vo名（ vo, po名全小写 ）
 */
public class POtoVO {
     public GoodsVO goodspo_to_goodsvo(GoodsPO po){
        GoodsVO vo = new GoodsVO();
        vo.setNumber(po.getNumber());
        vo.setName(po.getName());
        vo.setType(po.getType());
        vo.setCommodityNum(po.getCommodityNum());
        vo.setPurchasePrice(po.getPurchasePrice());
        vo.setRetailPrice(po.getRetailPrice());
        vo.setRecentPurPrice(po.getPurchasePrice());
        vo.setRecentRetPrice(po.getRecentRetPrice());
        return vo;
    }

    public StockVO stockpo_to_stockvo(StockPO po){
        StockVO vo = new StockVO();
        vo.setTotalPrice(po.getTotalPrice());
        vo.setNumber(po.getNumber());
        vo.setReceiptNumber(po.getReceiptNumber());
        vo.setDate(po.getDate());
        vo.setRemark(po.getRemark());
        vo.setProvider(po.getProvider());
        vo.setCommodityNumber(po.getCommodityNumber());
        vo.setOperator(po.getOperator());
        vo.setState(po.getState());

        Set<GoodsStockVO> voSet = new HashSet<>();
        Set<GoodsStockPO> poSet = po.getStockSet();

        for(GoodsStockPO goodsStockPO : poSet){
           voSet.add(goodsStockPO_to_goodsStockVO(goodsStockPO));
        }
        vo.setStockSet(voSet);
       return vo;
    }

    public StockReturnVO stockReturnPO_to_stockReturnVO(StockReturnPO po){
      StockReturnVO vo = new StockReturnVO();

       vo.setNumber(po.getNumber());
       vo.setReceiptNumber(po.getReceiptNumber());
       vo.setDate(po.getDate());
       vo.setProvider(po.getProvider());
       vo.setRemark(po.getRemark());
       vo.setTotalPrice(po.getTotalPrice());
       vo.setCommodityNumber(po.getCommodityNumber());
       vo.setOperator(po.getOperator());
       vo.setState(po.getState());

       Set<GoodsStockReturnVO> voSet = new HashSet<>();
       Set<GoodsStockReturnPO> poSet = po.getStockSet();
       for(GoodsStockReturnPO goodsStockReturnPO : poSet){
          voSet.add(goodsStockReturnPO_to_goodsStockReturnVO(goodsStockReturnPO));
       }
       vo.setStockSet(voSet);

       return vo;

    }

    public SaleVO salepo_to_salevo(SalePO po){
        SaleVO vo = new SaleVO();
        vo.setNumber(po.getNumber());
        vo.setReceiptNumber(po.getReceiptNumber());
        vo.setDate(po.getDate());
        vo.setPayPrice(po.getPayPrice());
        vo.setTotalPrice(po.getTotalPrice());
        vo.setRemark(po.getRemark());
        vo.setRetailer(po.getRetailer());
        vo.setVoucher(po.getVoucher());
        vo.setDiscount(po.getDiscount());
        vo.setOperator(po.getOperator());
        vo.setSalesman(po.getSalesman());
        vo.setCommodityNumber(po.getCommodityNumber());
        vo.setState(po.getState());

       Set<GoodsSaleVO> voSet = new HashSet<>();
       Set<GoodsSalePO> poSet = po.getSaleSet();
       for(GoodsSalePO goodsSalePO: poSet){
          voSet.add(goodssalepo_to_goodssalevo(goodsSalePO));
       }
       vo.setSaleSet(voSet);
        return vo;
    }

   public SaleReturnVO saleReturnPO_to_saleReturnVO(SaleReturnPO po){
       SaleReturnVO vo = new SaleReturnVO();
       vo.setNumber(po.getNumber());
       vo.setReceiptNumber(po.getReceiptNumber());
       vo.setPayPrice(po.getPayPrice());
       vo.setDate(po.getDate());
       vo.setRemark(po.getRemark());
       vo.setOperator(po.getOperator());
       vo.setSalesman(po.getSalesman());
       vo.setRetailer(po.getRetailer());
       vo.setCommodityNumber(po.getCommodityNumber());
       vo.setState(po.getState());

      Set<GoodsSaleReturnVO> voSet = new HashSet<>();
      Set<GoodsSaleReturnPO> poSet = po.getSaleReturnSet();
      for(GoodsSaleReturnPO goodsSaleReturnpo: poSet){
         voSet.add(goodsSaleReturnPO_to_goodsSaleReturnVO(goodsSaleReturnpo));
      }
       vo.setSaleReturnSet(voSet);
      return vo;
   }

   public GoodsStockVO goodsStockPO_to_goodsStockVO(GoodsStockPO po){
      GoodsStockVO vo = new GoodsStockVO();

      vo.setVo(goodspo_to_goodsvo(po.getPo()));
      vo.setTotalPrice(po.getTotalPrice());
      vo.setRemark(po.getRemark());
      vo.setStockNumber(po.getStockNumber());
      vo.setId(po.getId());

      return vo;
   }

   public GoodsStockReturnVO goodsStockReturnPO_to_goodsStockReturnVO(GoodsStockReturnPO po){
      GoodsStockReturnVO vo = new GoodsStockReturnVO();

      vo.setVo(goodspo_to_goodsvo(po.getPo()));
      vo.setRemark(po.getRemark());
      vo.setTotalPrice(po.getTotalPrice());
      vo.setStockReturnNumber(po.getStockReturnNumber());
      vo.setId(po.getId());

      return vo;
   }

   public GoodsSaleVO goodssalepo_to_goodssalevo(GoodsSalePO po){
      GoodsSaleVO vo = new GoodsSaleVO();
      vo.setTotalPrice(po.getTotalPrice());
      vo.setId(po.getId());
      vo.setVo(goodspo_to_goodsvo(po.getPo()));
      vo.setSaleNumber(po.getSaleNumber());
      vo.setPrice(po.getPrice());
      vo.setRemark(po.getRemark());
      return vo;
   }

   public GoodsSaleReturnVO goodsSaleReturnPO_to_goodsSaleReturnVO(GoodsSaleReturnPO po){
      GoodsSaleReturnVO vo = new GoodsSaleReturnVO();
      vo.setRemark(po.getRemark());
      vo.setPrice(po.getPrice());
      vo.setSaleReturnNumber(po.getSaleReturnNumber());
      vo.setVo(goodspo_to_goodsvo(po.getPo()));
      vo.setId(po.getId());
      vo.setTotalPrice(po.getTotalPrice());
      return vo;
   }

   public UserVO userpo_to_uservo(UserPO po){
       UserVO vo = new UserVO();
       vo.setPassword(po.getPassword());
       vo.setType(po.getType());
       vo.setName(po.getName());
       vo.setLogin(po.isLogin());
       return vo;
   }

   public GoodsLackVO goodsLackPO_to_goodsLackVO(GoodsLackPO po){
       GoodsLackVO vo = new GoodsLackVO();
       vo.setId(po.getId());
       vo.setTrueNumber(po.getTrueNumber());
       vo.setVo(goodspo_to_goodsvo(po.getPo()));
       return vo;
   }

   public LackListVO lackListPO_to_lackListVO(LackListPO po) {
       LackListVO vo = new LackListVO();
       vo.setDate(po.getDate());
       vo.setId(po.getId());
       vo.setOperator(po.getOperator());

       Set<GoodsLackPO> goodsLackPOSet = po.getSet();
       Set<GoodsLackVO> goodsLackVOSet = new HashSet<>();

       for (GoodsLackPO goodsLackPO : goodsLackPOSet) {
           goodsLackVOSet.add(goodsLackPO_to_goodsLackVO(goodsLackPO));
       }
       vo.setSet(goodsLackVOSet);
       return vo;
   }

   public GoodsOverflowVO goodsOverflowVO_to_goodsOverflowPO(GoodsOverflowPO po){
       GoodsOverflowVO vo = new GoodsOverflowVO();
       vo.setId(po.getId());
       vo.setTrueNumber(po.getTrueNumber());
       vo.setVo(goodspo_to_goodsvo(po.getPo()));
       return vo;
   }

   public OverflowListVO overflowListVO_to_overflowListPO(OverflowListPO po){
       OverflowListVO vo = new OverflowListVO();
       vo.setId(po.getId());
       vo.setDate(po.getDate());
       vo.setOperator(po.getOperator());

       Set<GoodsOverflowPO> goodsOverflowPOSet = po.getSet();
       Set<GoodsOverflowVO> goodsOverflowVOSet = new HashSet<>();

       for(GoodsOverflowPO goodsOverflowPO : goodsOverflowPOSet){
           goodsOverflowVOSet.add(goodsOverflowVO_to_goodsOverflowPO(goodsOverflowPO));
       }
       vo.setSet(goodsOverflowVOSet);

       return vo;
   }

    public PresentVO presentPO_to_prensetVO(PresentPO po){
       PresentVO vo = new PresentVO();
       vo.setId(po.getId());
       vo.setNumber(po.getNumber());
       vo.setVo(goodspo_to_goodsvo(po.getPo()));
       return vo;
    }

    public PresentListVO presentListPO_to_presentListVO(PresentListPO po){
        PresentListVO vo = new PresentListVO();
        vo.setId(po.getId());
        vo.setClient(po.getClient());
        vo.setDate(po.getDate());
        vo.setOperator(po.getOperator());

        Set<PresentPO> poSet = po.getSet();
        Set<PresentVO> voSet = new HashSet<>();

        for(PresentPO presentPO : poSet){
            voSet.add(presentPO_to_prensetVO(presentPO));
        }
        vo.setSet(voSet);
        return vo;
    }

    public MemberVO memberPO_to_memberVO(MemberPO po){
        MemberVO vo = new MemberVO();
        vo.setAddress(po.getAddress());
        vo.setCollection(po.getCollection());
        vo.setCollectionLimit(po.getCollectionLimit());
        vo.setLevel(po.getLevel());
        vo.setMailAddress(po.getMailAddress());
        vo.setAddress(po.getAddress());
        vo.setManagePerson(po.getManagePerson());
        vo.setMemberClass(po.getMemberClass());
        vo.setName(po.getName());
        vo.setNumber(po.getNumber());
        vo.setPayment(po.getPayment());
        vo.setPhoneNumber(po.getPhoneNumber());
        vo.setPostcode(po.getPostcode());
        return vo;
    }

    public LogVO logPO_to_logVO(LogPO po){
        LogVO vo = new LogVO();
        vo.setDate(po.getDate());
        vo.setId(po.getId());
        vo.setName(po.getName());
        vo.setOperation(po.getOperation());
        vo.setResult(po.getOperation());
        return vo;
    }

    public AdminVO adminPO_to_adminVO(AdminPO po){
        AdminVO vo = new AdminVO();
        vo.setId(po.getId());
        vo.setName(po.getName());
        vo.setPassword(po.getPassword());
        return vo;
    }

}
