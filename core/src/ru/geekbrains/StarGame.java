package ru.geekbrains;

import com.badlogic.gdx.Game;

import ru.geekbrains.screen.MenuScreen;

/**
 * Разработка_игры_на_LibGDX.Преподаватель: Алексей Кутепов
 * Урок 3. Разработка «каркаса» игры
 */
public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
