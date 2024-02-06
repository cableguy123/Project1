package commands;

import bean.resultsBean;
import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class LoginCommand extends AbstractCommand {
    @Override
    public void execute(RequestContext req,ResponseContext res) {
        String email = req.getParameter("email")[0];
        String password = req.getParameter("password")[0];
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        userBean userBean = userDataDAO.getRecord(email);
        if(userBean.getLogin_password() != null) {
            req.setAttributeInSession("bean" + userBean.getUser_id(),userBean); 
            res.setRedirect("/main.jsp"  + "?id=" + userBean.getUser_id());
        }else {
            res.setRedirect("/login.html");
        }

    }
}
