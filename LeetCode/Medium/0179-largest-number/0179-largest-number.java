class Solution {


    static public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String case1 = o1+o2;
            String case2 = o2+o1;


            return -case1.compareTo(case2);
        }
    }

    public String largestNumber(int[] nums) {

        int N = nums.length;
        String[] arr = new String[N];
        for(int i = 0 ; i<N;i++){
            arr[i] = Integer.toString(nums[i]);
        }
        // primitive -> Reference

        Arrays.sort(arr,new MyComparator()); 
        StringBuilder sb = new StringBuilder();

        boolean isAllZero = true;

        for(String str : arr){
            sb.append(str);
            if(!str.equals("0")){
                isAllZero = false;
            }
        }

        if(isAllZero){
            return "0";
        }

        return sb.toString();

        
    }
}