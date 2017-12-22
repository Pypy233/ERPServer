package po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 管理员类，唯有程序员和最高管理者拥有最高权限修改
 */
@Entity(name = "Admin")
public class AdminPO implements Serializable {
    /**
     * 管理员的id
     */
    private int id;

    /**
     * 管理员的名字
     */

    private String name;

    /**
     * 管理员的密码
     */
    private String password;

    public AdminPO() {
    }

    public AdminPO(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
