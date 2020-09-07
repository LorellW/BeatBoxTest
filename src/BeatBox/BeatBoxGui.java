package BeatBox;

import Listeners.*;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeatBoxGui {
    private JPanel mainPanel;
    private ArrayList<JCheckBox> checkBoxList;
    private JFrame theFrame;
    private String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};

    public void buildGui(){
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);


        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        BeatBoxPlayer player = new BeatBoxPlayer(checkBoxList);
        JButton start = new JButton("Start");
        start.addActionListener(new StartListener(player));
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new StopListener(player));
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new UpTempoListener(player));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new DownTempoListener(player));
        buttonBox.add(downTempo);

        JButton selectAll = new JButton("Select All");
        selectAll.addActionListener(new SelectAllListener(checkBoxList));
        buttonBox.add(selectAll);

        JButton clear = new JButton("Clear All");
        clear.addActionListener(new ClearListener(checkBoxList));
        buttonBox.add(clear);

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

}

