package easy_text_board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine();

			if (command.equals("article add")) {
				System.out.println("== 게시글 작성 ==");

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				int id = lastArticleId + 1;

				System.out.println("== 입력된 내용 ==");
				System.out.printf("번호 : %d\n", id);
				System.out.printf("제목 : %s\n", title);
				System.out.printf("내용 : %s\n", body);

				lastArticleId = id;

			} else if (command.equals("article list")) {
				System.out.println("== 게시글 리스트 ==");
			} else if (command.equals("system exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			} else {
				System.out.println("존재하지 않는 명령어");
			}
		}
		sc.close();
	}
}
