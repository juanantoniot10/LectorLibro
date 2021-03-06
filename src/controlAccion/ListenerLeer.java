package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.SwingWorker;

import controlLogica.Logica;
import javazoom.jl.player.Player;
import modelo.SimpleTTS;
import vita.PanelLectura;

public class ListenerLeer implements ActionListener{

	private boolean sonando = false;
	private SwingWorker worker;
	private PanelLectura panelLectura;
	private SimpleTTS voz;
	public ListenerLeer(PanelLectura panelLectura) {
		this.panelLectura = panelLectura;
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!sonando) {
				worker=  new SwingWorker<Object, Object>(){
					

					@Override
					protected Object doInBackground() throws Exception {
						voz = new SimpleTTS("kevin");
						voz.speak("aun es toi por me ho rar. por que jo ha blo mu e ra ro. pe ro te vo e ale er el pho tou li bro."+panelLectura.getTextPaneLeft().getText()+panelLectura.getTextPaneDer().getText());
						return null;
					}
				};	
				worker.execute();
				sonando = true;
			} else {
				try {
					voz.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sonando=false;
			}
				
		}
}
