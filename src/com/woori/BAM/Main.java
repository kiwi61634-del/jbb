package com.woori.BAM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);
        int id = 1;  //게시글의 번호를 저장
        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();   //trim() 공부 --> 사용

            if ( cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;        // 반복문 처음부터 다시 진행
            }

            if ( cmd.equals("article list")) {
                System.out.println("게시글이 없습니다");
            } else if (cmd.equals("article write")) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println(id + " 번글이 생성되었습니다");
                id++;
            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }

            if (cmd.equals("exit")) { //cmd 객체의 값이 "exit" 같은지
                break;                //반복문을 빠져나감
            }


        }

        System.out.println("== 프로그램 종료 ==");
    }

}