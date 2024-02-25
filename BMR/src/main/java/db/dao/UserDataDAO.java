package db.dao;
// user 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import bean.resultsBean;
import bean.userBean;
import db.mysql.mysqlConnection;
import framework.context.ResponseContext;

public class UserDataDAO {
    private static final String DB_SELECT = "SELECT * FROM bmr_users where user_id = ?";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private static UserDataDAO userDataDAO = null;
    static {
        userDataDAO = new UserDataDAO();
    }
    public static final UserDataDAO getInstance() {
        return userDataDAO;
    }
    private UserDataDAO() {

    }
    public ArrayList<userBean> findAll(int user_id) {
        ArrayList<userBean> result = new ArrayList<>();
        try {
            Connection cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(DB_SELECT);
            pstmt.setInt(1, user_id);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                userBean userBean = new userBean();
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setLogin_mailAddress(rs.getString("login_mailAddress"));
                userBean.setLogin_password(rs.getString("login_password"));
                userBean.setUser_gender(rs.getString("user_gender"));
                userBean.setUser_age(rs.getInt("user_age"));
                userBean.setUser_height(rs.getDouble("user_height"));
                userBean.setUser_weight(rs.getDouble("user_weight"));
                result.add(userBean);
            }
        }catch(SQLException e) {    
            e.printStackTrace();
        }finally {
            mysqlConnection.close();
        }
        return result;
    }
    public userBean getUserInfo(String email) {
        String SQL = "SELECT user_gender, user_age, user_height, user_weight FROM bmr_users WHERE login_mailAddress = ?";
        Connection cn = null;
        userBean userBean = new userBean();
        try {
            cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(SQL);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                userBean.setUser_gender(rs.getString("user_gender"));
                userBean.setUser_age(rs.getInt("user_age"));
                userBean.setUser_height(rs.getDouble("user_height"));
                userBean.setUser_weight(rs.getDouble("user_weight"));
                System.out.println("userBean - " + userBean.getUser_gender() + ' ' + userBean.getUser_age() + ' ' + userBean.getUser_height() + ' ' + userBean.getUser_weight());
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnection.close();
        }
        return userBean;
    }
    
    
    public userBean getRecord(String login_mailAddress) {
        String SQL = "SELECT * FROM bmr_users WHERE login_mailAddress = ?";
        userBean userBean = new userBean();
        try {
            Connection cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(SQL);
            pstmt.setString(1,login_mailAddress);
            rs = pstmt.executeQuery();
            if(rs != null && rs.next()) {
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setLogin_mailAddress(rs.getString("login_mailAddress"));
                userBean.setLogin_password(rs.getString("login_password"));
                userBean.setUser_gender(rs.getString("user_gender"));
                userBean.setUser_age(rs.getInt("user_age"));
                userBean.setUser_height(rs.getDouble("user_height"));
                userBean.setUser_weight(rs.getDouble("user_weight"));
            }
        }   catch(SQLException e) {
            e.printStackTrace();
        }   finally {
            mysqlConnection.close();
        }
        return userBean;
    }
    public userBean getRecord(int user_id) {
        String SQL = "SELECT * FROM bmr_users WHERE user_id = ?";
        userBean userBean = new userBean();
        try {
            Connection cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(SQL);
            pstmt.setInt(1, user_id);
            rs = pstmt.executeQuery();
            if (rs != null && rs.next()) {
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setLogin_mailAddress(rs.getString("login_mailAddress"));
                userBean.setLogin_password(rs.getString("login_password"));
                userBean.setUser_gender(rs.getString("user_gender"));
                userBean.setUser_age(rs.getInt("user_age"));
                userBean.setUser_height(rs.getDouble("user_height"));
                userBean.setUser_weight(rs.getDouble("user_weight"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            mysqlConnection.close();
        }
        return userBean;
    }
    public int InsertUser(String login_mailAddress,String login_password) {
        String insert = "INSERT INTO bmr_users (login_mailAddress,login_password) VALUES(?,?)";
        String select = "SELECT login_mailAddress FROM bmr_users";
        String select_id = "SELECT user_id FROM bmr_users WHERE login_mailAddress = ?";
        Connection cn = mysqlConnection.getConnection();
        int flag = -1;
        Statement st = null;
        try {
            System.out.println("INSERT USER!" + login_mailAddress + " " + login_password);
            if(cn == null) {
                System.out.println("Connection is Not Connection");
            }
            st = cn.createStatement();
            rs = st.executeQuery(select);  
            if(rs.next()) {
                rs = null;
                pstmt = cn.prepareStatement(insert);
                pstmt.setString(1,login_mailAddress);
                pstmt.setString(2,login_password);
                int fla = pstmt.executeUpdate(); // Query Execute
                if (fla != -1) {
                    pstmt = cn.prepareStatement(select_id);
                    pstmt.setString(1,login_mailAddress);
                    rs = pstmt.executeQuery();
                    if(rs.next()) {
                        flag = rs.getInt("user_id");
                    }
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            mysqlConnection.close();
        }
        return flag;
    }
    public int InsertData(String user_id,String user_gender,String user_age,String user_height,String user_weight) {
        String SQL = "UPDATE bmr_users SET user_gender = ?, user_age = ?, user_height = ?, user_weight = ? WHERE user_id = ?";
        Connection cn = mysqlConnection.getConnection();
        PreparedStatement pstmt = null;
        int flag = -1;
        try {
            pstmt = cn.prepareStatement(SQL);
            pstmt.setString(1,user_gender);
            pstmt.setString(2,user_age);
            pstmt.setString(3,user_height);
            pstmt.setString(4,user_weight);
            pstmt.setString(5,user_id);
            flag = pstmt.executeUpdate();    
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mysqlConnection.close();
        }
        return flag;
    }
    public userBean selectPassword(int user_id) {
        String SELECT_PASSWORD = "SELECT login_password FROM bmr_users WHERE user_id = ?";
        Connection cn = null;
        PreparedStatement pstmt = null;
        userBean userBean = null;
        try {
            cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(SELECT_PASSWORD);
            pstmt.setInt(1,user_id);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                userBean = new userBean();
                userBean.setLogin_password(rs.getString("login_password"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            mysqlConnection.close();
        }
        return userBean;
    }
    public int updatePassword(String new_password,int user_id) {
        String UPADTE_SQL = "UPDATE bmr_users SET login_password = ?  WHERE user_id = ?";
        Connection cn = null;
        int flag = -1;
        PreparedStatement pstmt = null;
        try {
            cn = mysqlConnection.getConnection();
            pstmt = cn.prepareStatement(UPADTE_SQL);
            pstmt.setString(1,new_password);
            pstmt.setInt(2,user_id);
            flag = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            mysqlConnection.close();
        }
        return flag;
    }
}
