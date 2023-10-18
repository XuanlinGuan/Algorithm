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
        minimumSizeSubarraySum m = new minimumSizeSubarraySum();
        int[] nums1 = new int []{2,3,1,2,4,3};
        int[] nums2 = new int[]{1,4,4};
        System.out.println(m.minSubArrayLen(4, nums2));
    }
}
