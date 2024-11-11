import Person.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame {
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        taPersons.setEnabled(false);
        tfName.setEnabled(false);
        tfAge.setEnabled(false);
        tfMonths.setEnabled(false);
        tfSalary.setEnabled(false);


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String type = "";
                    if (!(rbManager.isSelected() || rbCustomer.isSelected() || rbClerk.isSelected())) {
                        JOptionPane.showMessageDialog(null, "Select an option");
                    }
                    if (rbManager.isSelected()) {
                        if (tfName.getText().equals("") || tfAge.getText().equals("") || tfMonths.getText().equals("") || tfSalary.getText().equals("")) throw new IllegalArgumentException();
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int months_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if (age <= 0 || months_worked < 0 || salary <= 0) throw new NumberFormatException();
                        persons.add(new Manager(name, age, months_worked, salary));
                        type = "Manager";

                    }
                    if (rbClerk.isSelected()) {
                        if (tfName.getText().equals("") || tfAge.getText().equals("") || tfMonths.getText().equals("") || tfSalary.getText().equals("")) throw new IllegalArgumentException();
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        int months_worked = Integer.parseInt(tfMonths.getText());
                        double salary = Double.parseDouble(tfSalary.getText());
                        if (age <= 0 || months_worked < 0 || salary <= 0) throw new NumberFormatException();
                        persons.add(new Clerk(name, age, months_worked, salary));
                        type = "Clerk";
                    }
                    if (rbCustomer.isSelected()) {
                        if (tfName.getText().equals("") || tfAge.getText().equals("")) throw new IllegalArgumentException();
                        String name = tfName.getText();
                        int age = Integer.parseInt(tfAge.getText());
                        if (age <= 0) throw new NumberFormatException();
                        persons.add(new Customer(name, age));
                        type = "Customer";
                    }

                    taPersons.append(persons.size() + ". " + type + " - " + tfName.getText() + "(" + Integer.parseInt(tfAge.getText()) + ")\n");
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Input a non-negative number");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Input all required text fields");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error has occurred");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
            }
        });

        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //taPersons.setText("");
                for(Person p : persons) {
                    //taPersons.append(p + "\n");
                    System.out.println(p); // perform the toString method of each person in the list print it in the console

                }
            }
        });

        rbCustomer.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(rbCustomer.isSelected()) {
                    tfName.setEnabled(true);
                    tfAge.setEnabled(true);
                    tfMonths.setEnabled(false);
                    tfSalary.setEnabled(false);
                } else {
                    tfName.setEnabled(true);
                    tfAge.setEnabled(true);
                    tfMonths.setEnabled(true);
                    tfSalary.setEnabled(true);
                }
            }
        });

        btnSavePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLoadPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int reward = Integer.parseInt(tfLoad.getText());
                    if(reward < 0) throw new NumberFormatException();
                    Person p = persons.get(reward);
                    if (p instanceof Employee) {
                        String msg = "";
                        if (p instanceof Manager) msg += "Manager ";
                        else msg += "Clerk ";
                        msg += p.getName() + " Thirteenth month pay is " + ((Employee) p).thirteenth_month();
                        JOptionPane.showMessageDialog(null, msg);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input reward value");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Selected index is not an employee.");
                }
            }
        });
    }


    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(600, 600);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    static void giveReward(int n) {

    }
}
