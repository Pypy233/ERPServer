package service;

import po.*;
import vo.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 将VO转化为PO的类，统一方法为vo名 + "_to_" + po名（ vo, po名全小写 ）
 */
public class VOChangeToPO {
    public GoodsPO goodsvo_to_goodspo(GoodsVO vo){
        GoodsPO po = new GoodsPO();
        po.setNumber(vo.getNumber());
        po.setName(vo.getName());
        po.setType(vo.getType());
        po.setCommodityNum(vo.getCommodityNum());
        po.setPurchasePrice(vo.getPurchasePrice());
        po.setRetailPrice(vo.getRetailPrice());
        po.setRecentPurPrice(vo.getRecentPurPrice());
        po.setRecentRetPrice(vo.getRecentRetPrice());
        return po;
    }

    public UserPO uservo_to_userpo(UserVO vo){
        UserPO po = new UserPO();
        po.setLogin(vo.isLogin());
        po.setName(vo.getName());
        po.setPassword(vo.getPassword());
        po.setType(vo.getType());
        return po;
    }

    public MemberPO membervo_to_memberpo(MemberVO vo){
        MemberPO po = new MemberPO();
        po.setNumber(vo.getNumber());
        po.setName(vo.getName());
        po.setMemberClass(vo.getMemberClass());
        po.setLevel(vo.getLevel());
        po.setPhoneNumber(vo.getPhoneNumber());
        po.setAddress(vo.getAddress());
        po.setPostcode(vo.getPostcode());
        po.setMailAddress(vo.getMailAddress());
        po.setCollectionLimit(vo.getCollectionLimit());
        po.setCollection(vo.getCollection());
        po.setPayment(vo.getPayment());
        po.setManagePerson(vo.getManagePerson());
        return po;
    }


    public ClassifyPO classifyvo_to_classifypo(ClassifyVO vo){
        ClassifyPO po = new ClassifyPO();
        po.setId(vo.getId());
        po.setName(vo.getName());
        Set<GoodsPO> poSet = new HashSet<>();
        Set<GoodsVO> voSet = vo.goodsSet;

        for(GoodsVO goodsVO: voSet) {
            poSet.add(goodsvo_to_goodspo(goodsVO));
        }
        po.setGoodsSet(poSet);

        return po;
    }



    public GoodsStockPO goodsStockvo_to_goodsStockpo(GoodsStockVO vo){
        GoodsStockPO po = new GoodsStockPO();
        po.setId(vo.getId());
        po.setStockNumber(vo.getStockNumber());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setRemark(vo.getRemark());
        po.setTotalPrice(vo.getTotalPrice());
        return po;
    }


    public GoodsStockReturnPO goodsStockReturnvo_to_goodsStockReturnpo(GoodsStockReturnVO vo){
        GoodsStockReturnPO po = new GoodsStockReturnPO();
        po.setId(vo.getId());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setRemark(vo.getRemark());
        po.setStockReturnNumber(vo.getStockReturnNumber());
        po.setTotalPrice(vo.getTotalPrice());
        return po;
    }


    public GoodsSalePO goodsSalevo_to_goodsSalepo(GoodsSaleVO vo){
        GoodsSalePO po = new GoodsSalePO();
        po.setId(vo.getId());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setPrice(vo.getPrice());
        po.setRemark(vo.getRemark());
        po.setSaleNumber(vo.getSaleNumber());
        po.setTotalPrice(vo.getTotalPrice());
        return po;
    }


    public GoodsSaleReturnPO goodsSaleReturnvo_to_goodsSaleReturnpo(GoodsSaleReturnVO vo){
        GoodsSaleReturnPO po = new GoodsSaleReturnPO();
        po.setId(vo.getId());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setPrice(vo.getPrice());
        po.setRemark(vo.getRemark());
        po.setSaleReturnNumber(vo.getSaleReturnNumber());
        po.setTotalPrice(vo.getTotalPrice());
        return po;
    }

    public StockPO stockvo_to_stockpo(StockVO vo){
        StockPO po = new StockPO();
        po.setReceiptNumber(vo.getReceiptNumber());
        po.setCommodityNumber(vo.getCommodityNumber());
        po.setDate(vo.getDate());
        po.setNumber(vo.getNumber());
        po.setOperator(vo.getOperator());
        po.setProvider(vo.getProvider());
        po.setRemark(vo.getRemark());
        po.setTotalPrice(vo.getTotalPrice());
        po.setState(vo.getState());

        Set<GoodsStockPO> poSet = new HashSet<>();
        Set<GoodsStockVO> voSet = vo.getStockSet();
        for(GoodsStockVO goodsVo :voSet){
            poSet.add(goodsStockvo_to_goodsStockpo(goodsVo));
        }
        po.setStockSet(poSet);
        return po;
    }

    public StockReturnPO stockReturnvo_to_stockReturnpo(StockReturnVO vo){
        StockReturnPO po = new StockReturnPO();

        po.setNumber(vo.getNumber());
        po.setDate(vo.getDate());
        po.setReceiptNumber(vo.getReceiptNumber());
        po.setCommodityNumber(vo.getCommodityNumber());
        po.setOperator(vo.getOperator());
        po.setProvider(vo.getProvider());
        po.setRemark(vo.getRemark());
        po.setTotalPrice(vo.getTotalPrice());
        po.setState(vo.getState());

        Set<GoodsStockReturnPO> poSet = new HashSet<>();
        Set<GoodsStockReturnVO> voSet = vo.getStockSet();
        for(GoodsStockReturnVO vo1 : voSet){
            poSet.add(goodsStockReturnvo_to_goodsStockReturnpo(vo1));
        }
        po.setStockSet(poSet);
        return po;
    }

    public SalePO salevo_to_salepo(SaleVO vo){
        SalePO po = new SalePO();

        po.setDate(vo.getDate());
        po.setReceiptNumber(vo.getReceiptNumber());
        po.setNumber(vo.getNumber());
        po.setCommodityNumber(vo.getCommodityNumber());
        po.setDiscount(vo.getDiscount());
        po.setOperator(vo.getOperator());
        po.setTotalPrice(vo.getTotalPrice());
        po.setRemark(vo.getRemark());
        po.setPayPrice(vo.getPayPrice());
        po.setRetailer(vo.getRetailer());
        po.setSalesman(vo.getSalesman());
        po.setVoucher(vo.getVoucher());
        po.setState(vo.getState());
        Set<GoodsSalePO> set = new HashSet<>();
        for(GoodsSaleVO vo1 : vo.getSaleSet()){
            set.add(goodsSalevo_to_goodsSalepo(vo1));
        }
        po.setSaleSet(set);
        return po;
    }

    public SaleReturnPO saleReturnvo_to_saleReturnpo(SaleReturnVO vo){
        SaleReturnPO po = new SaleReturnPO();

        po.setDate(vo.getDate());
        po.setNumber(vo.getNumber());
        po.setReceiptNumber(vo.getReceiptNumber());
        po.setCommodityNumber(vo.getCommodityNumber());
        po.setOperator(vo.getOperator());
        po.setRemark(vo.getRemark());
        po.setRetailer(vo.getRetailer());
        po.setSalesman(vo.getSalesman());
        po.setPayPrice(vo.getPayPrice());
        po.setState(vo.getState());

        Set<GoodsSaleReturnPO> poSet = new HashSet<>();
        Set<GoodsSaleReturnVO> voSet = new HashSet<>();
        for(GoodsSaleReturnVO vo1 : voSet){
            poSet.add(goodsSaleReturnvo_to_goodsSaleReturnpo(vo1));
        }
        po.setSaleReturnSet(poSet);
        return po;
    }

    public GoodsLackPO goodsLackvo_to_goodsLackpo(GoodsLackVO vo){
        GoodsLackPO po = new GoodsLackPO();
        po.setId(vo.getId());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setTrueNumber(vo.getTrueNumber());
        return po;
    }

    public LackListPO lackListvo_to_lackListpo(LackListVO vo) {
        LackListPO po = new LackListPO();
        po.setId(vo.getId());
        po.setDate(vo.getDate());
        po.setOperator(vo.getOperator());
        Set<GoodsLackPO> poSet = new HashSet<>();
        Set<GoodsLackVO> voSet = vo.getSet();
        for(GoodsLackVO goodsLackVO: voSet){
            poSet.add(goodsLackvo_to_goodsLackpo(goodsLackVO));
        }
        po.setSet(poSet);
        return po;
    }

    public GoodsOverflowPO goodsOverflowvo_to_goodsOverflowpo(GoodsOverflowVO vo){
        GoodsOverflowPO po = new GoodsOverflowPO();
        po.setId(vo.getId());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        po.setTrueNumber(vo.getTrueNumber());
        return po;
    }

    public OverflowListPO overflowListvo_to_overflowListpo(OverflowListVO vo){
        OverflowListPO po = new OverflowListPO();
        po.setDate(vo.getDate());
        po.setId(vo.getId());
        po.setOperator(vo.getOperator());

        Set<GoodsOverflowPO> poSet = new HashSet<>();
        Set<GoodsOverflowVO> voSet = vo.getSet();

        for(GoodsOverflowVO goodsOverflowVO: voSet){
            poSet.add(goodsOverflowvo_to_goodsOverflowpo(goodsOverflowVO));
        }
        po.setSet(poSet);
        return po;
    }

    public PresentPO presentvo_to_presentpo(PresentVO vo){
        PresentPO po = new PresentPO();
        po.setId(vo.getId());
        po.setNumber(vo.getNumber());
        po.setPo(goodsvo_to_goodspo(vo.getVo()));
        return po;
    }

    public PresentListPO presentListvo_to_presentListpo(PresentListVO vo){
        PresentListPO po = new PresentListPO();
        po.setId(vo.getId());
        po.setClient(vo.getClient());
        po.setDate(vo.getDate());
        po.setOperator(vo.getOperator());
        Set<PresentPO> poSet = new HashSet<>();
        Set<PresentVO> voSet = vo.getSet();

        for(PresentVO presentVO : voSet){
            poSet.add(presentvo_to_presentpo(presentVO));
        }
        po.setSet(poSet);

        return po;
    }


}
