public class Rectangle {
    public long solution(int w,int h) {
        double answer = 1;
        double sum = 0;
        //정사각형이라면 w만큼 못쓰게 됨
        double doubleW=(double)w;
        double doubleH=(double)h;
        System.out.println(w);
        System.out.println(h);
        if(w==h){ //정사각형인 경우 무조건 가로 or 세로 길이만큼 못씀
            answer = w*h -w;
            return (long)answer;
        }else if(w==1 || h ==1){ // 둘 중 하나가 1이라면 모두 못씀
            answer=0;
            return (long)answer;
        }
        else{
            double n = doubleH/doubleW;
            System.out.println("n: "+n);
            double index =0.0; //나누어 떨어지면 바꿔준다
            double indexValue=0.0; //나누어 떨어지면 기울기에 해당하는 값을 넣어준다
            for(double i = 1; i<=doubleW; i++){
                if((doubleH*i) % doubleW == 0){ //나누어 떨어진다면
                    System.out.println(i+"에서 나누어 떨어짐");
                    sum+=i-index+(n*i)-indexValue-1; //가로를 생각하면 개수 차이만큼 사각형을 못쓰게 되고, 세로는 사이에있는 정수 차이-1 만큼 못쓰게 된다
                    indexValue=n*i;
                    index=i;
                    System.out.println("Sum: "+sum);
                }
            }
        }

        System.out.println(sum);
        answer = doubleW*doubleH - sum;
        return (long)answer;
    }
}
