package Listeners;

import BeatBox.BeatBoxPlayer;

import javax.sound.midi.Sequencer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownTempoListener implements ActionListener {
    private BeatBoxPlayer player;

    public DownTempoListener(BeatBoxPlayer player) {
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sequencer sequencer = player.getSequencer();
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float) (tempoFactor*1.03));
    }
}
