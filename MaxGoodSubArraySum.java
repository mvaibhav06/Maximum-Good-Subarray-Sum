public class MaxGoodSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Long> temp = new HashMap<>();
        long sum1 = 0;

        for(int i=0; i<nums.length; i++){
            sum1 += nums[i];
        }

        for(int i=0; i<nums.length; i++){
            if(i==0){
                temp.put(i, sum1);
            }else{
                temp.put(i, temp.get(i-1)-nums[i-1]);
            }
        }

        long max = Integer.MIN_VALUE;
        long sum = 0;

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(Math.abs(nums[j]-nums[i]) == k){
                    sum = temp.get(i) - temp.get(j) + nums[j];
                    if(max < sum){
                        max = sum;
                    }
                }
            }
            sum = 0;
        }
        if(max == Integer.MIN_VALUE){
            max = 0;
        }
        return max;
    }
}
