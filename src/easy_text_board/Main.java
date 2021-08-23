package easy_text_board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String command = "";
		
		System.out.printf("명령어 : ");
		command = sc.nextLine();
		
		if(command.equals("article add")) {
			System.out.println("== 게시물 등록 ==");
		}
		else if(command.equals("article list")) {
			System.out.println("== 게시물 목록 ==");
		}else {
			System.out.println("== 존재하지 않은 명령어 ==");
		}
		sc.close();
	}

}
