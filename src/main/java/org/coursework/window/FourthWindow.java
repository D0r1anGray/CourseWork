package org.coursework.window;
import org.coursework.database.ConnectionToDatabase;
import org.coursework.database.CreateCopyOfDatabase;
import org.coursework.transaction_journal.CreateCopyOfJournal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class FourthWindow extends JFrame {
    ConnectionToDatabase connection;
    public FourthWindow(ConnectionToDatabase connection) {
        this.connection = connection;
        initUI();
    }
    private void initUI() {
        final String[] file_path = new String[1];

        setTitle("создание копии ЖТ");
        setSize(400, 200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JLabel dbNameLabel = new JLabel("Введите имя БД:");
        topPanel.add(dbNameLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton chooseFolderButton = new JButton("Выберите папку");
        chooseFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Folder Destination");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showDialog(null, "Select");
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file_path[0] = fileChooser.getSelectedFile().getAbsolutePath();
                }
                else{
                    showMessageDialog(null, "The directory is not selected");
                }

            }
        });
        centerPanel.add(chooseFolderButton, gbc);

        gbc.gridx = 1;
        JButton createCopyButton = new JButton("Сделать копию");
        createCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = file_path[0];
                CreateCopyOfJournal createCopyOfJournal = new CreateCopyOfJournal(connection, path);
                showMessageDialog(null, "Successfully copied!");
            }
        });
        centerPanel.add(createCopyButton, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);
    }
}
