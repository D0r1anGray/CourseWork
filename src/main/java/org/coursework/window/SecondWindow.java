package org.coursework.window;
import org.coursework.database.ConnectionToDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondWindow extends JFrame {
    ThirdWindow thirdWindow;
    FourthWindow fourthWindow;
    ConnectionToDatabase connection;
    public SecondWindow(ConnectionToDatabase connection) {
        this.connection = connection;
        initUI();
    }

    private void initUI() {
        setTitle("Выбор действия");
        setSize(600, 200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton createDbButton = new JButton("Создать логическую копию БД");
        createDbButton.setPreferredSize(new Dimension(250, 20));
        panel.add(createDbButton, gbc);
        createDbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(thirdWindow == null){
                    thirdWindow = new ThirdWindow(connection);
                }
                thirdWindow.setVisible(true);
            }
        });
        panel.add(createDbButton);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton createJtButton = new JButton("Создать физическую копию БД (журнал транзакций)");
        createJtButton.setPreferredSize(new Dimension(400, 20));
        createJtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fourthWindow == null){
                    fourthWindow = new FourthWindow(connection);
                }
                fourthWindow.setVisible(true);
            }
        });
        panel.add(createJtButton);

        add(panel);
    }
}
