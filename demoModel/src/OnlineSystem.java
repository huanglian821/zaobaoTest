interface  OnlineSystem {
    /**
     *
     * @param id  用户id
     * @param category 类别 real
     * @param t 时间
     */
    public void pageIn(int id,String category,double t);

    public void pageOut(int id,String category,double t);

    public String getMostPopularCategory();

}
