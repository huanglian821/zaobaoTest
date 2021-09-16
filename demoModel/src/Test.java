public class Test {

    public static void main(String[] args) {
        OnlineSystmeImp onlineSystmeImp = new OnlineSystmeImp();
        onlineSystmeImp.pageIn(3,"realtime",3);
        onlineSystmeImp.pageIn(2,"realtime",8);

        onlineSystmeImp.pageIn(4,"forum",10);

        onlineSystmeImp.pageOut(3,"realtime",4);

        onlineSystmeImp.pageOut(4,"forum",10.5);

        onlineSystmeImp.pageOut(2,"realtime",9);
        System.out.println(onlineSystmeImp.getMostPopularCategory());
        onlineSystmeImp.pageIn(7,"forum",11);

        onlineSystmeImp.pageOut(7,"forum",18);

        System.out.println(onlineSystmeImp.getMostPopularCategory());

    }
}
