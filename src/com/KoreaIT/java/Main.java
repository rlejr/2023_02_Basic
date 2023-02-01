package com.KoreaIT.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==\n");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어를 입력해주세요 : ");
			String comand = sc.nextLine();

			if (comand.equals("system exit")) {
				break;
			}

		}

		System.out.println("\n==프로그램 종료== ");

		sc.close();
	}

}
