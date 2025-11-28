import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        exam01();
//        exam02();
        exam03();
    }


    static void exam01()  {   //articleLength 변수 생성, for문을 이용해서 NPE 회피 --> 리모델링 필요
        int articleLength = 0 ;
        Article[] articles = new Article[10];

        articles[0] = new Article();
        articleLength++;
        articles[1] = new Article();
        articleLength++;
        articles[2] = new Article();
        articleLength++;
        articles[3] = new Article();
        articleLength++;
        articles[4] = new Article();
        articleLength++;
        articles[5] = new Article();
        articleLength++;

        for(int i = 0 ; i < articleLength; i++ ) {
            Article article = articles[i];
            System.out.println(article.id);
        }
    }
    static void exam02() {
        ArrayList articles = new ArrayList();   //ArrayList
//        articles.add(articles);               //Object는 모든 타입을 받을 수 있음
//        articles.add("asf");
//        articles.add(1);
//        articles.add(false);
//        articles.add(120.44);
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());

        System.out.println(articles);  // toString() 호출 , List는 [o , o, o] 형태로 출력됨

        for (int i =0 ; i < articles.size() ; i++ ) {   // size() --> ArrayList 타입의 배열의 크기를 가져옴
            Article article =(Article) articles.get(i);  //강제 형변환,   get(i)는 return 타입이 Object(모든 class 부모)
            System.out.println();
        }
    }
    static void exam03() {
        ArrayList<Article> articles = new ArrayList<>();  //제너릭 사용 --> 'E' Article 지정       articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());

        for(Article article : articles) {   //향상된 for문도 잘 수행
            System.out.println(article.id);
        }

//        for (int i =0 ; i < articles.size() ; i++ ) {
//            Article article = articles.get(i);    // 강제형변환을 안해도 된다
//            System.out.println(article.id);
//        }

    }

}

class Article {
    static int lastId;
    int id;

    static {
        lastId = 0;
    }

    Article() {
        this(lastId + 1);
        lastId++;
    }

    Article(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                '}';
    }
}