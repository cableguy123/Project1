package commands;

import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class LoginCommand extends AbstractCommand {
    @Override
    public void execute(RequestContext req, ResponseContext res) {
        String email = req.getParameter("email")[0];
        String password = req.getParameter("password")[0];
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        userBean userBean = userDataDAO.getRecord(email);
        if (email.equals(userBean.getLogin_mailAddress()) && password.equals(userBean.getLogin_password())) {
            if (userBean.getUser_gender() == null || userBean.getUser_age() == 0 || userBean.getUser_height() == 0.0 || userBean.getUser_weight() == 0.0) {
                req.setAttributeInSession("userBean",userBean);
                System.out.println("LoginCommand userid =" + userBean.getUser_id());
                res.setRedirect("/data_input.jsp?id=" + userBean.getUser_id());
            } else {
                req.setAttributeInSession("userBean", userBean);
                res.setRedirect("/main.jsp?id=" + userBean.getUser_id());
            }
        } else {
            res.setRedirect("/login.html?miss");
        }
    }
}
