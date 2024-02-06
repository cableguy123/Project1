package commands;

import bean.RegistUser;
import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class RegistUserCommand extends AbstractCommand {

    @Override
    public void execute(RequestContext req,ResponseContext res) {
        String email = req.getParameter("email")[0];
        String password = req.getParameter("password")[0];
        RegistUser registUser = new RegistUser();
        registUser.setLogin_mailAddress(email);
        registUser.setLogin_password(password);
        userRegist(registUser);
        res.setTarget("fn/login");
    }
    private int userRegist(RegistUser registUser) {
        UserDataDAO dao = UserDataDAO.getInstance();
        int flag = dao.InsertUser(registUser.getLogin_mailAddress(), registUser.getLogin_password());
        return flag;

    }
   
}
