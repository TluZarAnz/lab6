package commands;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class Invoker {
    private static final Stack<Command> commands = new Stack<>();

    /**
     *Добавляет команды в отдельную коллекцию для команд
     * @param command
     */
    public void register(Command command) {
        commands.push(command);
    }

    public void executeCommand(String[] commandName) {
        Iterator<Command> iterator = commands.stream().iterator();
        Command command;

        try {

            while (iterator.hasNext()) {
                if ((command = iterator.next()).getName().equalsIgnoreCase(commandName[0])) {
                    command.execute(commandName);
                }
            }

        }

        catch (NullPointerException ex) {
            System.out.println("Не существует команды " + commandName[0] + ". Воспользуйтесь help");}

        catch (ArrayIndexOutOfBoundsException ex){System.out.println("Wrong arg");}
        catch (IllegalStateException | IOException | ClassNotFoundException | InterruptedException ex) {
            if (ex.getMessage().equals("Connection reset by peer")) {
                System.out.println("dead");
                System.exit(0);
            }
            System.out.println(ex.getMessage());
        }
    }

    Stack<Command> getCommands() {
        return commands;
    }
}
