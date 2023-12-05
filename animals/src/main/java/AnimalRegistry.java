import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listCommands(Animal animal) {
        System.out.println("Список команд для " + animal.getName() + ": " + animal.getCommands());
    }

    public void trainAnimal(Animal animal, String newCommand) {
        animal.addCommand(newCommand);
        System.out.println(animal.getName() + " теперь знает команду: " + newCommand);
    }

    public void displayMenu() {
        System.out.println("\n===== Меню реестра домашних животных =====");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Посмотреть список команд для животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Выйти из программы");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry registry = new AnimalRegistry();

        while (true) {
            registry.displayMenu();
            System.out.print("Выберите действие (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите имя нового животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
                    String birthDateStr = scanner.nextLine();
                    Date birthDate = new Date();  // Ваш код для преобразования строки в дату

                    System.out.print("Введите вид животного (собака, кошка, хомяк и т.д.): ");
                    String type = scanner.nextLine();

                    Animal newAnimal = null;

                    switch (type.toLowerCase()) {
                        case "собака":
                            newAnimal = new Dog(name, birthDate);
                            break;

                        case "кошка":
                            newAnimal = new Cat(name, birthDate);
                            break;

                        case "хомяк":
                            newAnimal = new Hamster(name, birthDate);
                            break;

                        case "верблюд":
                            newAnimal = new Camel(name, birthDate);
                            break;

                        case "осел":
                            newAnimal = new Donkey(name, birthDate);
                            break;

                        case "лошадь":
                            newAnimal = new Horse(name, birthDate);
                            break;



                        default:
                            System.out.println("Неподдерживаемый вид животного.");
                            break;
                    }

                    if (newAnimal != null) {
                        registry.addAnimal(newAnimal);
                        System.out.println("Животное успешно добавлено!");
                    }
                    break;

                case 2:
                    System.out.print("Введите имя животного, для которого хотите посмотреть команды: ");
                    String animalName = scanner.nextLine();
                    Animal selectedAnimal = null;

                    for (Animal animal : registry.animals) {
                        if (animal.getName().equalsIgnoreCase(animalName)) {
                            selectedAnimal = animal;
                            break;
                        }
                    }

                    if (selectedAnimal != null) {
                        registry.listCommands(selectedAnimal);
                    } else {
                        System.out.println("Животное с именем " + animalName + " не найдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введите имя животного, которого хотите обучить: ");
                    String trainAnimalName = scanner.nextLine();
                    Animal trainAnimal = null;

                    for (Animal animal : registry.animals) {
                        if (animal.getName().equalsIgnoreCase(trainAnimalName)) {
                            trainAnimal = animal;
                            break;
                        }
                    }

                    if (trainAnimal != null) {
                        System.out.print("Введите новую команду для обучения: ");
                        String newCommand = scanner.nextLine();
                        registry.trainAnimal(trainAnimal, newCommand);
                    } else {
                        System.out.println("Животное с именем " + trainAnimalName + " не найдено.");
                    }
                    break;

                case 4:
                    System.out.println("Выход из программы. До свидания!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неправильный выбор. Пожалуйста, введите число от 1 до 4.");
                    break;
            }
        }
    }
}


