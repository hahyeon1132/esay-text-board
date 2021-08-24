package easy_text_board;

import java.util.Scanner;

public class App {
	Article[] articles = new Article[2];
	int lastArticleId = 0;

	public Article getArticle(int id) {
		if (id < 1 || id > lastArticleId) {
			return null;
		}
		return articles[id - 1];
	}

	public void run() {

		for (int i = 0; i < articles.length; i++) {
			articles[i] = new Article();
		}

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine();

			if (command.equals("article add")) {

				if (lastArticleId == articles.length) {
					System.out.println("더 이상 개시글을 생성할 수 없습니다.");
					continue;
				}

				System.out.println("== 게시글 작성 ==");

				int id = lastArticleId + 1;
				lastArticleId = id;

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = getArticle(id);

				article.id = id;
				article.title = title;
				article.body = body;

				System.out.println("== 입력된 내용 ==");
				System.out.printf("번호 : %d\n", id);
				System.out.printf("제목 : %s\n", title);
				System.out.printf("내용 : %s\n", body);

			} else if (command.equals("article list")) {
				System.out.println("== 게시글 리스트 ==");
				if (lastArticleId == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 / 제목");
					for (int i = 1; i <= lastArticleId; i++) {
						Article article = getArticle(i);
						System.out.printf("%s / %s\n", article.id, article.title);
					}
				}
			} else if (command.equals("system exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			} else if (command.startsWith("article detail ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				Article selectedArticle = getArticle(inputedId);
				if (selectedArticle == null || selectedArticle.id == 0) {
					System.out.printf("%d번 개시글이 존재하지 않습니다.\n", inputedId);
					continue;
				}
				System.out.printf("번호 : %d\n", selectedArticle.id);
				System.out.printf("제목 : %s\n", selectedArticle.title);
				System.out.printf("내용 : %s\n", selectedArticle.body);
			}

			else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();

	}

}
