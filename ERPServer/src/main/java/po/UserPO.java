package po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户类，包括库存管理人员，进货销售人员，财务人员，总经理
 */
@Entity(name = "User")
public class UserPO implements Serializable {

    /**
     * 用户职位
     */
    private String type;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * *登录状态
     */
    private boolean login;


    public UserPO() {
    }

    public UserPO(String type, String name, String password, boolean login) {
        this.type = type;
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public UserPO(String type, String name, String password) {
        this.type = type;
        this.name = name;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}