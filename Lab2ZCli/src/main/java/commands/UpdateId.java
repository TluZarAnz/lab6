package commands;

import exceptions.ArgumentNeeded;
import utils.StudyGroup;

import java.io.IOException;
import java.net.Socket;

public class UpdateId extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public UpdateId (Receiver commandReciever) {
        super("update");
        this.commandReciever = commandReciever;
    }

    public UpdateId() {
        super("update");
    }

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Что-то пошло не так (введен ненужный элемент)");
        }
        commandReciever.updateId(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("update: обновить значение элемента коллекции, id которого равен заданному");
    }
}
