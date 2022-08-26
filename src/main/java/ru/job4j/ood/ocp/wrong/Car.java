package ru.job4j.ood.ocp.wrong;


/**
 * The type Car.
 * не расширяемый код. При добавлении новых машин с разной вместимостью необходимо вносить изменения в метод
 *  workInTaxi(RenaultCaptur rc)
 *
 *  для исправления ситуации создаём интерфейс с нашим методом
 *  interface ICar {
 *  void workInTaxi();
 * }
 * и переопределяем его в каждой новой машине
 * установив зависимость от абстракции ICar - можем расширять приложение до бесконечности и удалить
 * громоздкий метод workInTaxi(RenaultCaptur rc) из  основного класса Car
 *
 */
public class Car {
    public static void workInTaxi(RenaultCaptur rc) {

        if (rc instanceof Miniven) {
            rc.get9Passenger();
        } else if (rc instanceof Celica) {
           rc.get1passenger();
        } else {
            rc.get4Passengers();
        }
    }

    public static void main(String[] args) {
        RenaultCaptur rc = new RenaultCaptur();
        Miniven mv = new Miniven();
        Celica celica =  new Celica();
        workInTaxi(rc);
        workInTaxi(mv);
        workInTaxi(celica);


    }
}

class RenaultCaptur {
    void get4Passengers() {
        System.out.println("get 4 passengers");
    }

    void get9Passenger() {
        System.out.println("get 9 passengers");
    }

    public void get1passenger() {
        System.out.println("get 1 passenger");
    }

}

class Miniven extends RenaultCaptur {

}

class Celica extends RenaultCaptur {

}
