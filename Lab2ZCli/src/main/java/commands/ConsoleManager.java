package commands;

import client.ClientSender;
import client.Session;
import utils.StudyGroupFactory;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleManager {

    public void InteractiveMode(String hostName, String port) throws IOException {
        Session session = null;
        int delay = 0;

        try {
            session = new Session(hostName, Integer.parseInt(port));
            session.startSession();

            if (delay < 80) delay = 80;  // Минимальная задержка 80
        } catch (NumberFormatException ex) {
            System.out.println("Проверьте, чтобы имя было текстом, а порт и задержка целыми числами");
            System.exit(0);
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        ClientSender sender = new ClientSender(session);

        StudyGroupFactory creator = new StudyGroupFactory();
        Invoker commandInvoker = new Invoker();
        Receiver commandReciever = new Receiver(commandInvoker, sender, session.getSocketChannel(), delay, creator);

        commandInvoker.register(new Help(commandReciever));
        commandInvoker.register(new Add(commandReciever));
        commandInvoker.register(new Info(commandReciever));
        commandInvoker.register( new Show(commandReciever));
        commandInvoker.register(new Clear(commandReciever));
        commandInvoker.register(new ExecuteScript(commandReciever));
        commandInvoker.register(new Exit(commandReciever));
        commandInvoker.register(new FilterGreaterThanSemester(commandReciever));
        commandInvoker.register(new History(commandReciever));
        commandInvoker.register(new PrintAscending(commandReciever));
        commandInvoker.register(new PrintDescending(commandReciever));
        commandInvoker.register(new RemoveById(commandReciever));
        commandInvoker.register(new RemoveLower(commandReciever));
        commandInvoker.register(new Reorder(commandReciever));
        commandInvoker.register(new Save(commandReciever));
        commandInvoker.register(new UpdateId(commandReciever));



        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                commandInvoker.executeCommand(scanner.nextLine().trim().split(" "));
            }
        }

        session.closeSession();
    }


}
