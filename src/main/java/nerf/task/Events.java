package nerf.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Task{
    private final LocalDate  fromDate;
    private final LocalDate  toDate;
    public Events(String description,LocalDate fromDate, LocalDate toDate){
        super(description);
        if (fromDate == null || toDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Events(String description, boolean status, LocalDate fromDate, LocalDate toDate){
        super(description,status);
        if (fromDate == null || toDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    private String dateToString(LocalDate date,boolean save){
        if (save){
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    public String getSaveFormat(){
        return String.format("E | %s | %s | %s", super.getSaveFormat(),dateToString(this.fromDate,true),dateToString(this.toDate,true));
    }

    @Override
    public String toString(){
        return String.format("[E]%s (from: %s to: %s)",super.toString(),dateToString(this.fromDate,false),dateToString(this.toDate,false));
    }
}