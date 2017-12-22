package ui.sale;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class saleMemberKindSearchController {

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





    //客户类别 进货商 选择box
    @FXML
    public CheckBox supplierCB;
    //客户类别 销售商 选择box
    @FXML
    public CheckBox retailerCB;


    //客户业务员 PY 选择box
    @FXML
    public CheckBox salesmanPYCB;
    //客户业务员 PG ZERO 选择box
    @FXML
    public CheckBox salesmanPGZeroCB;
    //客户业务员 PG TWO 选择box
    @FXML
    public CheckBox salesmanPGTwoCB;



    //客户等级 5级 选择box
    @FXML
    public CheckBox levelFiveCB;
    //客户等级 4级 选择box
    @FXML
    public CheckBox levelFourCB;
    //客户等级 3级 选择box
    @FXML
    public CheckBox levelThreeCB;
    //客户等级 2级 选择box
    @FXML
    public CheckBox levelTwoCB;
    //客户等级 1级 选择box
    @FXML
    public CheckBox levelOneCB;


    //查询 按钮
    @FXML
    public Button memberKindSearchButton;




    //客户信息查询列表
    @FXML
    public TableView memberKindSearchTV;

    //客户信息查询列表 ID栏
    @FXML
    public TableColumn memberIDTC;
    //客户信息查询列表 名称栏
    @FXML
    public TableColumn memberNameTC;
    //客户信息查询列表 类别栏
    @FXML
    public TableColumn memberKindTC;
    //客户信息查询列表 级别栏
    @FXML
    public TableColumn memberLevelTC;
    //客户信息查询列表 业务员栏
    @FXML
    public TableColumn memberDefaultSalesmanPriceTC;









    //右上角 登出 按钮
    @FXML
    public Button logoutButton;
    //右下角 返回上一层 按钮
    @FXML
    public Button backButton;
}
