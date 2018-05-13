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
		else worker.cancel(true);
		//No consigo cerrar el worker :/
	}
	private void reproducirAudio(String ruta) {
		try {
			Player reproductor = new Player(new FileInputStream(String.valueOf(ruta)));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
	}
}
