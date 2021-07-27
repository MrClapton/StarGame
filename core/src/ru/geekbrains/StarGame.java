package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/*Модуль основной логики проекта*/
public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;	//Класс, который отвечает за отрисовку графических объектов
	Texture img;	//Класс, который отвечает

	//private int x = 0;

	/*Стартовая инициализация*/
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	/*Метод отрисовки, работающий 60 раз в секунду*/
	@Override
	public void render () {
		/*В том случае, если переменная x будет полем, а в методе render она будет инкрементирована, тогда графический объект будет двигаться вдооль оси x(слева-направо)*/
		//x++;
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();	//Передача графическому процессору данных для отрисовки
//		batch.draw(img, 0, 0);	//Отрисовка графического объекта img в точке с координатами (0,0)
		batch.draw(img, 0,0);
		batch.end();	//Метод, который отвечает за передачу полученной графики на отрисовку
	}

	/*Метод, выполняющий очистку памяти*/
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
