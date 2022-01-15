package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Exit extends Command{

    private Receiver commandReciever;

    public Exit(Receiver commandReciever) {
        super("exit");
        this.commandReciever = commandReciever;
    }

    public Exit() {
        super("exit");
    }

    @Override
    protected void execute(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        commandReciever.exit();
    }

    @Override
    protected void writeInfo() {
        System.out.println("exit: завершить без сохранения");
    }

}
