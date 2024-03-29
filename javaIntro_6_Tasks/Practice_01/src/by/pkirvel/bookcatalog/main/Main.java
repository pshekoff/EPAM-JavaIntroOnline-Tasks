package by.pkirvel.bookcatalog.main;

import by.pkirvel.bookcatalog.controller.BookCatalogController;
import by.pkirvel.bookcatalog.controller.Controller;

public class Main {
	
	/* Задание 1: создать консольное приложение "Учет книг в домашней библиотеке".
	 * 
	 * Общие требования к заданию:
	 *  - Система учитывает книги как в электронном, так и в бумажном варианте.
	 *  - Существующие роли: пользователь, администратор.
	 *  - Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
	 *  - Администратор может модифицировать каталог.
	 *  - *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям.
	 *  - **При просмотре каталога желательно реализовать постраничный просмотр.
	 *  - ***Пользователь может предложить добавить книгу в библиотеку, переслав ее администратору на e-mail.
	 *  - Каталог книг хранится в текстовом файле.
	 *  - Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде.
	 */

	public static void main(String[] args) {
		
		Controller controller = new BookCatalogController();
		
		BookCatalogMenu.loginMenu(controller);

	}	

}
