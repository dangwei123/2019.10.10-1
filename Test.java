1.
在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int dominantIndex(int[] nums) {
        int max=nums[0];
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
                n=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i==n){
                continue;
            }
            if(max<2*nums[i]){
                return -1;
            }
        }
        return n;
    }
}

2.
给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length];
        
        for(int i=0;i<nums1.length;i++){
           int j=0;
            for( j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                     int a=0;
                    for(a=j+1;a<nums2.length;a++){
                        if(nums1[i]<nums2[a]){
                            arr[i]=nums2[a];
                            break;
                        }
                    }
                    if(a==nums2.length){
                arr[i]=-1;
                        break;
             }
                }
            }
        }
        return arr;
    }
}
3.
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1=nums[0]*nums[1]*nums[nums.length-1];
        int max2=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return Math.max(max1,max2);
    }
}

4.
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxsum=0;
        int flag=1;
        for(int i=0;i+k<=nums.length;i++){
              double sum=0;
            for(int j=i;j<i+k;j++){
                sum+=nums[j];
            }
            if(flag==1){
                maxsum=sum;
                flag=0;
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        return maxsum/k;
    }
}