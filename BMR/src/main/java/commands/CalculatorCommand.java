package commands;

import javax.servlet.RequestDispatcher;

import bean.Calculator;
import bean.resultsBean;
import bean.userBean;
import db.dao.MealDataDAO;
import db.dao.UserDataDAO;
import framework.command.AbstractCommand;
import framework.context.RequestContext;
import framework.context.ResponseContext;

import java.util.List;
public class CalculatorCommand extends AbstractCommand{
    @Override
    public void execute(RequestContext req,ResponseContext res) {
        res.setContentType("text/html; charset=UTF-8");
        String user_id = req.getParameter("user_id")[0];
        String activity_level = req.getParameter("activity_level")[0];
        String calories = req.getParameter("calories")[0]; 
        UserDataDAO userDataDAO = UserDataDAO.getInstance();
        MealDataDAO mealDataDAO = MealDataDAO.getInstance();       
        List<resultsBean> resultList = mealDataDAO.ShowResultData(Integer.parseInt(user_id));
        userBean userBean = userDataDAO.getRecord(Integer.parseInt(user_id));
        if(activity_level != null && calories != null) {
            mealDataDAO.getUserData(Integer.parseInt(user_id)); 
            mealDataDAO.InsertData(Integer.parseInt(user_id), activity_level, calories); 
            resultList = mealDataDAO.ShowResultData(Integer.parseInt(user_id));
            req.setAttributeInSession("resultsList",resultList);
            req.setAttributeInSession("userBean", userBean);
            System.out.println("CalculatorCommand id value =" + userBean.getUser_id());
            res.setRedirect("/result.jsp?id=" + userBean.getUser_id());
        }else {
            res.setRedirect("/main.jsp?id=" + userBean.getUser_id());
        }
    }
}