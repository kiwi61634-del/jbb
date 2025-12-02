
package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);
        int lastArticleID  = 1;       //마지막 article 번호 저장용 사용
        List<Article> articles = new ArrayList<>();  // 변수 articles 의 타입은 --> 제너릭 <article>
        // ArrayList --> List를 구현하는 구현 class
        while (true) {
            System.out.printf("cmd) ");
            String cmd = sc.nextLine().trim();
//            System.out.println("명령어) " + cmd);  중복으로 제거
            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }
            if ( cmd.equals("article list")) {
                if (articles.size() == 0) {           // size() 공부,  누구의 메서드?
                    System.out.println("게시글이 없습니다");
                    continue;
                }
                System.out.println("번호  |   제목");
                for(int i = articles.size() - 1 ; i >= 0 ; i-- ) {    //articles 역순으로 출력
                    Article article= articles.get(i);
                    System.out.printf("%d    |    %s\n" , article.id, article.title);
                }
            } else if (cmd.equals("article write")) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println(lastArticleID + " 번글이 생성되었습니다");

//                Article article = new Article();  //default 생성자
                Article article = new Article(lastArticleID, title, body); // 인자를 통해 생성자 호출

//                article.id = lastArticleID;
//                article.title = title;
//                article.body = body;

                articles.add(article);
                lastArticleID++;
            } else if (cmd.startsWith("article detail")) { //startswith() 특정 문자열로 문자열 시작? -> trus or false
                String[] cmdBits = cmd.split(" ");    //split(" ")  "  " 구분자로 문자열 분리해서 배열로 return
//                System.out.println(cmdBits[0]);
//                System.out.println(cmdBits[1]);
//                System.out.println(cmdBits[2]);   //"1" --> 문자를 숫자로 변환 로직
                Article foundArticle = null ;  // foundArticle 용도는 'null check' 사용
                int id = Integer.parseInt(cmdBits[2]);

                for(Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;   //search 성공시 article 객체를 --> foundArticle 대입
                        break;  //for문을 빠져나감
                    }
                }
                if (foundArticle == null) { //serarch 수행했으나 게시글이 없음
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n" , id);
                    continue; //while문을 다시 시작해라
                }
                // serach후 detail 내용 출력
                System.out.println("번호 : " + foundArticle.id);
                System.out.println("날짜 : ~~~");
                System.out.println("제목 : " + foundArticle.title);
                System.out.println("내용 : " + foundArticle.body);
            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }
        }
        System.out.println("== 프로그램 종료 ==");
    }
}
class Article {
    int id;
    String title;
    String body;

    public Article(int lastArticleID, String title, String body) {  //생성자를 통해서 초기화 작업
        this.id = lastArticleID;
        this.title = title;
        this.body = body;
    }
}
