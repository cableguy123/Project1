package bean;

public class Calculator {
    private double bmr;
    private double tdee;
    private String result = null;
    public void setBmr(String user_gender,int user_age,double user_height,double user_weight) {
        if(user_gender.equals("Male")) {
            bmr = 13.397 * user_weight + 4.799 * user_height - 5.677 * user_age + 88.362;
			System.out.println("setBmr =" + bmr);
        } else if(user_gender.equals("Female")) {
            bmr = 9.247 * user_weight + 3.098 * user_height - 4.33 * user_age + 447.593;
			System.out.println("setBmr2 =" + bmr);
        }
    }
    public double getBmr() {
        return bmr;
    }
    public void setTdee(int actLv) {
		if(actLv == 1) {
			tdee = getBmr() * 1.2;
		} else if(actLv == 2) {
			tdee = getBmr() * 1.375;
		} else if(actLv == 3) {
			tdee = getBmr() * 1.55;
		} else if(actLv == 4) {
			tdee = getBmr() * 1.725;
		} else if(actLv == 5) {
			tdee = getBmr() * 1.9;
		}
	}
	public double getTdee() {
		return tdee;
	}
	public void setResult(double calories) {
		if(calories > getTdee()) {
			result = String.format("%.2f",(calories - getTdee())) + " カロリーオーバー";
		} else if(getTdee() > calories) {
			result = String.format("%.2f",(getTdee() - calories)) + " カロリーが足りません。";
		}
	}
	public String getResult() {
		return result;
	}
}
