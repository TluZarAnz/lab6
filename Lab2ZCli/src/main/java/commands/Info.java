package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Info extends Command {

    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Info(Receiver commandReciever) {
        super("info");
        this.commandReciever = commandReciever;
    }
    public Info() {
        super("info");
    }



    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.info();
    }

    @Override
    protected void writeInfo() {
        System.out.println("info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
