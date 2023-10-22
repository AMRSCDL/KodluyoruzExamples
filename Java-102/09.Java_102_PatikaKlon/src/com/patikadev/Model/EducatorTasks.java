package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import javax.swing.plaf.IconUIResource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EducatorTasks {
    private int id;
    private String name;
    private String info;
    private String yt_link;
    private String quiz_ques;
    private String ait_oldugu_ders;
    private Course course;
    public EducatorTasks(){}

    public EducatorTasks(int id,String name, String info, String yt_link, String quiz_ques, String ait_oldugu_ders) {
        this.id=id;
        this.name = name;
        this.info = info;
        this.yt_link = yt_link;
        this.quiz_ques = quiz_ques;
        this.ait_oldugu_ders = ait_oldugu_ders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getYt_link() {
        return yt_link;
    }

    public void setYt_link(String yt_link) {
        this.yt_link = yt_link;
    }

    public String getQuiz_ques() {
        return quiz_ques;
    }

    public void setQuiz_ques(String quiz_ques) {
        this.quiz_ques = quiz_ques;
    }

    public String getAit_oldugu_ders() {
        return ait_oldugu_ders;
    }

    public void setAit_oldugu_ders(String ait_oldugu_ders) {
        this.ait_oldugu_ders = ait_oldugu_ders;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static boolean add(String name, String info, String  yt_link, String quiz_ques,String ait_oldugu_ders) {
        String query = "INSERT INTO educator_tasks (name,info,yt_link,quiz_ques,ait_oldugu_ders) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, info);
            pr.setString(3, yt_link);
            pr.setString(4, quiz_ques);
            pr.setString(5,ait_oldugu_ders);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static ArrayList<EducatorTasks> getList(){
        ArrayList<EducatorTasks> eduTaskList = new ArrayList<>();
        String query = "SELECT * FROM educator_tasks";
        EducatorTasks obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new EducatorTasks();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setInfo(rs.getString("info"));
                obj.setYt_link(rs.getString("yt_link"));
                obj.setQuiz_ques(rs.getString("quiz_ques"));
                obj.setAit_oldugu_ders(rs.getString("ait_oldugu_ders"));
                eduTaskList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eduTaskList;
    }
    public static boolean delete(int id){
        String query="DELETE FROM educator_tasks WHERE id = ?";
        PreparedStatement pr=null;
        try {
            pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return  pr.executeUpdate() != -1;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static ArrayList<EducatorTasks> searchEduTaskList(String query){
        ArrayList <EducatorTasks> eduTaskList = new ArrayList<>();
        EducatorTasks obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj=new EducatorTasks();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setInfo(rs.getString("info"));
                obj.setYt_link(rs.getString("yt_link"));
                obj.setQuiz_ques(rs.getString("quiz_ques"));
                obj.setAit_oldugu_ders(rs.getString("ait_oldugu_ders"));
                eduTaskList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  eduTaskList;
    }
    public static String searchQuery(String ait_oldugu_ders){
        String query = "SELECT * FROM educator_tasks WHERE ait_oldugu_ders LIKE '%{{ait_oldugu_ders}}%'";
        query =query.replace("{{ait_oldugu_ders}}",ait_oldugu_ders);
        return query;
    }
    public static EducatorTasks getFetch(int id){
        EducatorTasks obj = null;
        String query ="SELECT * FROM educator_tasks WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new EducatorTasks();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setInfo(rs.getString("info"));
                obj.setYt_link(rs.getString("yt_link"));
                obj.setQuiz_ques(rs.getString("quiz_ques"));
                obj.setAit_oldugu_ders(rs.getString("ait_oldugu_ders"));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
    public static boolean update(int id,String name, String info, String yt_link,String quiz_ques,String ait_oldugu_ders){
        String query = "UPDATE educator_tasks SET name=?,info=?,yt_link=?,quiz_ques=?,ait_oldugu_ders=? WHERE id = ?";
        EducatorTasks findEduTask = EducatorTasks.getFetch(name);
        EducatorTasks findEduYtTask = EducatorTasks.getFetchYT(yt_link);
        if (findEduTask != null && findEduTask.getId() != id){
            Helper.showMsg("Aynı isimde başka bir içerik var. Lütfen başka bir metin deneyin.");
            return false;
        }
        if (findEduYtTask != null && findEduYtTask.getId() != id){
            Helper.showMsg("Aynı link'i başka bir içerik içinde vermişsiniz. İçeriklerin linki aynı olamaz.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,info);
            pr.setString(3,yt_link);
            pr.setString(4,quiz_ques);
            pr.setString(5,ait_oldugu_ders);
            pr.setInt(6,id);
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static EducatorTasks getFetch(String name){
        EducatorTasks obj = null;
        String query ="SELECT * FROM educator_tasks WHERE name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new EducatorTasks();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setInfo(rs.getString("info"));
                obj.setYt_link(rs.getString("yt_link"));
                obj.setQuiz_ques(rs.getString("quiz_ques"));
                obj.setAit_oldugu_ders(rs.getString("ait_oldugu_ders"));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
    public static EducatorTasks getFetchYT(String yt_link){
        EducatorTasks obj = null;
        String query ="SELECT * FROM educator_tasks WHERE yt_link = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,yt_link);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj=new EducatorTasks();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setInfo(rs.getString("info"));
                obj.setYt_link(rs.getString("yt_link"));
                obj.setQuiz_ques(rs.getString("quiz_ques"));
                obj.setAit_oldugu_ders(rs.getString("ait_oldugu_ders"));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
}
