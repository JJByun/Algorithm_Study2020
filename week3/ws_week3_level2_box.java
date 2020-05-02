import java.lang.Math;

class Solution {
	public long solution(int w,int h) {
        
        //1. 기울기를 구한다
        //2. 최대공약수를 구한다 (시간복잡도 때문에)
            
        double small = (w < h) ? w : h;
        double big = (h > w) ? h : w;
        double incline = big/small;
        long box = 0;
        
        //최대공약수
        int r = 1;
        int v1 = (int)big;
        int v2 = (int)small;
        
        while(r > 0){//유클리드 호제법을 이용한 GCD(최대공약수)구하기
            r = v1 % v2;
            v1 = v2;
            v2 = r;
        }
        r = v1;
        
        // if(w == h){
        //     return (w*h) - w;
        // }
        
        for(int i = 1; i < small/r; i++){ //x값 * 기울기 = 높이
            for(int j = 1; j <= big/r; j++){//높이값
                if(incline*i >= j){
                    box++;
                }
                else
                    break;
            }
        }
        
        box *=2;
        
        //long all = (long)(small * big) - ((int)(small/r * big/r) - box)*r;
            
		return (long)(small * big) - ((int)(small/r * big/r) - box)*r;
	}
}