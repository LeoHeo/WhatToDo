package com.tishighnoongmail.whattodo;

/**
 * Created by rcharkowicz on 6/21/2016.
 */
public class ToDo {
//  Let's Set up some Data structure skee skee pretty done nigga
    private String title, details;
    private long noteId, dateCreatedMilli;
    private Priority priority;
    private Status status;

    public enum Priority{High, Medium, Low}
    public enum Status{Underway, ToDo, Done}

    public ToDo(String title, String details, Priority priority, Status status){
        this.title = title;
        this.details = details;
        this.priority = priority;
        this.status = status;
        this.noteId = 0;
        this.dateCreatedMilli = 0;

    }
    public ToDo(String title, String details, Priority priority, Status status, long noteId, long dateCreatedMilli) {
        this.title = title;
        this.details = details;
        this.priority = priority;
        this.status = status;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }
    public String getTitle(){return title;}
    public String getDetails(){return title;}
    public Priority getPriority(){return priority;}
    public Status getStatus(){return status;}
    public long getDate(){return dateCreatedMilli;}
    public long getId(){return noteId;}

    public String toString() {
        return "Id: " + noteId + "Title: " + title + "Details: " + details + "Priority: " + priority.name() + "Status: " + status.name() + "Date: ";
    }
    public String getstringfromprio(){
        return priopicker(priority);
    }
    public static String priopicker(Priority notePriority){
        switch(notePriority){
            case High:
                return "High";
            case Medium:
                return "Medium";
            case Low:
                return "Low";
        }
        return "Priority";

    }
    public String getstringfromstatus(){
        return statuspicker(status);
    }
    public static String statuspicker(Status noteStatus){
        switch(noteStatus){
            case Underway:
                return "Underway";
            case ToDo:
                return "To do";
            case Done:
                return "Done";
        }
        return "Status";
}
