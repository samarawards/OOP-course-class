package BiodataForm;

import javax.swing.*;
import java.awt.*;

public class BiodataForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Biodata Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel header = new JPanel(new FlowLayout());
        header.add(new JLabel("Student Biodata"));

        JPanel form = new JPanel(new GridLayout(4, 2));

        // Text Fields
        JTextField txtFirstName = new JTextField();
        JTextField txtLastName = new JTextField();
        JTextField txtBirthDate = new JTextField();
        JTextField txtGender = new JTextField();

        form.add(new JLabel("First Name: "));
        form.add(txtFirstName);

        form.add(new JLabel("Last Name: "));
        form.add(txtLastName);

        form.add(new JLabel("Birth Date: "));
        form.add(txtBirthDate);

        form.add(new JLabel("Gender: "));
        form.add(txtGender);

        JPanel button = new JPanel(new FlowLayout());

        JButton btnSubmit = new JButton("Submit");
        JButton btnExit = new JButton("Exit");

        button.add(btnSubmit);
        button.add(btnExit);

        // EVENT HANDLER
        btnSubmit.addActionListener(e -> {

            String firstName = txtFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String birthDate = txtBirthDate.getText().trim();
            String gender = txtGender.getText().trim();

            if (firstName.isEmpty() ||
                lastName.isEmpty() ||
                birthDate.isEmpty() ||
                gender.isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Semua field harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "First Name: " + firstName
                    + "\nLast Name: " + lastName
                    + "\nBirth Date: " + birthDate
                    + "\nGender: " + gender,
                    "Data Terkirim",
                    JOptionPane.INFORMATION_MESSAGE
                );

                txtFirstName.setText("");
                txtLastName.setText("");
                txtBirthDate.setText("");
                txtGender.setText("");
            }
        });

        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure want to exit?",
                "Exit Verification",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.OK_OPTION) {
                System.exit(0);
            }

        });

        // SET LAYOUT
        frame.setLayout(new GridLayout(3, 1));

        // ADD PANELS TO FRAME
        frame.add(header);
        frame.add(form);
        frame.add(button);

        // DISPLAY FRAME
        frame.setVisible(true);
        
    }
}
