package org.example;

import org.example.Service.LoginService;

import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int input = scan.nextInt();
            scan.nextLine();

            if (input == 1 ){
                System.out.print("Create Username :");
                String username = scan.nextLine();
                System.out.print("Create Password :");
                String password = scan.nextLine();
                loginService.register(username, password);
            } else if (input == 2 ) {
                System.out.print("Enter Username :");
                String username = scan.nextLine();
                System.out.print("Enter Password :");
                String password = scan.nextLine();
                loginService.login(username, password);
            } else if (input == 3) {
                break;
            }else {
                System.out.println("Wrong Choice");
            }
        }
        scan.close();
        loginService.close();
    }
}
