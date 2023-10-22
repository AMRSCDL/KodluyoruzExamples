package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.EducatorTasks;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JButton btn_educator_logout;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_educator_task_list;
    private JScrollPane scrl_educator_task_list;
    private JTable tbl_educator_task;
    private JTable tbl_educator_courses;
    private JScrollPane scrl_educator_courses;
    private JPanel pnl_educator_form;
    private JTextField fld_eduTask_name;
    private JTextField fld_eduTask_info;
    private JTextField fld_eduTask_ytLink;
    private JTextField fld_eduTask_quizQues;
    private JComboBox cmb_eduTask_witchCourse;
    private JButton btn_eduTask_add;
    private JButton btn_eduTask_del;
    private JTextField fld_eduTask_id;
    private JComboBox cmb_task_list;
    private JButton btn_task_list;
    private DefaultTableModel mdl_educator_task_list;
    private Object[] row_educator_task_list;
    private DefaultTableModel mdl_educator_courses;
    private Object[] row_educator_courses;
    private User u;


    public EducatorGUI(User u) {
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        String educator_name = u.getName();
        u.setName(educator_name);
        this.u = u;


        lbl_welcome.setText("Hoşgeldiniz: " + educator_name);
        //EducatorTaskList

        mdl_educator_task_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_eduTasks_list = {"ID", "Başlık", "Açıklama", "ytLink", "Quiz Sorular", "Ders"};
        mdl_educator_task_list.setColumnIdentifiers(col_eduTasks_list);
        row_educator_task_list = new Object[col_eduTasks_list.length];

        loadEduTaskModel();


        tbl_educator_task.setModel(mdl_educator_task_list);
        tbl_educator_task.getTableHeader().setReorderingAllowed(false);

        tbl_educator_task.getSelectionModel().addListSelectionListener(e->{
            try {
                String select_task_id = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),0).toString();
                fld_eduTask_id.setText(select_task_id);
            }catch (Exception exception){}
        });

        //**EducatorTaskList

        //EducatorCourses
        mdl_educator_courses = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] col_course_list = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_educator_courses.setColumnIdentifiers(col_course_list);
        row_educator_courses = new Object[col_course_list.length];

        if (u.getType().equals("educator")) {
            loadCourseModelByEducator();
            loadWitchCourseCombo();
            loadSearchCourseCombo();
        }

        tbl_educator_courses.setModel(mdl_educator_courses);
        tbl_educator_courses.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_educator_courses.getTableHeader().setReorderingAllowed(false);

        tbl_educator_task.getModel().addTableModelListener(e-> {
            if (e.getType() == TableModelEvent.UPDATE){
                int task_id=Integer.parseInt(tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),0).toString());
                String task_name = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),1).toString();
                String task_info = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),2).toString();
                String task_yt_link = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),3).toString();
                String task_quiz_ques = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),4).toString();
                String task_ait_oldugu_ders = tbl_educator_task.getValueAt(tbl_educator_task.getSelectedRow(),5).toString();

                if (EducatorTasks.update(task_id,task_name,task_info,task_yt_link,task_quiz_ques,task_ait_oldugu_ders)){
                    Helper.showMsg("done");
                }
                loadEduTaskModel();
            }
        });
        //**EducatorCourses

        btn_educator_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_eduTask_add.addActionListener(e -> {
            Item courseItem = (Item) cmb_eduTask_witchCourse.getSelectedItem();
            if (Helper.isFieldEmpty(fld_eduTask_info) || Helper.isFieldEmpty(fld_eduTask_name) || Helper.isFieldEmpty(fld_eduTask_ytLink) || Helper.isFieldEmpty(fld_eduTask_quizQues)) {
                Helper.showMsg("fill");
            }else {
                if (EducatorTasks.add(fld_eduTask_name.getText(),fld_eduTask_info.getText(),fld_eduTask_ytLink.getText(),fld_eduTask_quizQues.getText(),courseItem.getValue())){
                    Helper.showMsg("done");
                    loadEduTaskModel();
                    fld_eduTask_name.setText(null);
                    fld_eduTask_info.setText(null);
                    fld_eduTask_ytLink.setText(null);
                    fld_eduTask_quizQues.setText(null);
                }else {
                    Helper.showMsg("error");
                    fld_eduTask_name.setText(null);
                    fld_eduTask_info.setText(null);
                    fld_eduTask_ytLink.setText(null);
                    fld_eduTask_quizQues.setText(null);
                }
            }
        });
        btn_eduTask_del.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_eduTask_id)){
                Helper.showMsg("fill");
            }else {
                if (Helper.confirm("sure")){
                    int task_id = Integer.parseInt(fld_eduTask_id.getText());
                    if (EducatorTasks.delete(task_id)){
                        Helper.showMsg("done");
                        loadEduTaskModel();
                        fld_eduTask_id.setText(null);
                    }else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
        btn_task_list.addActionListener(e -> {
            String ait_oldugu_ders = ((Item) cmb_task_list.getSelectedItem()).getValue().toString();
            String query = EducatorTasks.searchQuery(ait_oldugu_ders);
            ArrayList<EducatorTasks> searchingEduTasks = EducatorTasks.searchEduTaskList(query);
            loadEduTaskModel(searchingEduTasks);
        });
    }

    public void loadEduTaskModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_task.getModel();
        clearModel.setRowCount(0);
        for (EducatorTasks obj : EducatorTasks.getList()) {
            int i = 0;
            row_educator_task_list[i++] = obj.getId();
            row_educator_task_list[i++] = obj.getName();
            row_educator_task_list[i++] = obj.getInfo();
            row_educator_task_list[i++] = obj.getYt_link();
            row_educator_task_list[i++] = obj.getQuiz_ques();
            row_educator_task_list[i++] = obj.getAit_oldugu_ders();
            mdl_educator_task_list.addRow(row_educator_task_list);
        }
    }
    public void loadEduTaskModel(ArrayList<EducatorTasks> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_task.getModel();
        clearModel.setRowCount(0);
        int i;
        for (EducatorTasks obj : list) {
            i = 0;
            row_educator_task_list[i++] = obj.getId();
            row_educator_task_list[i++] = obj.getName();
            row_educator_task_list[i++] = obj.getInfo();
            row_educator_task_list[i++] = obj.getYt_link();
            row_educator_task_list[i++] = obj.getQuiz_ques();
            row_educator_task_list[i++] = obj.getAit_oldugu_ders();
            mdl_educator_task_list.addRow(row_educator_task_list);
        }
    }

    private void loadCourseModelByEducator() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_educator_courses.getModel();
        clearModel.setRowCount(0);
        int i = 0;

        if (u != null) {
            String educatorName = u.getName();

            for (Course obj : Course.getList()) {
                if (educatorName.equals(obj.getEducator().getName())) {
                    i = 0;
                    row_educator_courses[i++] = obj.getId();
                    row_educator_courses[i++] = obj.getName();
                    row_educator_courses[i++] = obj.getLang();
                    row_educator_courses[i++] = obj.getPatika().getName();
                    row_educator_courses[i++] = obj.getEducator().getName();
                    mdl_educator_courses.addRow(row_educator_courses);
                }
            }
        }
    }

    private void loadWitchCourseCombo() {
        cmb_eduTask_witchCourse.removeAllItems();

        if (u != null) {
            String educatorName = u.getName();

            for (Course obj : Course.getList()) {
                if (educatorName.equals(obj.getEducator().getName())) {
                    cmb_eduTask_witchCourse.addItem(new Item (obj.getId(),obj.getName()));
                }
            }
        }
    }
    private void loadSearchCourseCombo() {
        cmb_task_list.removeAllItems();
        if (u != null) {
            String educatorName = u.getName();
            for (Course obj : Course.getList()) {
                if (educatorName.equals(obj.getEducator().getName())) {
                    cmb_task_list.addItem(new Item (obj.getId(),obj.getName()));
                }
            }
        }
    }
}