import java.io.IOException;
import java.util.Scanner;

public class BOJ_2304_Container {
    //백준 2304 - 창고 다각형
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int number=sc.nextInt();
        int [] arr = new int [1001];//N이 1000이하
        int minIndex=Integer.MAX_VALUE;
        int maxIndex=Integer.MIN_VALUE;
        for(int i=0;i<number;i++)
        {
            int index=sc.nextInt();
            int height=sc.nextInt();
            arr[index]=height;
            if(index>maxIndex)
            {
                maxIndex=index;
            }
            if(index<minIndex)
            {
                minIndex=index;
            }
        }
        int location=arr[minIndex];
        for(int i=minIndex;i<=maxIndex;i++)
        {
            if(location<arr[i])
            {
                location=arr[i];
            }
            result+=location;
        }
        if(location>arr[maxIndex])
        {
            int al=maxIndex;
            while(true)
            {
                if(location==arr[al]) //10을 만날때 stop!
                {
                    break;
                }
                else
                {
                    if(arr[al]>arr[maxIndex]) //웅덩이 방지 !!
                    {
                        result-=(location-arr[al]);
                        arr[maxIndex]=arr[al];
                    }
                    else // 10 10 10 10에서 남는 곳만큼 빼야한다
                    {
                        result-=(location-arr[maxIndex]);
                    }
                }
                al--;
            }
        }
        System.out.println(result);
    }
}
