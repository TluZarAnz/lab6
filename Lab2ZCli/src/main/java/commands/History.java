package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class History extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public History(Receiver commandReciever) {
        super("history");
        this.commandReciever = commandReciever;
    }
    public History() {
        super("history");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.history();
    }

    @Override
    protected void writeInfo() {
        System.out.println("history: вывести последние 12 команд (без их аргументов)");
    }
}
