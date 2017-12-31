package po;
/**
 * 记录日志的数据类
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity(name = "Log")
public class LogPO implements Serializable{
    /**
     * 日志的非实际id
     */
    private int id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 日志日期
     */
    private String date;


    /**
     * 记录具体操作
     */
    private String operation;

    /**
     * 记录操作结果
     */
    private String result;

    public LogPO() {
    }

    public LogPO(int id, String name, String date, String operation, String result) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.operation = operation;
        this.result = result;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
