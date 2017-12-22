package ui.sale;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class saleMemberMainController {

    //客户管理 按钮
    @FXML
    public Button memberButton;
    //进货 按钮
    @FXML
    public Button stockInButton;
    //销售 按钮
    @FXML
    public Button saleButton;
    //退货 按钮
    @FXML
    public Button returnButton;



    //查询方式1 按钮
    @FXML
    public Button memberIDSearchButton;
    //查询方式2 按钮
    @FXML
    public Button memberKindSearchButton;
    //查询方式3 按钮
    @FXML
    public Button memberInfoSearchButton;


    //新增客户 按钮
    @FXML
    public Button memberNewButton;




    //右上角 登出 按钮
    @FXML
    public Button logoutButton;
    //右下角 返回上一层 按钮
    @FXML
    public Button backButton;
}
