package commands;

import exceptions.ArgumentNeeded;

import java.io.IOException;
import java.net.Socket;

public class ExecuteScript extends Command{
    private static final long serialVersionUID = 32L;
    transient  private Receiver commandReciever;
    private static String path;

    public ExecuteScript (Receiver commandReciever) {
        super("execute_script");
        this.commandReciever = commandReciever;
    }
    public ExecuteScript() {
        super("execute_script");
    }


    @Override
    protected void execute(String[] args) throws StackOverflowError, IOException {
        try {
            if (args.length > 2) {
                System.out.println("Некорректное количество аргументов. Для справки напишите help.");
            }
            else {
                path = args[1]; commandReciever.executeScript(args[1]);
                ; }
        } catch (StackOverflowError ex) {
            System.out.println("Ошибка! Обнаружен выход за пределы стека");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void writeInfo() {
        System.out.println("execute_script: считать и исполнить скрипт из указанного файла");
    }

    public static String getPath() {
        return path;
    }
}
