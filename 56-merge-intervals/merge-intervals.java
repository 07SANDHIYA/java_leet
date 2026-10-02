class Solution {
    public int[][] merge(int[][] intervals) {
      if(intervals.length<=1){
        return intervals;
      } 
      Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
      List<int[]> res=new ArrayList<>(); 
      int start=intervals[0][0];
      int end=intervals[0][1];
      for(int i=1;i<intervals.length;i++){
        int currentStart=intervals[i][0];
        int currentEnd=intervals[i][1];
        if(currentStart<=end){
            end=Math.max(currentEnd,end);
        }
        else{
            res.add(new int[]{start,end});
            start=currentStart;
            end=currentEnd;
        }

      }
      res.add(new int[]{start,end});
    return res.toArray(new int[res.size()][]);
    }
}