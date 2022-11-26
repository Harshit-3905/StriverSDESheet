import java.util.*;

class Q1SetMatrixZero {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = in.nextInt();
        // brute(a);
        // efficient(a);
        best(a);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }

    // Brute Force
    // Time Complexity = O(mn)
    // Space Complexity = O(mn)
    static void brute(int a[][]) {
        int m = a.length;
        int n = a[0].length;
        int b[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    for (int k = 0; k < m; k++)
                        b[k][j] = 1;
                    for (int k = 0; k < n; k++)
                        b[i][k] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = b[i][j];
    }

    // Efficient Approach
    // Time Complexity = O(mn)
    // Space Complexity = O(m+n)
    static void efficient(int a[][]) {
        int m = a.length;
        int n = a[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i) || col.contains(j))
                    a[i][j] = 1;
            }
        }
    }

    // Best Approach
    // Time Complexity = O(mn)
    // Space Complexity = O(1)
    static void best(int a[][]) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    a[0][j] = 1;
                    a[i][0] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (a[0][i] == 1) {
                for (int j = 0; j < m; j++) {
                    a[j][i] = 1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (a[i][0] == 1) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = 1;
                }
            }
        }
        if (a[0][0] == 1) {
            for (int i = 0; i < m; i++)
                a[i][0] = 1;
            for (int i = 0; i < n; i++)
                a[0][i] = 1;
        }
    }
}