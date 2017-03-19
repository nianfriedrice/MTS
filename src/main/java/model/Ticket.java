package model;

import controller.DatabaseConnector;

import java.util.ArrayList;

/**
 * Created by NortonWEI on 3/3/2017.
 */
public class Ticket {
    private int ticketId = 0;
    private int userId = 0;
    private int scheduleId = 0;
    private int category = 0;
    private String seatRow = "";

    private int seatColumn = 0;

    public Ticket(int uid, int sid, int ticketType, String row, int seatColumn) {
        setId();
        this.userId = uid;
        this.scheduleId = sid;
        this.category = ticketType;
        this.seatRow = row;
        this.seatColumn = seatColumn;
    }

    public Ticket(int ticketId, int userId, int scheduleId, int category, String seatRow, int seatColumn) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.category = category;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    private void setId() {
        boolean ifBreak = false;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        ArrayList<Integer> ticketIdList = databaseConnector.listId("TICKET");
        for (int i=0; i<ticketIdList.size(); i++) {
            if (ticketIdList.get(i) != i) {
                ticketId = i;
                ifBreak = true;
                break;
            }
        }
        if (!ifBreak) {
            if (!ticketIdList.isEmpty()) {
                ticketId = ticketIdList.get(ticketIdList.size()-1) + 1;
            }
        }
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getCategory() {
        return category;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }
}
