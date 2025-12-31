/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RabbitProblem;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class RabbitProblem {

    static int rabbits(int month) {
        if (month <= 1)
            return 1;
        return rabbits(month - 1) + rabbits(month - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.println("Number of rabbit pairs: " + rabbits(month));
    }
}

    

