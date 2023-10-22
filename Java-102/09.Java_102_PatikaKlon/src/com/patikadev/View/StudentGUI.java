package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Patika;
import com.patikadev.Model.Student;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JTable tbl_stuOwnCourse_list;
    private JScrollPane scrl_stuOwn_courses;
    private JTable tbl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_course_list;
    private JScrollPane scrl_course_list;
    private JButton btn_student_logout;
    private JTextField fld_course_id;
    private JButton btn_register_course;
    private JLabel lbl_student_welcome;
    private DefaultTableModel mdlStudentOwnCoursesList;
    private Object[] rowStudentOwnCoursesList;
    private DefaultTableModel mdlPatikaList;
    private Object[] rowPatikaList;
    private DefaultTableModel mdlCourseList;
    private Object[] rowCourseList;
    private User s;

    public StudentGUI(User s){
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        String student_name = s.getName();
        s.setName(student_name);
        this.s = s;


        lbl_welcome.setText("Hoşgeldiniz: " + student_name);
        //StudentOwnCoursesModel
        mdlStudentOwnCoursesList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] col_StudentOwnCourses_list = {"ID", "Ders ID"};
        mdlStudentOwnCoursesList.setColumnIdentifiers(col_StudentOwnCourses_list);
        rowStudentOwnCoursesList = new Object[col_StudentOwnCourses_list.length];
        loadStudentOwnCoursesModel();
        tbl_stuOwnCourse_list.setModel(mdlStudentOwnCoursesList);
        tbl_stuOwnCourse_list.getTableHeader().setReorderingAllowed(false);
        tbl_stuOwnCourse_list.getColumnModel().getColumn(0).setMaxWidth(50);
        //**StudentOwnCoursesModel

        //PatikaList
        mdlPatikaList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdlPatikaList.setColumnIdentifiers(col_patika_list);
        rowPatikaList = new Object[col_patika_list.length];


        loadPatikaModel();

        tbl_patika_list.setModel(mdlPatikaList);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(50);
        //**PatikaList

        //CourseList
        mdlCourseList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] col_course_list = {"ID", "Ders Adı", "Prpgramlama Dili", "Patika", "Eğitmen"};
        mdlCourseList.setColumnIdentifiers(col_course_list);
        rowCourseList = new Object[col_course_list.length];

        loadCourseModel();

        tbl_course_list.setModel(mdlCourseList);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        //**CourseList


        tbl_course_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_course_id = tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString();
                fld_course_id.setText(select_course_id);
            } catch (Exception exception) {

            }
        });

        btn_student_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_register_course.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_course_id)){
                Helper.showMsg("fill");
            }else{

            }
        });
    }
    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Patika obj : Patika.getList()) {
            i = 0;
            rowPatikaList[i++] = obj.getId();
            rowPatikaList[i++] = obj.getName();
            mdlPatikaList.addRow(rowPatikaList);
        }
    }
    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            rowCourseList[i++] = obj.getId();
            rowCourseList[i++] = obj.getName();
            rowCourseList[i++] = obj.getLang();
            rowCourseList[i++] = obj.getPatika().getName();
            rowCourseList[i++] = obj.getEducator().getName();
            mdlCourseList.addRow(rowCourseList);
        }
    }

    private void loadStudentOwnCoursesModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_stuOwnCourse_list.getModel();
        clearModel.setRowCount(0);

        int i = 0;
        for (Student student : Student.getList()){
            rowStudentOwnCoursesList[i++] = student.getKayit_numarasi();
            rowStudentOwnCoursesList[i++] = student.getDers_id();
            mdlStudentOwnCoursesList.addRow(rowStudentOwnCoursesList);
        }
    }
}
