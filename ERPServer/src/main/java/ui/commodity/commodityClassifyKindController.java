package ui.commodity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class commodityClassifyKindController {


    //左侧“商品分类”按钮
    @FXML
    public Button classifyButton;
    //左侧“商品管理”按钮
    @FXML
    public Button goodsButton;
    //左侧“库存”按钮
    @FXML
    public Button stockButton;





    //类别列表
    @FXML
    public TableView kindTV;

    //类别列表 id栏
    @FXML
    public TableColumn kindIDTC;
    //类别列表 类别栏
    @FXML
    public TableColumn kindKindTC;
    //类别列表 描述栏
    @FXML
    public TableColumn kindDescriptionTC;




    //添加商品分类ID栏
    @FXML
    public TextField kindIDTF;
    //添加商品分类类别栏
    @FXML
    public TextField kindNameTF;
    //添加商品分类描述栏
    @FXML
    public TextField kindDescriptionTF;

    //“添加分类”按钮
    @FXML
    public Button addKindButton;






    //右上角“登出”按钮
    @FXML
    public Button logoutButton;

    //右下角“返回上一层”按钮
    @FXML
    public Button backButton;




}
