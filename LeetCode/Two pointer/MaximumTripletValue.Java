class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            while(j < nums.length && nums[i] < nums[j]){
                j++;
            }
            for(int k = j + 1; k < nums.length; k++){
                max = Math.max(max, (long)(nums[i] - nums[j]) * nums[k]);
                if(nums[j] > nums[k]){
                    j = k;
                }
            }
        } 
        return max;
    }
}
