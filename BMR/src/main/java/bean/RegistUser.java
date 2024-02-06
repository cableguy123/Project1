package bean;
import java.io.Serializable;
public class RegistUser implements Serializable {
    public RegistUser() {

    }
    private String login_mailAddress;
    private String login_password;
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
}