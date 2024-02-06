package bean;

import java.util.Date;
import java.io.Serializable;
public class resultsBean implements Serializable {
    private int user_id;
    private Date meal_date;
    private double meal_calories;
    private double bmr;
    private double tdee;
    private String result;
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setMeal_date(Date meal_date) {
        this.meal_date = meal_date;
    }
    public Date getMeal_date() {
        return meal_date;
    }
    public void setMeal_calories(double meal_calories) {
        this.meal_calories = meal_calories;
    }
    public double getMeal_calories() {
        return meal_calories;
    }
    public void setBmr(double bmr) {
        this.bmr = bmr;
    }
    public double getBmr() {
        return bmr;
    }
    public void setTdee(double tdee) {
        this.tdee = tdee;
    }
    public double getTdee() {
        return tdee;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
}
