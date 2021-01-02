public class Solution {
    public static int addDigits(int num){//我的方法，但是太冗余了
        if(num<10) return num;
        int i=0;
        while(num>=Math.pow(10,i)){
            ++i;
        }
        int[] nums=new int[i];
        for(int k=0;k<i;k++){
            nums[k]= (int) (num%Math.pow(10,k+1));
            num /=(int) (Math.pow(10,k+1));
        }
        num=0;
        for(int eachnum:nums){
            num+=eachnum;
        }
        return addDigits(num);
    }
    public static int addDigits2(int num){//利用数论的方法
        return (num-1)%9+1;//可以看题解，非常巧妙
    }
}
