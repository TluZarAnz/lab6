package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Show extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Show(Receiver commandReciever) {
        super("show");
        this.commandReciever = commandReciever;
    }

    public Show() {
        super("show");
    }

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.show();
    }

    @Override
    protected void writeInfo() {
        System.out.println("show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
