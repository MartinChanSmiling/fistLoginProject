/**
 * Created by MartinCheng on 2017/4/28.
 */
public class UserVO {
    private int id;
    private String name;
    private String pwd;

    public UserVO() {

    }

    public UserVO(String name, String pwd) {
        super();
        this.name = name;
        this.pwd = pwd;
    }

    public UserVO(int id, String name, String pwd) {
        super();//调用父类构造函数?
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}

//建立包含数值的Entity，以及和Entity相关的调用和设置操作。