package commands;

import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class passwordCommand extends AbstractCommand{
    @Override
    public void execute(RequestContext req,ResponseContext res) {
        String password = req.getParameter("password")[0]; 
        String new_password = req.getParameter("new_password")[0];
        String new_change_password = req.getParameter("new_change_password")[0];
        String user_id = req.getParameter("user_id")[0];
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        userBean userBean = userDataDAO.getRecord(Integer.parseInt(user_id));
        userBean userBean2 = userDataDAO.selectPassword(Integer.parseInt(user_id));
        if(password.equals(userBean2.getLogin_password()) && new_password.equals(new_change_password)) {
            int flag = userDataDAO.updatePassword(new_password,Integer.parseInt(user_id));    
            System.out.println(flag);
            req.setAttributeInSession("userBean", userBean);
            System.out.println("passwordCommand id value =" + userBean.getUser_id());
            res.setRedirect("/main.jsp?id=" + userBean.getUser_id()); 
        }else if(password.equals(userBean2.getLogin_password()) == false) {
            res.setRedirect("/account.jsp?id=" + userBean.getUser_id());
            System.out.println("User_id2" + userBean.getUser_id());
        }else if(new_password.equals(new_change_password) != false) {
            res.setRedirect("/account.jsp?id=" + userBean.getUser_id());
            System.out.println("User_id3" + userBean.getUser_id());
        }

    }
}
