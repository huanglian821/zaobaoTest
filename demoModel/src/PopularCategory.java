/**
 * 喜好度entity
 */
public class PopularCategory {
    /**
     * 用户
     */
    private int id;
    /**
     * 网页类型
     */
    private String type;

    /**
     * 登录时间
     */
    private double inTiem;

    /**
     * 离开时间
     */
    private double outTime;

    /**
     * 喜好度值  总停留时间
     */
    private double popularNum;

    public String getType(){
        return this.type;
    }

    public double getPopularNum(){
        return this.popularNum;
    }

    PopularCategory(int id, String type, double popularNum) {
        this.id = id;
        this.type = type;
        this.popularNum = popularNum;
    }

    void login(double inTiem) {
        this.inTiem = inTiem;
    }

    void outLogin(double inTiem) {
        this.outTime = inTiem;
        this.popularNum = this.popularNum + (this.outTime - this.inTiem);
    }

    void addPolularNum(double num) {
        this.popularNum = this.popularNum + num;
    }

}
