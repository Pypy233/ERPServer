package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class commodityGoodsMainController {

    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;


    //“查询方式1”按钮
    @FXML
    public Button goodsIDSearchButton;
    //“查询方式1”按钮
    @FXML
    public Button goodsInfoSearchButton;
    //“新增商品”按钮
    @FXML
    public Button goodsNewButton;



    //右上角“登出”按钮
    @FXML
    public Button logoutButton;
    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;

}
