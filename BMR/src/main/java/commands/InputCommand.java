package commands;

import bean.Calculator;
import bean.userBean;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

public class InputCommand extends AbstractCommand {
    @Override
    public void execute(RequestContext req, ResponseContext res) {
        String user_id = req.getParameter("user_id")[0];
        String user_gender = req.getParameter("gender")[0];
        String user_age = req.getParameter("age")[0];
        String user_height = req.getParameter("height")[0];
        String user_weight = req.getParameter("weight")[0];
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        int flag = userDataDAO.InsertData(user_id,user_gender, user_age, user_height, user_weight);
        if(flag == 1) {
            userBean userBean = userDataDAO.getRecord(Integer.parseInt(user_id));
            req.setAttributeInSession("userBean", userBean);
            res.setRedirect("/main.jsp?id=" + userBean.getUser_id());
        }else {
            res.setRedirect("/data_input.jsp?miss");
        }
    }
}
