package easy_text_board;

import java.util.Scanner;

public class App {

	Article[] articles;
	int lastArticleId;
	int articlesSize;

	public App() {
		articles = new Article[32];
		lastArticleId = 0;
		articlesSize = 0;

		for (int i = 0; i < 32; i++) {
			articleAdd("제목" + (i + 1), "내용" + (i + 1));
		}

	}

	private void articlesfull() {

		if (articlesSize() == articles.length) {
			Article[] newArticles = new Article[articles.length * 2];
			for (int i = 0; i < articles.length; i++) {
				newArticles[i] = articles[i];
			}
			articles = newArticles;
		}

	}

	private int articlesSize() {
		return articlesSize;
	}

	private Article getArticle(int id) {

		int index = getIndexById(id);

		if (index == -1) {
			return null;
		}
		return articles[index];
	}

	private void articleModify(int id, String title, String body) {
		Article article = getArticle(id);
		article.title = title;
		article.body = body;
	}

	private void articleAdd(String title, String body) {

		articlesfull();
		int id = lastArticleId + 1;
		lastArticleId = id;

		Article article = new Article();

		article.id = id;
		article.title = title;
		article.body = body;

		articles[articlesSize] = article;
		articlesSize++;

	}

	private void removeArticle(int id) {
		int index = getIndexById(id);

		if (index == -1) {
			return;
		}
		for (int i = index; i < articlesSize; i++) {
			articles[i] = articles[i + 1];
		}

		articlesSize--;

	}

	private int getIndexById(int id) {
		for (int i = 0; i < articlesSize(); i++) {
			if (articles[i].id == id) {
				return i;
			}
		}
		return -1;
	}

	public void run() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine();

			if (command.equals("article add")) {

				System.out.println("== 게시글 작성 ==");

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				articleAdd(title, body);
				System.out.printf("%d번 개시글이 생성 되었습니다\n", lastArticleId);

			} else if (command.equals("article list")) {
				System.out.println("== 게시글 리스트 ==");
				if (articlesSize() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 / 제목");
					for (int i = articlesSize() - 1; i >= 0; i--) {
						Article article = articles[i];
						System.out.printf("%s / %s\n", article.id, article.title);
					}
				}
			} else if (command.equals("system exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			} else if (command.startsWith("article detail ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				System.out.println("== 게시물 상세 ==");
				Article selectedArticle = getArticle(inputedId);
				if (selectedArticle == null) {
					System.out.printf("%d번 개시글이 존재하지 않습니다.\n", inputedId);
					continue;
				}
				System.out.printf("번호 : %d\n", selectedArticle.id);
				System.out.printf("제목 : %s\n", selectedArticle.title);
				System.out.printf("내용 : %s\n", selectedArticle.body);
			} else if (command.startsWith("article delete ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				System.out.println("== 게시물 삭제 ==");
				Article selectedArticle = getArticle(inputedId);
				if (selectedArticle == null) {
					System.out.printf("%d번 개시글이 존재하지 않습니다.\n", inputedId);
					continue;
				}
				removeArticle(inputedId);
				System.out.printf("%d번 개시글이 삭제되었습니다.\n", inputedId);
			} else if (command.startsWith("article modify ")) {
				System.out.println("== 개시물 수정 ==");
				int inputedId = Integer.parseInt(command.split(" ")[2]);

				Article article = getArticle(inputedId);

				if (article == null) {
					System.out.printf("%d번 개시글이 존재하지 않습니다\n", inputedId);
					return;
				}

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				articleModify(inputedId, title, body);

				System.out.printf("%d번 개시글이 수정되었습니다\n", inputedId);

			}

			else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();

	}

}
