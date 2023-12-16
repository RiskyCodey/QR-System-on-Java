package idproject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author candi
 */
public class StudentTableDisplay extends javax.swing.JFrame {


    public final JTable table;
    public StudentTableDisplay(List<Student> students) {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        // Create a table model to hold the data
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        // Add columns to the table
        model.addColumn("ID Number");
        model.addColumn("Last Name");
        model.addColumn("First Name");
        model.addColumn("Year Level");
        model.addColumn("Course");

        // Populate the table with data from the student list
        for (Student student : students) {
            model.addRow(new Object[]{
                    student.getIdNumber(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getYearLevel(),
                    student.getCourse()
            });
        }
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setDefaultEditor(table.getColumnClass(i), null);
        }
         
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);
    }
}