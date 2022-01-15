package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class PrintAscending extends Command {
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public PrintAscending(Receiver commandReciever) {
        super("print_ascending");
        this.commandReciever = commandReciever;
    }
    public PrintAscending() {
        super("print_ascending");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.printAscending();
    }

    @Override
    protected void writeInfo() {
        System.out.println("print_ascending: вывести элементы коллекции в порядке возрастания");
    }
}
