package easy_text_board;

import java.util.Scanner;

public class App {
	
	Article[] articles = new Article[2];
	int lastArticleId = 0;
	int articlesSize = 0;

	public int articlesSize() {
		return articlesSize;
	}

	public Article getArticle(int id) {

		int index = getIndexById(id);

		if (index == -1) {
			return null;
		}
		return articles[index];
	}

	private void articleAdd(String title, String body) {
		System.out.println("== 게시글 작성 ==");

		int id = lastArticleId + 1;
		lastArticleId = id;

		Article article = new Article();

		article.id = id;
		article.title = title;
		article.body = body;

		articles[articlesSize] = article;

		System.out.printf("%d번 개시글이 생성 되었습니다\n", id);

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

		int maxArticlesCount = articles.length;

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine();

			if (command.equals("article add")) {

				if (articlesSize() >= maxArticlesCount) {
					System.out.println("더 이상 개시글을 생성할 수 없습니다.");
					continue;
				}
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				articleAdd(title, body);
				articlesSize++;

			} else if (command.equals("article list")) {
				System.out.println("== 게시글 리스트 ==");
				if (articlesSize() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 / 제목");
					for (int i = 0; i < articlesSize(); i++) {
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
			}

			else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();

	}

}
