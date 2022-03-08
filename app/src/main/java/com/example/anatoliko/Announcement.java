package com.example.anatoliko;

import android.widget.SeekBar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//ΚΛΑΣΗ ΑΝΤΙΚΕΙΜΕΝΩΝ ΑΝΑΚΟΙΝΩΣΕΩΝ

public class Announcement {

    private int _id;
    private String _content;
    private String _title;
    private String _date;
    private String _time;


    public Announcement() {
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String get_content() {
        return _content;
    }

    public String get_title() {
        return _title;
    }

    public void set_date() {
        this._date = new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault()).format(new Date());
    }
    public void set_time() {
        this._time = new SimpleDateFormat("hh-mm-ss", Locale.getDefault()).format(new Date());
    }

    public String get_date() {
        return _date;
    }

    public String get_time() { return _time; }



}
