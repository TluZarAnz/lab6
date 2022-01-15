package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Help extends Command {

    private Receiver commandReciever;

    public Help (Receiver commandReciever) {
        super("help");
        this.commandReciever = commandReciever;
    }
    public Help() {
        super("help");
    }


    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.help();
    }

    @Override
    protected void writeInfo() {
        System.out.println("help: вывести справку по доступным командам");
    }

}
