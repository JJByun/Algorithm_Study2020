import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class next_permutation2_10972 {
	static int N = 0;
	static int[] number;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int num[] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		number = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = num[0];
		long start = System.currentTimeMillis(); //시작하는 시점 계산
		check_permu();
		long end = System.currentTimeMillis();
		//System.out.println("실행 시간 : " + ( end - start )/1000.0 +"초");
	}
	private static void check_permu() {
		if (next_permutation(number))
			for (int i : number)
				System.out.print(i + " ");
		else
			System.out.println("-1");
	}
	private static boolean next_permutation(int[] number)
	{
		int idx = number.length - 1;
		//배열의 앞숫자가 뒷숫자보다 큰 위치 찾기 // 처음부터 끝까지 그러하다면 마지막 순열
		while (idx > 0 && number[idx - 1] >= number[idx])
			idx--;

		if (idx <= 0)
			return (false);

		int jdx = number.length - 1;
		while (number[jdx] <= number[idx - 1])
			jdx--;

		swap(number, idx - 1, jdx);

		jdx = number.length - 1;
		while (idx < jdx)
		{
			swap(number, idx, jdx);
			idx++;
			jdx--;
		}
		return (true);
	}
	private static void swap(int[] number, int i, int j)
	{
		int tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}
}
