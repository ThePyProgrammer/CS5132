import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for(int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i]))
                return new int[]{map.get(array[i]), i};
            map.put(target - array[i], i);
        }
        return new int[]{};
    }

    public int[] twoSumSorted(int[] array, int target) {
        // Here we know that it is sorted, so that's great!
        int a_pointer = 0, b_pointer = array.length-1, sum;
        while(a_pointer <= b_pointer) {
            sum = array[a_pointer]+array[b_pointer];
            if(sum < target) a_pointer++;
            else if(sum > target) b_pointer--;
            else return new int[]{a_pointer, b_pointer};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(arr1, 9)));
        System.out.println(Arrays.toString(twoSum.twoSumSorted(arr1, 9)));
    }
}
