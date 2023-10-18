import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


//public static void main(String[] args) {
////        ["U1,Shanghai,NewYork,Paris,Dallas",
////                "U2,Chicago,London,Paris,Dallas",
////                "U3,Rio,London,Philly",
////                "U4,Brunswick,NewHope,Princeton,Paris",
////                "U5,Shanghai,NewYork,Paris,Dallas"]
//        List<String> infos = new ArrayList<>();
//        infos.add("U1,Shanghai,NewYork,Paris,Dallas");
//        infos.add("U2,Chicago,London,Paris,Dallas");
//        infos.add("U3,Rio,London,Philly");
//        infos.add("U4,Brunswick,NewHope,Princeton,Paris");
//        infos.add("U5,Shanghai,NewYork,Paris,Dallas");
//        findFriends f = new findFriends();
//        List<String> ls = f.findFriends("U1", infos);
//        System.out.println(ls.toString());
//        }
public class findFriends {
        /**
        * @Description: This Alogrithom is about to find the friends who can travl with the user. Who has the most common city with us who gone be our friends to
            travl.
        * @Param: user and a List<String> info
        * @return: A List which is sorted with the most commend travl cities with us.
        * @Author: Xuanlin Guan
        */
    public List<String> findFriends(String user, List<String> info) {
        Map<String, List<String>> cityMap = new HashMap<>();
        Map<String, List<String>> userMap = new HashMap<>();

        for (String s : info) {
            List<String> userandCities =  List.of(s.split(","));
            String u = userandCities.get(0);
            int lenOfString = userandCities.size() - 1;
            for ( int i = 1; i < userandCities.size(); i++) {
                String city = userandCities.get(i);
                cityMap.computeIfAbsent(city, key -> new ArrayList<>()).add(u);
            }
            userMap.put(u, userandCities.subList(1,lenOfString + 1));
        }

        List<String> travlCities = userMap.get(user);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())
        );;

        Map<String, Integer> count = new HashMap<>();

        for (String city : travlCities) {
            List<String> users = cityMap.get(city);
            for (String use : users) {
                if (!use.equals(user)) {
                    count.compute(use, (k, v) -> (v == null) ? 1 : v + 1);
                }
            }
        }
        maxHeap.addAll(count.entrySet());

        List<String> ans = new ArrayList<>();
        // 从最大堆中取出排序后的结果
        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = maxHeap.poll();
            ans.add(entry.getKey());
        }

        for (String key : userMap.keySet()) {
            if (!ans.contains(key)) {
                ans.add(key);
            }
        }

        return ans;
    }
}

