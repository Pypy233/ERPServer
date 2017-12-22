package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class commodityGoodsEditController {

    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;



    //商品编号 信息
    @FXML
    public TextArea goodsIDTA;
    //商品名称 信息
    @FXML
    public TextArea goodsNameTA;
    //商品库存 信息
    @FXML
    public TextArea goodsStockTA;
    //商品类型 信息
    @FXML
    public TextArea goodsKindTA;
    //商品进价 信息
    @FXML
    public TextArea goodsStockPriceTA;
    //商品零售价 信息
    @FXML
    public TextArea goodsSalePriceTA;
    //商品最新进价 信息
    @FXML
    public TextArea goodsRecentStockPriceTA;
    //商品最新零售价 信息
    @FXML
    public TextArea goodsRecentSalePriceTA;



    //“编辑资料”按钮
    @FXML
    public Button goodsEditButton;
    //“保存修改”按钮
    @FXML
    public Button goodsModifyConfirmButton;
    //“删除商品”按钮
    @FXML
    public Button goodsDeleteButton;



    //右上角“登出”按钮
    @FXML
    public Button logoutButton;
    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;
}
