package com.woori.BAM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            System.out.println("== 프로그램 시작 ==");
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("cmd) ");
            String cmd = sc.nextLine();
            System.out.println("명령어) " + cmd);
            if (cmd.equals("exit")) {
                break;
            }
        }
        System.out.println("== 프로그램 종료 ==");


    }
}
