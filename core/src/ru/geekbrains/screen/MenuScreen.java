package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

/**
 * Класс экрана меню. Это страртовый класс.
 */
public class MenuScreen extends BaseScreen {
    //Переменная фона
   private Texture backgroundTexture;
    //Переменная объекта движения
    private Texture image;
    //Переменная вектора текущей позиции
    private Vector2 pos;
    //Переменная вектора скорости
    private Vector2 v;
    //Вектор позиции точки назначения
    private Vector2 dest;

    @Override
    public void show() {
        super.show();
        //Инициализация объекта движения
        image = new Texture("badlogic.jpg");
        //Инициализация фона
        backgroundTexture = new Texture("lesson1.jpg");
        //Инициализация вектора позиции
        pos = new Vector2();
        //Инициализация вектора скорости
        v = new Vector2();
        //Инициализация вектора
        dest = new Vector2();
    }

    @Override
    //Переопределенный родительский метод обновления экрана
    public void render(float delta) {
        super.render(delta);
        //Gdx.gl.glClearColor(1, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backgroundTexture,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(image, pos.x, pos.y);
        batch.end();
        //Ограничение движения объекта координатами точки назначения
        // (при достижении ее скорость меняться не будет)
        if (Math.abs((int)(dest.x - pos.x)) > 0 && Math.abs((int)(dest.y - pos.y)) > 0) {
            pos.add(v);
        }
    }

//    @Override
//    public void dispose() {
//        batch.dispose();
//        image.dispose();
//        super.dispose();
//    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        //Получаем координаты конечной позиции объекта
        dest.x = screenX;
        dest.y = Gdx.graphics.getHeight() - screenY;
        //Вычисление вектора скорости
        // (Из копии вектора конечной позиции вычитаем вектор текущей позиции и нормализуем)
        v = dest.cpy().sub(pos).nor();
        //Переменная вектора ускорения
        float acceleration = 2f;
        //Добавка ускорения
        v.scl(acceleration);
        System.out.println(screenX + "; " + (Gdx.graphics.getHeight() - screenY));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        pos.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDragged(screenX, screenY, pointer);

    }
}
