package commands;

import client.ClientSender;

import server.SerializedArgumentCommand;
import server.SerializedCombinedCommand;
import server.SerializedObjectCommand;
import server.SerializedSimplyCommand;
import utils.*;
import java.io.*;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Stack;

/**
 * шаблон команда
 * класс Receiver (получатель) – располагает информацией о способах выполнения операций.
 */
public class Receiver {
    private final Invoker commandInvoker;
    private final ClientSender sender;
    private final SocketChannel socketChannel;
    private final Integer delay;
    private final StudyGroupFactory creator;
    private Stack<String> history = new Stack<>();




    public Receiver(Invoker commandInvoker, ClientSender sender, SocketChannel socketChannel, Integer delay, StudyGroupFactory creator) {
        this.commandInvoker = commandInvoker;
        this.sender = sender;
        this.socketChannel = socketChannel;
        this.delay = delay;
        this.creator = creator;
    }

    public void help() {
        history.push("help");

        Iterator<Command> iterator = commandInvoker.getCommands().iterator();
        while (iterator.hasNext()) {
            Command A = iterator.next();
            A.writeInfo();
        }
    }


    public  void add() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("add");

        sender.toSend(new SerializedObjectCommand(new Add(), StudyGroupFactory.studyGroupFactory()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public void removeById(String id) throws IOException, InterruptedException, ClassNotFoundException {
        history.push("remove_by_id");

        sender.toSend(new SerializedArgumentCommand(new RemoveById(), id));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public void filterG(String op) throws IOException, InterruptedException, ClassNotFoundException {
        history.push("filter_greater_than_semester_enum");

        sender.toSend(new SerializedArgumentCommand(new FilterGreaterThanSemester(), op));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public  void show() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("show");

        sender.toSend(new SerializedSimplyCommand(new Show()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public  void exit() throws InterruptedException, IOException, ClassNotFoundException {
        history.push("exit");

        sender.toSend(new SerializedSimplyCommand(new Exit()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }



    public  void clear() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("clear");

        sender.toSend(new SerializedSimplyCommand(new Clear()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);

    }


    public  void info() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("info");

        sender.toSend(new SerializedSimplyCommand(new Info()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public void  history() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("history");
        System.out.println(history.subList(Math.max(history.size()-12,0),history.size()));

        sender.toSend(new SerializedSimplyCommand(new History()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public void printAscending() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("print_ascending");

        sender.toSend(new SerializedSimplyCommand(new PrintAscending()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);

    }
    public void printDescending() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("print_descending");

        sender.toSend(new SerializedSimplyCommand(new PrintDescending()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);

    }
    public void reorder() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("reorder");

        sender.toSend(new SerializedSimplyCommand(new Reorder()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);

    }

    public void removeLower() throws IOException, InterruptedException, ClassNotFoundException {
        history.push("remove_lower");

        sender.toSend(new SerializedObjectCommand(new RemoveLower(), StudyGroupFactory.studyGroupFactory()));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);
    }

    public void updateId(String in) throws IOException, InterruptedException, ClassNotFoundException {
        history.push("update_id");

        sender.toSend(new SerializedCombinedCommand(new UpdateId(), StudyGroupFactory.studyGroupFactory() ,Integer.parseInt(in)));
        Thread.sleep(delay);
        client.Receiver.receive(socketChannel);

    }

    public  void executeScript(String path) throws IOException, ClassNotFoundException, InterruptedException {
        history.push("execute_script");

        //sender.toSend(new SerializedArgumentCommand(new ExecuteScript(), path));
        //Thread.sleep(delay);
        //client.Receiver.receive(socketChannel);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            while ((line = reader.readLine()) != null) {
                commandInvoker.executeCommand(line.split(" "));
            }
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }

    }



}
