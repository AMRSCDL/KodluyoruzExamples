package com.patikadev.View;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import com.patikadev.Helper.*;
import com.patikadev.Model.*;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane pnl_patika_list;
    private JLabel lbl_welcome;
    private JPanel pbl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JPanel pnl_patika_add;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private JTextField fld_course_id;
    private JButton btn_course_delete;
    private JTable tbl_eduTask_list;
    private JScrollPane scrl_EduTasks_list;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private DefaultTableModel mdl_edu_tasks_list;
    private Object[] row_eduTasks_list;


    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        lbl_welcome.setText("Hoşgeldin : " + operator.getName());

        //UserList
        mdl_user_list = new DefaultTableModel() {
            @Override
// burası sayesinde uygulamada 0.column düzenlenebilirliği kapatılmış oluyor yani kullanıcı id kısmına tıklayı değişiklik yapamaz
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];
        loadUserModel();

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                fld_user_id.setText(select_user_id);
            } catch (Exception exception) {

            }
        });

        tbl_user_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String user_uname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String user_pass = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();

                if (User.update(user_id, user_name, user_uname, user_pass, user_type)) {
                    Helper.showMsg("done");
                }
                loadUserModel();
                loadEducatorCombo();
                loadCourseModel();
            }
        });
        //** ModelUserList

        //PatikaList

        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            UpdatePatikaGUI updateGUI = new UpdatePatikaGUI(Patika.getFetch(select_id));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadEducatorCombo();
                    loadCourseModel();
                }
            });
        });
        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                if (Patika.delete(select_id)) {
                    Helper.showMsg("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadEducatorCombo();
                    loadCourseModel();
                } else {
                    Helper.showMsg("error");
                }
            }
        });

        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(50);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selected_row, selected_row);
            }
        });
        //** ModelPatikaList

        //CourseList

        mdl_course_list = new DefaultTableModel() {
            @Override
// burası sayesinde uygulamada 0.column düzenlenebilirliği kapatılmış oluyor yani kullanıcı id kısmına tıklayı değişiklik yapamaz
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_course_list = {"ID", "Ders Adı", "Prpgramlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];

        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        tbl_course_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_course_id = tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString();
                fld_course_id.setText(select_course_id);
            } catch (Exception exception) {

            }
        });

        loadPatikaCombo();
        loadEducatorCombo();


        //**CourseList

        //EduTaskList

        mdl_edu_tasks_list=new DefaultTableModel() {
            @Override
// burası sayesinde uygulamada 0.column düzenlenebilirliği kapatılmış oluyor yani kullanıcı id kısmına tıklayı değişiklik yapamaz
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_eduTasks_list = {"ID", "Başlık", "Açıklama", "yt_link", "Quiz Sorular","Ders"};
        mdl_edu_tasks_list.setColumnIdentifiers(col_eduTasks_list);
        row_eduTasks_list =new Object[col_eduTasks_list.length];
        loadEduTaskModel();

        tbl_eduTask_list.setModel(mdl_edu_tasks_list);
        tbl_eduTask_list.getTableHeader().setReorderingAllowed(false);
        tbl_eduTask_list.getColumnModel().getColumn(0).setMaxWidth(50);

        tbl_eduTask_list.getModel().addTableModelListener(e-> {
            if (e.getType() == TableModelEvent.UPDATE){
                int task_id=Integer.parseInt(tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),0).toString());
                String task_name = tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),1).toString();
                String task_info = tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),2).toString();
                String task_yt_link = tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),3).toString();
                String task_quiz_ques = tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),4).toString();
                String task_ait_oldugu_ders = tbl_eduTask_list.getValueAt(tbl_eduTask_list.getSelectedRow(),5).toString();
                if (EducatorTasks.update(task_id,task_name,task_info,task_yt_link,task_quiz_ques,task_ait_oldugu_ders)){
                    Helper.showMsg("done");
                }
                loadEduTaskModel();
            }
        });
        //**EduTaskList

        btn_user_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_user_name.getText();
                String uname = fld_user_uname.getText();
                String pass = fld_user_pass.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if (User.add(name, uname, pass, type)) {
                    Helper.showMsg("done");
                    loadUserModel();
                    loadEducatorCombo();
                    fld_user_name.setText(null);
                    fld_user_uname.setText(null);
                    fld_user_pass.setText(null);
                }
            }
        });

        btn_user_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int user_id = Integer.parseInt(fld_user_id.getText());
                    if (User.delete(user_id)) {
                        Helper.showMsg("done");
                        loadUserModel();
                        loadEducatorCombo();
                        loadCourseModel();
                        fld_user_id.setText(null);
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });

        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_user_name.getText();
            String uname = fld_sh_user_uname.getText();
            String type = cmb_sh_user_type.getSelectedItem().toString();
            String query = User.searchQuery(name, uname, type);

            ArrayList<User> searchingUser = User.searchUserList(query);
            loadUserModel(searchingUser);
        });

        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_patika_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_patika_name.getText();
                if (Patika.add(name)) {
                    Helper.showMsg("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadEducatorCombo();
                    fld_patika_name.setText(null);
                } else {
                    Helper.showMsg("Bu dersin aynısı daha önceden eklenmiş. Lütfen farklı bir ders adı giriniz.");
                    fld_patika_name.setText(null);
                }
            }
        });
        btn_course_add.addActionListener(e -> {
            Item patikaItem=(Item)cmb_course_patika.getSelectedItem();
            Item userItem=(Item) cmb_course_user.getSelectedItem();
            if (Helper.isFieldEmpty(fld_course_name)||Helper.isFieldEmpty(fld_course_lang)){
                Helper.showMsg("fill");
            }else {
                if (Course.add(userItem.getKey(),patikaItem.getKey(),fld_course_name.getText(),fld_course_lang.getText())){
                    Helper.showMsg("done");
                    loadCourseModel();
                    fld_course_lang.setText(null);
                    fld_course_name.setText(null);
                }else {
                    Helper.showMsg("error");
                    fld_course_name.setText(null);
                    fld_course_lang.setText(null);
                }
            }
        });
        btn_course_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_course_id)){
                Helper.showMsg("fill");
            }else {
                if (Helper.confirm("sure")){
                    int course_id = Integer.parseInt(fld_course_id.getText());
                    if (Course.delete(course_id)){
                        Helper.showMsg("done");
                        loadCourseModel();
                        fld_user_id.setText(null);
                    }else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Patika obj : Patika.getList()) {
            i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for (User obj : User.getList()) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }

    public void loadUserModel(ArrayList<User> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for (User obj : list) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }

    public void loadPatikaCombo() {
        cmb_course_patika.removeAllItems();
        for (Patika obj: Patika.getList()){
            cmb_course_patika.addItem(new Item(obj.getId(), obj.getName()));
        }
    }
    private void loadEducatorCombo() {
        cmb_course_user.removeAllItems();
        for (User obj: User.getList()){
            if (obj.getType().equals("educator")){
                cmb_course_user.addItem(new Item(obj.getId(), obj.getName()));
            }
        }

    }
    public void loadEduTaskModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_eduTask_list.getModel();
        clearModel.setRowCount(0);
        for (EducatorTasks obj : EducatorTasks.getList()) {
            int i = 0;
            row_eduTasks_list[i++] = obj.getId();
            row_eduTasks_list[i++] = obj.getName();
            row_eduTasks_list[i++] = obj.getInfo();
            row_eduTasks_list[i++] = obj.getYt_link();
            row_eduTasks_list[i++] = obj.getQuiz_ques();
            row_eduTasks_list[i++] = obj.getAit_oldugu_ders();
            mdl_edu_tasks_list.addRow(row_eduTasks_list);
        }
    }
}
