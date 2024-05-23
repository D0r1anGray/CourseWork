package org.coursework.window;
import org.coursework.database.ConnectionToDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Visual1 extends JFrame{
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private ConnectionToDatabase connection;

    private SecondWindow secondWindow;

    public Visual1() {
        initUI();
    }

    private void initUI() {
        setTitle("Подключение к базе данных");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Введите url базы данных:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        field1 = new JTextField(20);
        panel.add(field1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Введите имя пользователя:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        field2 = new JTextField(20);
        panel.add(field2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Введите пароль:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        field3 = new JTextField(20);
        panel.add(field3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton openButton = new JButton("Подключиться");
        panel.add(openButton, gbc);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strfield1 = field1.getText();
                String strfield2 = field2.getText();
                String strfield3 = field3.getText();
                connection = new ConnectionToDatabase(strfield1, strfield2, strfield3);
                if(secondWindow == null){
                    secondWindow = new SecondWindow(connection);
                }
                secondWindow.setVisible(true);

            }
        });

        add(panel);
    }

}
