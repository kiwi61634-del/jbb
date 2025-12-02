package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);

        int LastArticleId = 1;

        List<Article> articles = new ArrayList<>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }

            if (cmd.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("계시글이 없습니다");
                    continue;
                }
                System.out.println("번호  |  제목");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    System.out.printf("%d  |  %s \n", article.id, article.title);
                    continue;
                }
            } else if (cmd.equals("article write")) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println(LastArticleId + "번글이 생성되었습니다");

                Article article = new Article();
                article.id = LastArticleId;
                article.title = title;
                article.body = body;

                articles.add(article);
                LastArticleId++;
            } else if (cmd.startsWith("article detail")){
                String[] cmdBits = cmd.split(" ");
//                System.out.println(cmdBits[0]);
//                System.out.println(cmdBits[1]);
//                System.out.println(cmdBits[2]);

                Article foundArticle=null;
                int id = Integer.parseInt(cmdBits[2]);

                for (Article article : articles){
                    if (article.id == id){
                        foundArticle = article;
                        break;
                    }
                }
                if (foundArticle == null){
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n" ,id);
                    continue;
                }
                System.out.println("번호 : "+foundArticle.id);
                System.out.println("날짜 : ~~~");
                System.out.println("제목 : "+foundArticle.title);
                System.out.println("내용 : "+foundArticle.body);

            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }

            if (cmd.equals("exit")) {
                    break;
            }
        }
        System.out.println("== 프로그램 종료 ==");
    }
}

class Article {

    int id;
    String title;
    String body;
}
