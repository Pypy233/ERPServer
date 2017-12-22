package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class commodityStockCheckController {

    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;




    //输入查找库存变动起始年份
    @FXML
    public TextArea searchStartYearTA;
    //输入查找库存变动起始月份
    @FXML
    public TextArea searchStartMonthTA;
    //输入查找库存变动起始日
    @FXML
    public TextArea searchStartDayTA;
    //输入查找库存变动截止年份
    @FXML
    public TextArea searchEndYearTA;
    //输入查找库存变动截止月份
    @FXML
    public TextArea searchEndMonthTA;
    //输入查找库存变动截止日
    @FXML
    public TextArea searchEndDayTA;

    //“查询”按钮
    @FXML
    public Button periodSearchButton;





    //库存变动列表
    @FXML
    public TableView stockChangeTV;

    //库存变动列表 单据编号
    @FXML
    public TableColumn stockRecepitIDTC;
    //库存变动列表 供应商
    @FXML
    public TableColumn stockSupplierTC;
    //库存变动列表 仓库
    @FXML
    public TableColumn stockWarehouseTC;
    //库存变动列表 操作员
    @FXML
    public TableColumn stockOperaterTC;
    //库存变动列表 入库商品
    @FXML
    public TableColumn stockGoodsTC;
    //库存变动列表 总额
    @FXML
    public TableColumn stockTotalPriceTC;
    //库存变动列表 备注
    @FXML
    public TableColumn stockRemarkTC;









    //右上角“登出”按钮
    @FXML
    public Button logoutButton;

    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;
}
