package knowledge_to_java.seminar1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class Task2 {
    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);
 
        return list.toArray(new Integer[0]);
    }
 
    public static void main(String[] args) {
        Integer[] nums = {20, 1, -30, 40, -40};
        Integer[] newList = {};
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0 && nums[i-1] > 0) {
                newList = append(newList, nums[i-1]);
            }
        }
        
        int sum = 0;
        for (int i = 0; i < newList.length; i++) {
            sum += newList[i];
        }
        
        System.out.println("Сумма чисел, после которых идет отрицательное число: " + sum);
    }
}