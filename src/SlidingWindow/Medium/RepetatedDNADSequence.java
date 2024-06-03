package SlidingWindow.Medium;

import java.util.*;

public class RepetatedDNADSequence {
    public static void main(String[] args) {
       RepetatedDNADSequence repetatedDNADSequence = new RepetatedDNADSequence();
       repetatedDNADSequence.findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    public List<String> findRepeatedDnaSequences(String s) {
      int n =s.length();
      int leftIndex=0;
      int rightIndex=0;

        Set<Character> dnaSets =new HashSet<>();
        dnaSets.add('A');
        dnaSets.add('C');
        dnaSets.add('G');
        dnaSets.add('T');

        List<String> result = new ArrayList<>();
        Map<String,Integer> tempDNA = new HashMap<>();



      for(;rightIndex<=n-10;++rightIndex){
          StringBuilder sb = new StringBuilder();
          for(int i=leftIndex;i<Math.min(leftIndex+10,n);i++){
             if(!dnaSets.contains(s.charAt(i))){
                 break;
             }
             sb.append(s.charAt(i));
          }
          ++leftIndex;
          String dnaSubString = sb.toString();
          if(dnaSubString.length() >=10){
              tempDNA.put(dnaSubString,tempDNA.getOrDefault(dnaSubString,0)+1);
          }
      }

      for(Map.Entry<String,Integer> entry: tempDNA.entrySet()){
          if(entry.getValue() >=2){
              result.add(entry.getKey());
          }
      }

      return result;
    }
}
