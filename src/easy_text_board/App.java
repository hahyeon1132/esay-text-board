package easy_text_board;

import java.util.Scanner;

public class App {

	public void run() {
		Article article1 = new Article();
		Article article2 = new Article();

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine();

			if (command.equals("article add")) {
				System.out.println("== 게시글 작성 ==");

				int id = lastArticleId + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				if (id == 1) {
					article1.title = title;
					article1.body = body;
					article1.id = id;
				} else if (id == 2) {
					article2.title = title;
					article2.body = body;
					article2.id = id;
				} else {
					System.out.println("더 이상 게시글을 생성할 수 없습니다.");
					continue;
				}
				System.out.println("== 입력된 내용 ==");
				System.out.printf("번호 : %d\n", id);
				System.out.printf("제목 : %s\n", title);
				System.out.printf("내용 : %s\n", body);

				lastArticleId = id;

			} else if (command.equals("article list")) {
				System.out.println("== 게시글 리스트 ==");
				if (lastArticleId == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 / 제목 / 내용");
					if (lastArticleId == 1) {
						System.out.printf("%d / %s / %s\n", article1.id, article1.title, article1.body);
					} else if (lastArticleId == 2) {
						System.out.printf("%d / %s / %s\n", article1.id, article1.title, article1.body);
						System.out.printf("%d / %s / %s\n", article2.id, article2.title, article2.body);
					}

				}
			} else if (command.equals("system exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			} else if (command.startsWith("article detail ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				if (inputedId > lastArticleId || inputedId == 0) {
					System.out.printf("%d번 개시글이 존재하지 않습니다.\n", inputedId);
				} else if (inputedId == 1) {
					System.out.printf("번호 : %d\n", article1.id);
					System.out.printf("제목 : %s\n", article1.title);
					System.out.printf("내용 : %s\n", article1.body);
				} else if (inputedId == 2) {
					System.out.printf("번호 : %d\n", article2.id);
					System.out.printf("제목 : %s\n", article2.title);
					System.out.printf("내용 : %s\n", article2.body);
				}
			}

			else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();

	}

}
