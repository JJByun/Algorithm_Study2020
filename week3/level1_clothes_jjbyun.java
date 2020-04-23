public class clothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n]; //크기가 n인 배열 0으로 초기화 ->0이면 체육복 있음
        for(int i:lost){
            clothes[i-1]=-1; //옷이 없는 학생들 -1로 바꿔주기
        }
        for(int i:reserve){
            if(clothes[i-1]==0){
                //도난 당하지 않은 학생일 경우
                clothes[i-1]=1;
            }else if(clothes[i-1]==-1){
                //도난 당한 학생일 경우
                clothes[i-1]=0;
            }

        }

        for(int i=0; i<n; i++){
            if(clothes[i]==-1 && i > 0 && i < n-1){
                //옷이 없는 경우
                if(clothes[i-1]==1){
                    //앞 사람이 있는 경우
                    clothes[i]=0;
                    clothes[i-1]=0;
                }else if(clothes[i+1]==1){
                    //뒷 사람이 있는 경우
                    clothes[i]=0;
                    clothes[i+1]=0;
                }
            }else if(i==0 && clothes[i]==-1){
                //맨 앞
                if(clothes[i+1]==1){
                    //뒷 사람이 있는 경우
                    clothes[i]=0;
                    clothes[i+1]=0;
                }
            }else if(i==n-1 && clothes[i]==-1){
                //맨 뒤
                if(clothes[i-1]==1){
                    //앞 사람이 있는 경우
                    clothes[i]=0;
                    clothes[i-1]=0;
                }
            }
        }
        for(int i:clothes){
            if(i==0 || i==1)
                answer++;
        }
        for(int i:clothes){
            System.out.println(i);
        }

        return answer;
    }
}
