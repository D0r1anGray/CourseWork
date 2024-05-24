package org.coursework.window;
import org.coursework.database.ConnectionToDatabase;
import org.coursework.database.CreateCopyOfDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ThirdWindow extends JFrame {
    ConnectionToDatabase connection;
    public ThirdWindow(ConnectionToDatabase connection) {
        this.connection = connection;
        initUI();
    }

    private void initUI() {

        final String[] file_path = new String[1];

        setTitle("создание логической копии");
        setSize(400, 200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JButton chooseFolderButton = new JButton("Выберите папку");
        chooseFolderButton.addActionListener(new ActionListener() {
            public String path;

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Folder Destination");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showDialog(null, "Select");
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file_path[0] = fileChooser.getSelectedFile().getPath();
                }
                else{
                    showMessageDialog(null, "The directory is not selected");
                }
            }
        });
        topPanel.add(chooseFolderButton);

        JLabel dbNameLabel = new JLabel("Введите имя копии БД:");
        topPanel.add(dbNameLabel);

        JTextField dbNameField = new JTextField(15);
        topPanel.add(dbNameField);

        panel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton createCopyButton = new JButton("Сделать копию");
        createCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str_dbNameField = dbNameField.getText();
                String path = file_path[0];
                CreateCopyOfDatabase createCopyOfDatabase = new CreateCopyOfDatabase(connection, str_dbNameField, path);
                showMessageDialog(null, "Successfully copied");
            }
        });
        centerPanel.add(createCopyButton, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);
    }

}
