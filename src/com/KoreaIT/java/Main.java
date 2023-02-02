package com.KoreaIT.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("\n명령어를 입력해주세요 : ");
			String comand = sc.nextLine().trim();

			if (comand.startsWith("article detail")) {

			}

			else if (comand.equals("article list")) {
				if (articles.size() == 0) {

					System.out.println("\n게시글이 없습니다.");
					continue;

				}
				System.out.println("\n게시글이 있습니다.");
				System.out.println("\n번호 / 제목");
				String articleTitleLength = null;
				for (int i = (articles.size() - 1); i >= 0; i--) {
					Article article = articles.get(i);
					if (article.title.length() > 4) {
						articleTitleLength = article.title.substring(1, 4);
						System.out.printf("\n%04d / %s\n", article.id, articleTitleLength);
						continue;
					}
					System.out.printf("\n%04d / %s\n", article.id, article.title);

				}
			}

			else if (comand.equals("system exit")) {
				break;

			} else if (comand.equals("article write")) {
				int id = lastArticleId + 1;
				System.out.printf("\n제목 : ");

				String title = sc.nextLine();

				System.out.printf("\n내용 : ");

				String body = sc.nextLine();
				LocalDateTime now = LocalDateTime.now();
				Article article = new Article(id, title, body, now);
				articles.add(article);

				System.out.println("\n" + id + "번 글이 생성 되었습니다.");
				lastArticleId++;
			} else {

				System.out.println("\n존재하지 않는 명령어 입니다");
			}

		}

		System.out.println("\n==프로그램 종료== ");

		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;
	String formatedNow;

	Article(int id, String title, String body, LocalDateTime now) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
