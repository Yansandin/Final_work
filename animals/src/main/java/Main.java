import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Барон", new Date());
        dog.addCommand("Сидеть");
        dog.addCommand("Фас!");

        Cat cat = new Cat("Мурка", new Date());
        cat.addCommand("Мяу");

        Horse horse = new Horse("Гроза", new Date());
        horse.addCommand("Галоп");

        System.out.println("Информация о собаке:");
        dog.displayInfo();

        System.out.println("\nИнформация о кошке:");
        cat.displayInfo();

        System.out.println("\nИнформация о лошади:");
        horse.displayInfo();
    }
}