package commands;

import javax.servlet.http.HttpServlet;

import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class CheckCommand extends AbstractCommand{
    @Override
    public void execute(RequestContext req,ResponseContext res) {
        res.setContentType("text/html; charset=UTF-8");
        String email = req.getParameter("email")[0];
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        userBean userBean = userDataDAO.getRecord(email);
        if(userBean.getLogin_mailAddress() != null) {
            res.getWriter().write("1");  
            
        }else {
            res.getWriter().write("0"); 
        }
    }
    
}
