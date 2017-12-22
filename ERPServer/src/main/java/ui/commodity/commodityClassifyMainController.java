package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class commodityClassifyMainController {

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


    //下面跳转 “商品分类 商品类别.fxml”按钮
    @FXML
    public Button toClassifyButton;

    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;

}
