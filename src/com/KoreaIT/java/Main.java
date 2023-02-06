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

				if (comand.length() > 14) {
					int i = 0;

					String[] splitTitle = comand.split(" ");
					String articleNumber = splitTitle[2];

					if (isInteger(articleNumber)) {

						if (Integer.parseInt(articleNumber) > 0) {
							if (articles.size() >= Integer.parseInt(articleNumber)) {
								i = Integer.parseInt(articleNumber);
								Article articleDetail = articles.get(i - 1);
								articleDetail.views ++;
								System.out.println("\n번호 : " + i);
								System.out.println("작성일 : " + articleDetail.formatedNow);
								System.out.println("최근 수정일 : " + articleDetail.modifyTime);
								System.out.printf("조화수 : %d회\n", articleDetail.views);
								System.out.println("제목 : " + articleDetail.title);
								System.out.println("내용 : " + articleDetail.body);
							} else {
								System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
							}
						} else {
							System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
						}

					} else {
						System.out.println("\n번호를 뒤에 붙여주세요");
					}
				} else {
					System.out.println("\n번호를 뒤에 붙여주세요");

				}
			} else if (comand.startsWith("article delete")) {

				if (comand.length() > 14) {
					int i = 0;

					String[] splitTitle = comand.split(" ");
					String articleNumber = splitTitle[2];

					if (isInteger(articleNumber)) {

						if (Integer.parseInt(articleNumber) > 0) {
							if (articles.size() >= Integer.parseInt(articleNumber)) {
								i = Integer.parseInt(articleNumber);
								articles.remove(i - 1);
								System.out.println("\n" + i + "번 게시물이 삭제 되었습니다");

							} else {
								System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
							}
						} else {
							System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
						}

					} else {
						System.out.println("\n번호를 뒤에 붙여주세요");
					}
				} else {
					System.out.println("\n번호를 뒤에 붙여주세요");

				}
			}
			else if (comand.startsWith("article modify")) {

				if (comand.length() > 14) {
					int i = 0;

					String[] splitTitle = comand.split(" ");
					String articleNumber = splitTitle[2];

					if (isInteger(articleNumber)) {

						if (Integer.parseInt(articleNumber) > 0) {
							if (articles.size() >= Integer.parseInt(articleNumber)) {
								i = Integer.parseInt(articleNumber);
								Article articleModify = articles.get(i - 1);
								LocalDateTime modifyTime = LocalDateTime.now();
								articleModify.modifyTime = modifyTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
								System.out.println("\n" + i + "번 글을 수정합니다.");
								System.out.printf("\n제목 : ");

								String title = sc.nextLine();

								System.out.printf("\n내용 : ");

								String body = sc.nextLine();
								articleModify.title = title;
								articleModify.body = body;
								

							} else {
								System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
							}
						} else {
							System.out.println("\n" + Integer.parseInt(articleNumber) + "번 게시물은 존재하지 않습니다.");
						}

					} else {
						System.out.println("\n번호를 뒤에 붙여주세요");
					}
				} else {
					System.out.println("\n번호를 뒤에 붙여주세요");

				}
			}

			else if (comand.equals("article list")) {
				if (articles.size() == 0) {

					System.out.println("\n게시글이 없습니다.");
					continue;

				}
				System.out.println("\n게시글이 있습니다.");
				System.out.println("\n번호 / 제목    / 조회수");
				String articleTitleLength = null;
				for (int i = (articles.size() - 1); i >= 0; i--) {
					Article article = articles.get(i);
					if (article.title.length() > 4) {
						articleTitleLength = article.title.substring(0, 4);
						System.out.printf("\n%04d / %s... / %d\n", article.id, articleTitleLength, article.views);
						continue;
					}
					System.out.printf("\n%04d / %s     / %d\n", article.id, article.title, article.views);

				}
			}

			else if (comand.equals("system exit")) {
				break;

			} else if (comand.equals("article write")) {
				int id = lastArticleId + 1;
				int views = 0;
				System.out.printf("\n제목 : ");

				String title = sc.nextLine();

				System.out.printf("\n내용 : ");

				String body = sc.nextLine();
				LocalDateTime now = LocalDateTime.now();
				Article article = new Article(id, now, title, body, views);
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

	static boolean isInteger(String strValue) {
		try {
			Integer.parseInt(strValue);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}

class Article {
	int id;
	int views;
	String formatedNow;
	String title;
	String body;
	String modifyTime = "없음";

	Article(int id,LocalDateTime now, String title, String body, int views) {
		this.id = id;
		this.formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.title = title;
		this.body = body;
		this.views = views;
	}

}
