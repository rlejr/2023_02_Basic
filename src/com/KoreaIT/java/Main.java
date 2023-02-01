package com.KoreaIT.java;


import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==\n");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어를 입력해주세요 : ");
			String comand = sc.nextLine();

			if (comand.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			}
			if (comand.equals("article write")) {
				System.out.printf("제목 : ");

				String 제목 = sc.nextLine();

				System.out.printf("내용 : ");

				String 내용 = sc.nextLine();

				System.out.println();
			}

			if (comand.equals("system exit")) {
				break;

			} else {
				System.out.println("\n존재하지 않는 명령어 입니다\n");
			}

		}

		System.out.println("\n==프로그램 종료== ");

		sc.close();
	}

}
