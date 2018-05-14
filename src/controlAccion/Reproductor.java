package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.SwingWorker;

import javazoom.jl.player.Player;

public class Reproductor implements ActionListener{
	private boolean sonando = false;
	private SwingWorker worker;
	private Player reproductor;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!sonando) {
			worker=  new SwingWorker<Object, Object>(){
				@Override
				protected Object doInBackground() throws Exception {
					reproducirAudio("audios/TheHobbit.mp3");
					return null;
				}
			};	
			worker.execute();
			sonando = true;
		}
		else {
			reproductor.close();
			sonando = false;
		}
	}
	private void reproducirAudio(String ruta) {
		try {
			reproductor = new Player(new FileInputStream(String.valueOf(ruta)));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
	}
}
