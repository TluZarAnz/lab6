package commands;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public abstract class Command implements Serializable {
    private static final long serialVersionUID = 32L;
    String name;
    public Command(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void writeInfo();
    protected abstract void execute(String[] args) throws IOException, ClassNotFoundException,
            InterruptedException;

}
