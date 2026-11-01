package A24;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIskeleton extends JFrame implements ActionListener {
    private ArrayList<File> imageFiles;

    public GUIskeleton(ArrayList<File> imageFiles) {
        this.imageFiles = imageFiles;
        setTitle("252-2022: A4");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 4));

        for (File imgFile : imageFiles) {
            JButton btext = new JButton(imgFile.getName());
            btext.addActionListener(this);
            add(btext);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object so = e.getSource();
        if (so instanceof JButton) {
            JButton sj = (JButton) so;
            String fileName = sj.getText();
            for (File f : imageFiles) {
                if (f.getName().equals(fileName)) {
                    try {
                        Desktop dt = Desktop.getDesktop();
                        dt.open(f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}