package ru.gb.less8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeekBrainsWindow extends JFrame {
    private int randomNumber;
    private JTextField textField;
    private int i = 2;
    public GeekBrainsWindow() {
        this.randomNumber = (int) (Math.random() * 10) + 1;

        setTitle("Игра: Угадай число");
        setBounds(600, 300, 800, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        textField.setText("Программа загадала число от 1 до 10");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);


        Font font = new Font("Arial", Font.PLAIN, 20);
        textField.setFont(font);

        JButton restart = new JButton("Перезапуск игры");
        add(restart, BorderLayout.EAST);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
        buttonsPanel.setBackground(Color.BLUE);
        add(buttonsPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);
            int buttonIndex = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryToAnswer(buttonIndex);
                }
            });
        }

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GeekBrainsWindow();
            }
        });

        setVisible(true);
    }

    public void tryToAnswer(int answer) {

        while (i > 0){
            if (answer < randomNumber) {
                textField.setText("Не угадали! Загаданное число больше! Попыток = " + i);
                i--;
                return;
            }
            if (answer > randomNumber) {
                textField.setText("Не угадали! Загаданное число меньше Попыток = " + i);
                i--;
                return;
            }
            textField.setText("Вы угадали!!! Ответ: " + randomNumber);
            }
        if (i == 0){
            textField.setText("Вы проиграли!!!");
        }
        }
}
