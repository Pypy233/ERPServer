package ui.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {


    //登录按钮
    @FXML
    public Button loginButton;
    //注册按钮（跳转注册页面）
    @FXML
    public Button toRegisterButton;
    //修改密码按钮（跳转修改密码页面）
    @FXML
    public Button codeModifyButton;

    //用户名输入框
    @FXML
    public TextField adminNameTF;
    //密码输入框
    @FXML
    public TextField adminCodeTF;



    //返回上一层按钮
    @FXML
    public Button backButton;


}
