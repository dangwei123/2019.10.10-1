1.三枚石子放置在数轴上，位置分别为 a，b，c。

每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。

当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr={0,0};
        if(a>c){
            int tmp=a;
            a=c;
            c=tmp;
        } if(b>c){
            int tmp=b;
            b=c;
            c=tmp;
        } if(a>b){
            int tmp=a;
            a=b;
            b=tmp;
        }
        if(b-a==1&&c-b==1){
            arr[0]=0;
            arr[1]=c-a-2;
            return arr;
        }if(b-a<=2||c-b<=2){
            arr[0]=1;
            arr[1]=c-a-2;
            return arr;
        }else{
            arr[0]=2;
            arr[1]=c-a-2;
            return arr;
        }
    }
}

2.
给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。

示例:

输入:
[1,2,3]

输出:
3

解释:
只需要3次移动（注意每次移动会增加两个元素的值）：

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int a=nums[0];
        int sum=0;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i]-a;
        }
        return sum;
    }
}
3.
给定一个未经排序的整数数组，找到最长且连续的的递增序列。
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int maxlen=0;
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                len++;
            }else{
                len=1;
            }if(maxlen<len){
                maxlen=len;
            }
        }
        return maxlen;
    }
}

4.
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxlen=0;
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
             int len=0;
            for(int j=nums.length-1;j>=0;j--){
               if(nums[j]-nums[i]==1){
                   len++;
                   flag=1;
               }if(flag==1&&nums[j]-nums[i]==0){
                   len++;
               }if(nums[j]-nums[i]<0){
                   flag=0;
                   break;
               }
            }if(maxlen<len){
                maxlen=len;
            }
        }
        return maxlen;
    }
}