package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Clear extends Command {

    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Clear(Receiver commandReciever) {
        super("clear");
        this.commandReciever = commandReciever;
    }

    public Clear() {
        super("clear");
    }

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.clear();
    }

    @Override
    protected void writeInfo() {
        System.out.println("clear: очистить коллекцию");
    }
}
