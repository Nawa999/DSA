package algorithms;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        System.out.println("The moves are:");
        towerOfHanoi(n, 'A', 'B', 'C'); // A=source, B=auxiliary, C=destination
        sc.close();
    }
}
