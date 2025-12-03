
package com.woori.BAM;

import java.util.*;

public class Main {
    static int lastArticleID = 1;       //마지막 article 번호 저장용 사용
    static List<Article> articles = new ArrayList<>();  // 변수 articles 의 타입은 --> 제너릭 <article>

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 프로그램 시작 ==");
        product();


        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();
            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }
            if (cmd.equals("article list")) {
                if (articles.size() == 0) {           // size() 공부,  누구의 메서드?
                    System.out.println("게시글이 없습니다");
                    continue;
                }
                System.out.println("번호  |   제목    |    내용   |            시간             |      조회수");
                for (int i = articles.size() - 1; i >= 0; i--) {    //articles 역순으로 출력
                    Article article = articles.get(i);
                    System.out.printf("%d    |    %s   |    %s     |      %s      |       %d\n", article.id, article.title, article.body, article.regDate, article.click);
                }
            } else if (cmd.equals("article write")) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println("작성시간: " + Util.getDateStr());
                System.out.println(lastArticleID + " 번글이 생성되었습니다");
                int click = 0;

                Article article = new Article(lastArticleID, title, body, Util.getDateStr(), click); // 인자를 통해 생성자 호출
                articles.add(article);
                lastArticleID++;
            } else if (cmd.startsWith("article detail")) { //startswith() 특정 문자열로 문자열 시작? -> trus or false
                String[] cmdBits = cmd.split(" ");    //split(" ")  "  " 구분자로 문자열 분리해서 배열로 return
                Article foundArticle = null;  // foundArticle 용도는 'null check' 사용
                int id = 0;
                try {
                    id = Integer.parseInt(cmdBits[2]);

                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하십시오");
                    continue;
                } catch (Exception e) {

                }

                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;   //search 성공시 article 객체를 --> foundArticle 대입
                        break;  //for문을 빠져나감
                    }
                }
                if (foundArticle == null) { //serarch 수행했으나 게시글이 없음
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }
                foundArticle.increaseViewCnt();
                System.out.println("번호 : " + foundArticle.id);
                System.out.println("날짜 : " + foundArticle.regDate);
                System.out.println("제목 : " + foundArticle.title);
                System.out.println("내용 : " + foundArticle.body);
                System.out.println("조회수 : " + foundArticle.click);

            } else if (cmd.startsWith("article modify")) {
                String[] cmdBits = cmd.split(" ");
                Article foundArticle = null;
                int id = 0;
                try {
                    id = Integer.parseInt(cmdBits[2]);

                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하십시오");
                    continue;
                } catch (Exception e) {

                }

                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }
                System.out.print("수정할 제목: ");
                String chTitle = sc.nextLine().trim();
                foundArticle.title = chTitle;
                System.out.print("수정할 내용: ");
                String chBody = sc.nextLine().trim();
                foundArticle.body = chBody;
                System.out.println(id + "번 게시물이 수정되었습니다.");

            } else if (cmd.startsWith("article delete")) {
                String[] cmdBits = cmd.split(" ");
                Article foundArticle = null;
                int id = 0;
                try {
                    id = Integer.parseInt(cmdBits[2]);

                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하십시오");
                    continue;
                } catch (Exception e) {

                }

                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }
                articles.remove(foundArticle);
                System.out.printf("%d번 게시물이 삭제되었습니다\n", id);


            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }
        }
        System.out.println("== 프로그램 종료 ==");
    }

    static void product() {
        for (int i =1; i<=500; i++) {
            Article ar1 = new Article(lastArticleID++, "제목"+i, "내용"+i, Util.getDateStr(), i);
            articles.add(ar1);
        }

    }
}

class Article {
    int id;
    String title;
    String body;
    String regDate;
    int click;

    public Article(int lastArticleID, String title, String body, String regDate, int click) {  //생성자를 통해서 초기화 작업
        this.id = lastArticleID;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.click = click;
    }

    void increaseViewCnt() {
        this.click++;
    }
}

