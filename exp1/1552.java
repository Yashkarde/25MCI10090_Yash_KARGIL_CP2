class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length-1]-position[0]) / (m-1);
        int ans = 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canweplace(position,mid,m)){
                ans= mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public boolean canweplace(int[] arr, int dist,int cows){
        int countcows = 1;
        int last = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=dist){
                countcows++;
                last = arr[i];
            }
            if(countcows>=cows){
                return true;
            }
        }
        return false;
    }
}