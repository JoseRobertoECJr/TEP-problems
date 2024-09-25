import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int[] result = extendedEuclides(A, B);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }

    public static int[] extendedEuclides(int A, int B) {
        int rm1 = A;
        int r = B;

        int u = 1;
        int uM1 = 0;

        int v = 0;
        int vM1 = 1;

        int q, rm1Aux, um1Aux, vm1Aux;

        while (r != 0) {
            // Guarda o valor da iteracao anterior: R(k-1), U(k-1) e V(K-1)
            rm1Aux = rm1;
            um1Aux = u;
            vm1Aux = v;

            // Qk = R(k-1) / R(k)
            q = rm1 / r;

            // Atualiza e guarda o valor do R(k-1), U(k-1) e V(K-1)
            rm1 = r;
            u = uM1;
            v = vM1;

            // Proxima iteracao

            // R(K+1) = R(K-1) - R(K) * Q(K)
            r = rm1Aux - r * q;

            // U(K+1) = U(K-1) - U(K) * Q(K)
            uM1 = um1Aux - u * q;

            // V(K+1) = V(K-1) - V(K) * Q(K)
            vM1 = vm1Aux - v * q;
        }

        return new int[]{u, v, rm1};
    }
}
