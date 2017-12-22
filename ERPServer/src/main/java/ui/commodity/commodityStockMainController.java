package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class commodityStockMainController {

    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;


    //右上角“登出”按钮
    @FXML
    public Button logoutButton;


    //下面跳转 “库存 盘点库存.fxml”按钮
    @FXML
    public Button toStockChangeButton;


}
