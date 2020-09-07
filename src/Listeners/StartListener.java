package Listeners;

import BeatBox.BeatBoxPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener {
    private BeatBoxPlayer player;

    public StartListener(BeatBoxPlayer player) {
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.buildTrackAndStart();
    }
}
