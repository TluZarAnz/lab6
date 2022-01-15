package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Reorder extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Reorder(Receiver commandReciever) {
        super("reorder");
        this.commandReciever = commandReciever;
    }
    public Reorder() {
        super("reorder");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.reorder();
    }

    @Override
    protected void writeInfo() {
        System.out.println("reorder: отсортировать коллекцию обратно заданной");
    }
}
