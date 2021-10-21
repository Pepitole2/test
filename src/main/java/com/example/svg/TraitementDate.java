package com.example.svg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class TraitementDate {

    TraitementDate(){}

    public ArrayList<String> GetDateTrier(ArrayList<String> str) {

        Collections.sort(str, new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o1).compareTo(f.parse(o2));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        //System.out.println("Date trier : " + str);
        return str;

    }
    

    // -------------------transformation-des-date-en-Semaine------------------------
    public List<Integer> semaineDate(ArrayList<String> str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Integer> week = new ArrayList<Integer>();
        for (int i = 0; i < str.size(); i++) {
            LocalDate date = LocalDate.parse(str.get(i), formatter);
            WeekFields wf = WeekFields.of(Locale.getDefault());
            TemporalField weekNum = wf.weekOfWeekBasedYear();
            week.add(Integer.parseInt(String.format("%02d", date.get(weekNum))));
        }
        System.out.println(week);
        return week;
    }

    //Transforme le date au format String au jour qui correspond dans l'année
    public int haveDayofYear(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        int day=date.getDayOfYear();
        
        //System.out.println(day);
        return day;
    }

    public int haveMonthValue(String str)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(str, formatter);
        int month = date.getMonthValue();

        // System.out.println(day);
        return month;
    }


    public List<Integer> monthDate(ArrayList<String> str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Integer> month = new ArrayList<Integer>();
        for (int i = 0; i < str.size(); i++) {
            LocalDate date = LocalDate.parse(str.get(i), formatter);
            date.getMonthValue();
            month.add(date.getMonthValue());
        }
        //System.out.println(month);
        return month;
    }
}
