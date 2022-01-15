import commands.ConsoleManager;

import java.io.IOException;
//delete musor
// comments of commands proper,

public class main {
    public static void main(String[] args) throws IOException {
        try {
            ConsoleManager consoleManager = new ConsoleManager();
            consoleManager.InteractiveMode(args[0], args[1]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Некорректное количество аргументов: необходимы адрес, порт");
        }
    }
}
