package commands;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            UserDataDAO userDataDAO = UserDataDAO.getInstance();
            userBean userBean = userDataDAO.getRecord(email);
            RegistUser registUser = new RegistUser();
            registUser.setLogin_mailAddress(email);
            registUser.setLogin_password(password);
            int flag = userRegister(registUser);
            if (userBean != null && userBean.getLogin_mailAddress() != null) {
                res.setRedirect("/createUser.jsp");
            } else if (flag != -1) {
                userBean = userDataDAO.getRecord(email); 
                req.setAttributeInSession("userBean", userBean);
                res.setTarget("/data_input.jsp?id=" + userBean.getUser_id());

            } else {
                res.setRedirect("/createUser.jsp");
            }

        }
        public int userRegister(RegistUser registUser) {
            UserDataDAO dao = UserDataDAO.getInstance();
            int flag = dao.InsertUser(registUser.getLogin_mailAddress(),registUser.getLogin_password());
            return flag;
        }
    }
