package bean;
import java.io.Serializable;
public class userBean implements Serializable {
    private int user_id;
    private String login_mailAddress;
    private String login_password;
    private String user_gender;
    private int user_age;
    private double user_height;
    private double user_weight;
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setLogin_mailAddress(String login_mailAddress) {
       this.login_mailAddress = login_mailAddress;
    }
    public String getLogin_mailAddress() {
        return login_mailAddress;
    }
    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }
    public String getLogin_password() {
        return login_password;
    }
    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }
    public String getUser_gender() {
        return user_gender;
    }
    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }
    public int getUser_age() {
        return user_age;
    }
    public void setUser_height(double user_height) {
        this.user_height = user_height;
    }
    public double getUser_height() {
        return user_height;
    }
    public void setUser_weight(double user_weight) {
        this.user_weight = user_weight;
    }
    public double getUser_weight() {
        return user_weight;
    }
}
