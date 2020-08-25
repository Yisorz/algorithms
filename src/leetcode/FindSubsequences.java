package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * *@ClassName FindSubsequences
 * *@Description
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * *@Author yeyisen
 * *@Date 2020/8/25 14:27
 * *@Version 1.0
 **/
public class FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2){
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int index = 0; index < nums.length-1; index ++){
            List<Integer> subSequenceList = new ArrayList<>();
            subSequenceList.add(nums[index]);
            //递增值，当发现比当前下标数大的递增值时，将对比值变更为当前递增值
            int tmpNum = nums[index];
            //从当前下标开始，往后查询递增数
            for (int innerIndex = index + 1; innerIndex < nums.length - 1; innerIndex ++) {
                if (nums[innerIndex] >= tmpNum){
                    subSequenceList.add(nums[innerIndex]);
                    tmpNum = nums[innerIndex];
                }
            }
            //子序列长度超过1，存在递增序列
            if (subSequenceList.size() > 1){
                resList.add(subSequenceList);
            }
        }

        return resList;
    }

}
