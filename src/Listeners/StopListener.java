package Listeners;

import BeatBox.BeatBoxPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopListener implements ActionListener {
    private BeatBoxPlayer player;

    public StopListener(BeatBoxPlayer player) {
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.getSequencer().stop();
    }
}
