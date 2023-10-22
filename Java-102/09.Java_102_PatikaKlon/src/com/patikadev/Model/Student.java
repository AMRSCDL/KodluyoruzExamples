package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.sun.source.tree.BreakTree;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student {
    private int kayit_numarasi;
    private int ders_id;
    private int course_id;
    private int patika_id;
    private Course course;
    private Patika patika;

    public Student() {}

    public Student(int kayit_numarasi, int ders_id,int course_id, int patika_id) {
        this.kayit_numarasi = kayit_numarasi;
        this.ders_id = ders_id;
        this.course_id=course_id;
        this.patika_id=patika_id;
        this.course=Course.getFetch(this.course_id);
        this.patika=Patika.getFetch(this.patika_id);
    }

    public int getKayit_numarasi() {
        return kayit_numarasi;
    }

    public void setKayit_numarasi(int kayit_numarasi) {
        this.kayit_numarasi = kayit_numarasi;
    }

    public int getDers_id() {
        return ders_id;
    }

    public void setDers_id(int ders_id) {
        this.ders_id = ders_id;
    }

    public Course getC() {
        if (course == null) {
            course = Course.getFetch(this.course_id);
        }
        return course;
    }

    public void setC(Course course) {
        this.course = course;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public static ArrayList<Student> getList(){
        ArrayList<Student> ownCourseList = new ArrayList<>();
        String query = "SELECT * FROM student";
        Student obj;
        try{
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Student();
                obj.setKayit_numarasi(rs.getInt("kayit_numarasi"));
                obj.setCourse_id(rs.getInt("ders_id"));
                ownCourseList.add(obj);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ownCourseList;
    }
}
