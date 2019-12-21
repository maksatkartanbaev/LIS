package sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Fine {
    double amount;

    String date;

    int memberId;

    public Fine(String date, Member member, Transaction transaction){
        this.date = date;
        this.memberId = member.getMemberId();
    }

//    public double calculateFine(Transaction transaction){
//
//    }

}
