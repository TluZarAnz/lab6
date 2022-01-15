package commands;

import exceptions.NoRelevantException;

import java.io.IOException;
import java.net.Socket;

public class Save extends Command{

    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public Save(Receiver commandReciever) {
        super("save");
        this.commandReciever = commandReciever;
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Опаньки! Что-то пошло не так");
        }
        //commandReciever.save();
    }

    @Override
    protected void writeInfo() {

    }
}
