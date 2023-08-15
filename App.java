import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class App {
    public static List<Integer> findMaxSumSubseq(int[] seq) {
        int n = seq.length;
        int[] maxSum = Arrays.copyOf(seq, n);
        
        int maxIncreasingsequencesum = 0;
        int maxSumIndex = 0;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(seq[i] > seq[j] &&  maxSum[i] < maxSum[j] + seq[i]) {
                    maxSum[i] = seq[i] + maxSum[j];

                    if(maxSum[i] > maxIncreasingsequencesum) {
                           maxIncreasingsequencesum = maxSum[i];
                           maxSumIndex = i;
                    }
                }
            }
        }

         ArrayList <Integer> subsequence = new ArrayList<Integer>();
         int currentSum= maxIncreasingsequencesum;

         for(int i = maxSumIndex ; i >= 0 ; i--){
            if(currentSum == maxSum[i]){
                subsequence.add(seq[i]);
                currentSum = currentSum - seq[i];
            }
         }
        Collections.reverse(subsequence);

        return subsequence;
    }

    public static void main(String[] args){
        int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        List<Integer> result = findMaxSumSubseq(sequence);
        System.out.println("Maximum Sum Increasing Subsequence: " + result);
    }
}

