package commands;

import exceptions.ArgumentNeeded;

import java.io.IOException;
import java.net.Socket;

public class RemoveById extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public RemoveById (Receiver commandReciever) {
        super("remove_by_id");
        this.commandReciever = commandReciever;
    }
    public RemoveById() {
        super("remove_by_id");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Что-то пошло не так (введен ненужный элемент)");
        }
        commandReciever.removeById(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("remove_by_id: удалить элемент из коллекции по его id");
    }
}
