package commands;

import exceptions.NoRelevantException;
import utils.StudyGroup;

import java.io.IOException;
import java.net.Socket;

public class Add extends Command {


    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Add(Receiver commandReciever) {
        super("add");
        this.commandReciever = commandReciever;
    }

    public Add() {
        super("add");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Что-то пошло не так (введен ненужный элемент)");
        }
        commandReciever.add();
    }

    @Override
    protected void writeInfo() {
        System.out.println("add: добавить новый элемент в коллекцию");
    }


}
