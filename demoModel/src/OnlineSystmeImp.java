import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class OnlineSystmeImp implements OnlineSystem {
    //用于记录用户停留时间
    private ConcurrentHashMap<Integer, PopularCategory> map = new ConcurrentHashMap<Integer, PopularCategory>();

    public void pageIn(int id, String category, double t) {
        PopularCategory popularCategory = new PopularCategory(id, category, 0);
        popularCategory.login(t);
        map.put(id, popularCategory);

    }

    public void pageOut(int id, String category, double t) {
        if (map.get(id) != null) {
            PopularCategory popularCategory = map.get(id);
            popularCategory.outLogin(t);
        }
    }

    public String getMostPopularCategory() {
        Map<String,Double> polularMap = new HashMap<String,Double>(8);
        Set<Integer> set = map.keySet();
        //计算 所有类行的总停留时间
        for (Integer key : set) {
            String type = map.get(key).getType();
            if (polularMap.get(type) == null) {
                polularMap.put(map.get(key).getType(),map.get(key).getPopularNum());
            }else {
                Double popularNum = polularMap.get(type);
                polularMap.put(type,popularNum + map.get(key).getPopularNum());
            }
        }
        //并计算出值最大的类型
        return getMax(polularMap);

    }


    private String getMax(Map<String,Double> polularMap){
        Set<String> set = polularMap.keySet();
        double currentValue = 0;
        String currentType = "";
        //计算 所有类行的总停留时间最大值
        for (String type : set) {
            double value = polularMap.get(type);
            if(value > currentValue){
                currentValue = value;
                currentType = type;
            }
        }
        return currentType;
    }
}
