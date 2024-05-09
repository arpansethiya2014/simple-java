
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentCollections {

	public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }
	
	public static void main(String[] args) {
		 int[] nums = {2, 6, 3, 1, 4, 7};
	        int target = 15;
	        
	        int[] result = findTwoSum(nums, target);
	        
	        if (result[0] != -1) {
	            System.out.println("Output: [" + result[0] + "," + result[1] + "]");
	        } else {
	            System.out.println("No solution found.");
	        }
	}

}
