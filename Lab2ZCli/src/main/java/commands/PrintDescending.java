package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class PrintDescending extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public PrintDescending(Receiver commandReciever) {
        super("print_descending");
        this.commandReciever = commandReciever;
    }

    public PrintDescending() {
        super("print_descending");
    }

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.printDescending();
    }

    @Override
    protected void writeInfo() {
        System.out.println("print_descending: вывести элементы коллекции в порядке убывания");
    }
}
