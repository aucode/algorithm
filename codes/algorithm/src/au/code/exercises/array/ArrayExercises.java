package au.code.exercises.array;


public class ArrayExercises {

    public static void main(String[] args) {


        /*
            remove repeat.

        int[] nums = {1,2,3};
        int count = removeRepeat(nums);
        for (int i = 0;i < count;i++) {
            System.out.println(nums[i]);
        }
        */

        /*
            max profit.

        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));

         */

        /*
            Rotation array
         */
        rotate(new int[]{4,7}, 3);
    }

    /**
     * Rotation array return nums type is array.
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k){
/*
    47,7181,6618,61

 */
        if (nums == null || nums.length == 0 || nums.length == 1 || k == 0) return ;

        int length = nums.length;
        int start = (length > k)?length - k:k-length;
        int index = 0;
        int[] temp = new int[k];
        while (start < length) {
            temp[index++] = nums[start++];
        }

        for (int i = length - k - 1;i >= 0;i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0;i < temp.length;i++) {
            nums[i] = temp[i];
        }
        for (int i = 0;i < nums.length;i++) {
            System.out.println(nums[i]);
        }

    }

    /**
     * remove repeat value of array. return int is array index.
     * @param nums
     * @return
     */
    public static int removeRepeat(int[] nums){

        if (nums == null || nums.length == 0) {

            return 0;
        }

        int left = 0;
        for (int right = 1;right < nums.length;){
            if (nums[left] != nums[right]) {

                nums[++left] = nums[right++];
            }else{

                right++;
            }
        }
        return ++left;

//        {0,0,1,1,1,2,2,3,3,4}
//        int j=0,max=nums[0];
//        for(int i=1;i<nums.length;i++)
//            if(max==nums[i]) continue;
//            else {nums[++j]=nums[i];
//                max=nums[i];}
//        return j;

    }

    /**
     * return value type is int.
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int length = prices.length,total = 0;
        boolean flag = false;

        for (int i = 1;i < length;) {
            while (!flag && i < length) {

                /*
                    find best buy point.
                 */
                if (prices[i - 1] < prices[i]) {

                    total -= prices[i - 1];
                    flag = true;
                    System.out.printf("在第 %d 天（股票价格 = %d）的时候买入\n",(i),prices[i - 1]);
                }
                i++;
            }
            while (flag && i < length) {

                /*
                    find best selling point.
                 */
                if (prices[i - 1] > prices[i]) {

                    total += prices[i - 1];
                    flag = false;
                    System.out.printf("在第 %d 天（股票价格 = %d）的时候卖出\n",(i),prices[i - 1]);
                }
                i++;
            }
        }

        if (flag) {
            total += prices[length-1];
            System.out.printf("在第 %d 天（股票价格 = %d）的时候卖出\n",(length),prices[length-1]);
        }
        return total;

    }



}
