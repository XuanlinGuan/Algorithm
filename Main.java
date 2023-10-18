import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        ["U1,Shanghai,NewYork,Paris,Dallas",
//                "U2,Chicago,London,Paris,Dallas",
//                "U3,Rio,London,Philly",
//                "U4,Brunswick,NewHope,Princeton,Paris",
//                "U5,Shanghai,NewYork,Paris,Dallas"]
        List<String> infos = new ArrayList<>();
        infos.add("U1,Shanghai,NewYork,Paris,Dallas");
        infos.add("U2,Chicago,London,Paris,Dallas");
        infos.add("U3,Rio,London,Philly");
        infos.add("U4,Brunswick,NewHope,Princeton,Paris");
        infos.add("U5,Shanghai,NewYork,Paris,Dallas");
        findFriends f = new findFriends();
        List<String> ls = f.findFriends("U1", infos);
        System.out.println(ls.toString());
    }
}
