package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class commodityClassifyKindEditController {
    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;




    //类别名称编辑处
    @FXML
    public TextField kindNameTF;
    //类别描述编辑处
    @FXML
    public TextField kindDescriptionTF;





    //类别列表
    @FXML
    public TableView goodsTV;

    //类别商品列表 id栏
    @FXML
    public TableColumn goodsIDTC;
    //类别商品列表 名称栏
    @FXML
    public TableColumn goodsNameTC;
    //类别商品列表 库存栏
    @FXML
    public TableColumn goodsStockTC;
    //类别商品列表 进价栏
    @FXML
    public TableColumn goodsStockPriceTC;
    //类别商品列表 零售价栏
    @FXML
    public TableColumn goodsSalePriceTC;
    //类别商品列表 最新进价栏
    @FXML
    public TableColumn goodsLatestStockPriceTC;
    //类别商品列表 最新零售价栏
    @FXML
    public TableColumn goodsLatestSalePriceTC;





    //“添加商品”按钮
    @FXML
    public Button addGoodsButton;
    //“确认修改”按钮
    @FXML
    public Button modifyConfirmButton;






    //右上角“登出”按钮
    @FXML
    public Button logoutButton;

    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;

}
