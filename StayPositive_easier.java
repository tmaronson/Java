 public static long minStart(List<Integer> arr) {   
    // Write your code here
        
       long res = 1;
        for(int i = arr.size() -1; i >= 0 ; i--)
        {
             res  -= arr.get(i);
             if (res < 1 ) {
                 res = 1;
            }

        }
        return res;
    }

}