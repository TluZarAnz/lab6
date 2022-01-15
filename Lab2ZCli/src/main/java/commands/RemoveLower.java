package commands;

import exceptions.NoRelevantException;
import utils.StudyGroup;

import java.io.IOException;
import java.net.Socket;

public class RemoveLower extends Command {
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public RemoveLower (Receiver commandReciever) {
        super("remove_lower");
        this.commandReciever = commandReciever;
    }
    public RemoveLower() {
        super("remove_lower");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Что-то пошло не так (введен ненужный элемент)");
        }
        commandReciever.removeLower();
    }

    @Override
    protected void writeInfo() {
        System.out.println("remove_lower: удалить из коллекции все элементы, меньшие, чем заданный");
    }
}
