 package packageAPPS;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 class Student {
    private String name;
    private boolean present;
    public Student(String name) {
        this.name = name;
        this.present = false;
    }
    public String getName() {
        return name;
    }
    public boolean isPresent() {
        return present;
    }
    public void markPresent() {
        this.present = true;
    }
    public void markAbsent() {
        this.present = false;
    }
 }
 public class packageAPPS extends JFrame {
    private List<Student> students;
    private Map<Student, JCheckBox> attendanceMap;
    public AttendanceManagementSystem() {
        setTitle("Attendance Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        students = new ArrayList<>();
        students.add(new Student("Student1"));
        students.add(new Student("Student2"));
        students.add(new Student("Student3"));
        students.add(new Student("Student4"));
        students.add(new Student("Student5"));
        students.add(new Student("Student6"));
        students.add(new Student("Student7"));
        students.add(new Student("Student8"));
        students.add(new Student("Student9"));
        students.add(new Student("Student10"));
        attendanceMap = new HashMap<>();
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(students.size() + 1, 2));
        JLabel titleLabel = new JLabel("Attendance Management System");
        panel.add(titleLabel);
        panel.add(new JLabel()); // Empty cell
        for (Student student : students) {
            JCheckBox checkBox = new JCheckBox(student.getName());
            attendanceMap.put(student, checkBox);
            panel.add(checkBox);
            panel.add(new JLabel()); // Empty cell
        }
        JButton submitButton = new JButton("Submit Attendance");
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAttendance();
            }
        });
    }
    private void submitAttendance() {
        StringBuilder attendanceResult = new StringBuilder("Attendance:\n");
        for (Map.Entry<Student, JCheckBox> entry : attendanceMap.entrySet()) {
            Student student = entry.getKey();
            JCheckBox checkBox = entry.getValue();
            if (checkBox.isSelected()) {
                student.markPresent();
                attendanceResult.append(student.getName()).append(": Present\n");
            } else {
                student.markAbsent();
                attendanceResult.append(student.getName()).append(": Absent\n");
            }
        }
        JOptionPane.showMessageDialog(this, attendanceResult.toString());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AttendanceManagementSystem();
            }
 });
 }
 }

 