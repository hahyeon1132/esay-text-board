package easy_text_board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		int id1 = 0;
		int id2 = 0;
		String title1 = "";
		String body1 = "";
		String title2 = "";
		String body2 = "";

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
					title1 = title;
					body1 = body;
					id1 = id;
				} else if (id == 2) {
					title2 = title;
					body2 = body;
					id2 = id;
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
						System.out.printf("%d / %s / %s\n", id1, title1, body1);
					} else if (lastArticleId == 2) {
						System.out.printf("%d / %s / %s\n", id1, title1, body1);
						System.out.printf("%d / %s / %s\n", id2, title2, body2);
					}

				}
			} else if (command.equals("system exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			} else if (command.startsWith("article detail ")) {
				int inputedId = Integer.parseInt(command.split(" ")[2]);
				if (inputedId == 1) {
					System.out.printf("번호 : %d\n", id1);
					System.out.printf("제목 : %s\n", title1);
					System.out.printf("내용 : %s\n", body1);
				} else if (inputedId == 2) {
					System.out.printf("번호 : %d\n", id2);
					System.out.printf("제목 : %s\n", title2);
					System.out.printf("내용 : %s\n", body2);
				} else {
					System.out.printf("%d번 개시글이 존재하지 않습니다\n", inputedId);
				}
			}

			else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();
	}
}
