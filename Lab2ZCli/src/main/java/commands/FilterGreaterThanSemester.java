package commands;

import exceptions.ArgumentNeeded;

import java.io.IOException;
import java.net.Socket;

public class FilterGreaterThanSemester extends Command{
    private static final long serialVersionUID = 32L;
    transient private Receiver commandReciever;

    public FilterGreaterThanSemester (Receiver commandReciever) {
        super("filter_greater_than_semester_enum");
        this.commandReciever = commandReciever;
    }
    public FilterGreaterThanSemester() {
        super("filter_greater_than_semester_enum");
    }


    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Что-то пошло не так (введен ненужный элемент)");
        }
        commandReciever.filterG(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("filter_greater_than_semester_enum: вывести элементы, значение поля semesterEnum которые больше заданного");
    }
}
