1.
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
返回其最大和。
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxsum=nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        return maxsum;
    }
}

2.
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }
}

3.
如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotonic-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A[0]>A[A.length-1]){
             for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1]){
                return false;
            }
        }
            return true;
        }else{
            for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1]){
                return false;
            }
        }
            return true;
        }
       
    }
}
4.
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
class Solution {
    public int missingNumber(int[] nums) {
        int f3=nums.length;
        for(int i=0;i<nums.length;i++){
            f3^=nums[i];
            f3^=i;
        }
        return f3;
    }
}