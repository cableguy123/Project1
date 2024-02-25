package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Calculator;
import bean.resultsBean;
import bean.userBean;
import db.mysql.mysqlConnection;

import java.util.ArrayList;
public class MealDataDAO {
        private static final String DB_SELECT = "SELECT user_gender,user_age,user_height,user_weight FROM bmr_users WHERE user_id = ?";
        private static final String INSERT_RESULT = "INSERT INTO results(user_id, meal_date, meal_calories, bmr, tdee,result) VALUES(?, ? , ?, ?, ?,?)";
        private static final String SELECT_DATA = "SELECT user_id, meal_date, meal_calories, bmr, tdee, result FROM results WHERE user_id = ? ORDER BY meal_date";
        private PreparedStatement pstmt = null;
        private ResultSet rs = null;
        private static MealDataDAO mealDataDAO = null;
        static {
            mealDataDAO = new MealDataDAO();
        }
        public static final MealDataDAO getInstance() {
            return mealDataDAO;
        }
        private String activity_level = null;
        private String user_gender = null;
        private int user_age = 0;
        private double user_height = 0;
        private double user_weight = 0;
        
        private double bmr;
        private double tdee;
        private String result = null;
        public userBean getUserData(int user_id) {
            userBean userBean = new userBean();
            try {
                Connection cn = mysqlConnection.getConnection();
                pstmt = cn.prepareStatement(DB_SELECT);
                pstmt.setInt(1,user_id);
                rs = pstmt.executeQuery();
                while(rs.next() && rs != null) {
                    user_gender = rs.getString(1);
                    user_age = rs.getInt(2);
                    user_height = rs.getDouble(3);
                    user_weight = rs.getDouble(4);
                    System.out.println("Gender: " + user_gender + "\t" + "Age: " + user_age + "\t" + "Height: " + user_height + "\t" + "Weight: " + user_weight);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }
            return userBean;   
        }
        public int InsertData(int user_id,String activity_level,String calories) {
            Calculator calculator = new Calculator();
            int flag = -1;
            Connection cn = mysqlConnection.getConnection();
            try {
                calculator.setBmr(user_gender,user_age,user_height,user_weight);
                calculator.setTdee(Integer.parseInt(activity_level));
                calculator.setResult(Float.parseFloat(calories));
                }catch(InputMismatchException e) {
                    e.printStackTrace();
                }
                bmr = calculator.getBmr();
                tdee = calculator.getTdee();
                result = calculator.getResult();
                System.out.println("BMR: " + bmr + "\t" + "TDEE: " + tdee + "\t" + "Result: " + result);
                try{
                    if(isValidCalories(calories)) {
                        pstmt = cn.prepareStatement(INSERT_RESULT);
                        pstmt.setInt(1, user_id);
                        pstmt.setTimestamp(2,new java.sql.Timestamp(new java.util.Date().getTime()));
                        pstmt.setString(3, calories);
                        pstmt.setDouble(4, bmr);
                        pstmt.setDouble(5, tdee);
                        pstmt.setString(6, result);
                        flag = pstmt.executeUpdate();
                    }
                }catch(SQLException e) {
                    e.printStackTrace();
                }finally {
                    mysqlConnection.close();
                }
                return flag;
            }
        
        
        public static boolean isValidCalories(String calories) {
            return calories.matches("\\d+") && Integer.parseInt(calories) >= 0 && Integer.parseInt(calories) <= 5000;
        }
        public ArrayList<resultsBean> ShowResultData(int user_id) {
            ArrayList<resultsBean> lists = new ArrayList<>();
            Connection cn = null;
            try {
                cn = mysqlConnection.getConnection();
                pstmt = cn.prepareStatement(SELECT_DATA);
                pstmt.setInt(1, user_id);
                rs = pstmt.executeQuery();
                while(rs.next()) {
                    resultsBean resultsBean = new resultsBean();    
                    resultsBean.setUser_id(rs.getInt("user_id"));
                    resultsBean.setMeal_date(rs.getDate("meal_date"));
                    resultsBean.setMeal_calories(rs.getDouble("meal_calories"));
                    resultsBean.setBmr(rs.getDouble("bmr"));
                    resultsBean.setTdee(rs.getDouble("tdee"));
                    resultsBean.setResult(rs.getString("result"));
                    lists.add(resultsBean);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                mysqlConnection.close();
            }
            return lists;
        }
}
