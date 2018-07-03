/**
 * 保存预约的javabean
 * 2018/07/02
 * by keith
 */
package bean;

public class Reservation {
    private int R_id;
    private String R_name;
    private String R_tel;
    private int R_sum;
    private String R_date;
    private String R_time_start;
    private String R_time_end;
    private String E_time_start;
    private String E_time_end;
    private String T_id;
    private int R_pay;
    private boolean R_isWalkin;
    private String R_comment;
    private boolean R_isOver;

    public void setE_time_end(String e_time_end) {
        E_time_end = e_time_end;
    }

    public void setE_time_start(String e_time_start) {
        E_time_start = e_time_start;
    }

    public void setR_date(String r_date) {
        R_date = r_date;
    }

    public void setR_comment(String r_comment) {
        R_comment = r_comment;
    }

    public void setR_id(int r_id) {
        R_id = r_id;
    }

    public void setR_isWalkin(boolean r_isWalkin) {
        R_isWalkin = r_isWalkin;
    }

    public void setR_name(String r_name) {
        R_name = r_name;
    }

    public void setR_pay(int r_pay) {
        R_pay = r_pay;
    }

    public void setR_sum(int r_sum) {
        R_sum = r_sum;
    }

    public void setR_tel(String r_tel) {
        R_tel = r_tel;
    }

    public void setR_time_end(String r_time_end) {
        R_time_end = r_time_end;
    }

    public void setR_time_start(String r_time_start) {
        R_time_start = r_time_start;
    }

    public void setT_id(String t_id) {
        T_id = t_id;
    }

    public int getR_id() {
        return R_id;
    }

    public int getR_pay() {
        return R_pay;
    }

    public String getE_time_end() {
        return E_time_end;
    }

    public String getE_time_start() {
        return E_time_start;
    }

    public String getR_comment() {
        return R_comment;
    }

    public String getR_date() {
        return R_date;
    }

    public String getR_name() {
        return R_name;
    }

    public int getR_sum() {
        return R_sum;
    }

    public String getR_tel() {
        return R_tel;
    }

    public String getR_time_end() {
        return R_time_end;
    }

    public String getR_time_start() {
        return R_time_start;
    }

    public String getT_id() {
        return T_id;
    }

    public boolean isR_isWalkin() {
        return R_isWalkin;
    }

    public void setR_isOver(boolean r_isOver) {
        R_isOver = r_isOver;
    }

    public boolean isR_isOver() {
        return R_isOver;
    }
}


