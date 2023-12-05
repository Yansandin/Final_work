
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Animal {
    private String name;
    private List<String> commands;
    private Date birthDate;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Дата рождения: " + birthDate);
        System.out.println("Команды: " + commands);
    }
}

