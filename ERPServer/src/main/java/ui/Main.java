package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import rmi.RemoteHelper;
import ui.login.LoginController;
import ui.login.LoginOverviewController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application{

    private Stage stage;
    // 弹窗
    private Stage extraStage;
    private Stage extraStage2;

    // 内部窗口
    private SplitPane rootLayout;

    private Scene scene;
    private final double MINIMUM_WINDOW_WIDTH = 400.0;
    private final double MINIMUM_WINDOW_HEIGHT = 250.0;

    RemoteHelper helper=RemoteHelper.getInstance();

    public Main(){}

    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hotel");
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setResizable(false);
        initUI();
        stage.show();
    }
    public void initUI() {
        try {

            LoginOverviewController loginOverviewController = (LoginOverviewController) replaceSceneContent(
                    "login/初始界面.fxml");
            loginOverviewController.setMain(this);
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * 返回主界面
     */
    public void backtoMain(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("login/初始界面.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            this.scene = new Scene(pane);
            LoginOverviewController overviewController = (LoginOverviewController) loader.getController();
            overviewController.setMain(this);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void gotoLogin(String type) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("login/登录界面.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            this.scene = new Scene(pane);
            LoginController loginController = (LoginController) loader.getController();


            stage.setScene(scene);
            stage.sizeToScene();
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    /**
     * 界面跳转
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane pane = (AnchorPane) loader.load();
        this.scene = new Scene(pane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
