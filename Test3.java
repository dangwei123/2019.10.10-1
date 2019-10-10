1.
你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/long-pressed-name
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i<name.length()&&j<typed.length()){
            char c1=name.charAt(i);
            char c2=typed.charAt(j);
            if(c1==c2){
                i++;
                j++;
            }else if(j>0&&c2==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        while(j<typed.length()){
            if(typed.charAt(j)!=typed.charAt(j-1)){
                return false;
            }
            j++;
        }
        return i==name.length()&&j==typed.length();
    }
}

2.
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }if(count>nums.length/2){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}

3.
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
      int tmp=x;
      int count=0;
        while(tmp!=0){
            count++;
            tmp/=10;
        }
        int[] arr=new int[count];
        tmp=x;
        int i=0;
        while(tmp!=0){
            arr[i]=tmp%10;
            tmp/=10;
            i++;
        }
        int left=0;
        int right=count-1;
        while(left<=right){
            if(arr[left]==arr[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
4.
对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。

给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==0||num==1){
            return false;
        }
        int sum=0;
        for(int i=2;i<num/i;i++){
            if(num%i==0){
                sum+=i+num/i;
            }
        }
            return num-sum==1;
    }
}