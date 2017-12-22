package ui.sale;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class saleMemberInfoSearchController {
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


    //客户编号 文本框
    @FXML
    public TextArea memberIDTA;
    //客户 姓名 文本框
    @FXML
    public TextArea memberNameTA;
    //客户 地址 文本框
    @FXML
    public TextArea memberAddressTA;
    //客户 邮编 文本框
    @FXML
    public TextArea memberPostcodeTA;
    //客户 应收额度 文本框
    @FXML
    public TextArea memberReceivableLimitTA;
    //客户 默认业务员 文本框
    @FXML
    public TextArea memberDefaultSalesmanTA;


    //客户类别 进货商 选择box
    @FXML
    public CheckBox supplierCB;
    //客户类别 销售商 选择box
    @FXML
    public CheckBox retailerCB;



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
    public Button memberInfoSearchButton;




    //客户信息查询列表
    @FXML
    public TableView memberInfoSearchTV;

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
