package ru.geekbrains;

import com.badlogic.gdx.Game;

import ru.geekbrains.screen.MenuScreen;

/**
 * Разработка_игры_на_LibGDX.Преподаватель: Алексей Кутепов
 * Урок 2. Базовые возможности фреймворка LibGDX
 * Работа с графикой. Векторная математика.
 */
public class StarGame extends Game {

	@Override
	public void create() {
		//устанавливаем начальный экран приложения
		setScreen(new MenuScreen());
	}
}