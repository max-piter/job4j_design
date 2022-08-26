package ru.job4j.ood.ocp.wrong;

/**
 * The type Draw figure - не расширяемый код
 * при желании добавить новую фигур придётся менять функционал класса
 * решение: - интерфейс
 * interface Drawable {
 *         String draw();
 *     }
 * с помощь которого можно можно расширять программу не изменяя функционала,
 * создавая бесконечное количество классов-фигур
 */
public class DrawFigure {

    public static void drawTriangle() {
        System.out.println("Draw triangle");
    }

    public static void drawLine() {
        System.out.println("Draw line");
    }
}

interface Drawable {
    String draw();
}


