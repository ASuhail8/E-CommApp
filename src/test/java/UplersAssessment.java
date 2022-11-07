
public class UplersAssessment {

    public static void main(String[] args) {

        // p>0 p>n
        int[] A = { 6, 42, 11, 7, 1};

        int result = solution(6, 42, A);
        System.out.println(result);

    }

    static int solution(int X, int Y, int[] A) {
        int N = A.length;// 6
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1; // nx=nx+1 // nx = 0
            else if (A[i] == Y)
                nY += 1; // ny=ny+1 //ny=1
            if (nX == nY)
                result = i;
        }
        return result;
    }

}
