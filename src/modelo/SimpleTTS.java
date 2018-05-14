package modelo;

import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.NullAudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import javax.sound.sampled.AudioSystem;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SimpleTTS {
	Voice voice = null;

	public SimpleTTS(String voiceName) throws Exception {
		VoiceManager voiceManager = VoiceManager.getInstance();
		this.voice = voiceManager.getVoice(voiceName);
		if (this.voice == null) {
			System.out.println("La lista de voces disponibles es:");
			listAllVoices();
			throw new Exception(
					"No se encuentra la voz llamada: " + voiceName + ". Por favor selecciona una voz diferente.");
		}
		this.voice.allocate();
	}

	// ----
	public void speak(String text) throws Exception {
		this.voice.speak(text);
	}

	// ----
	public void toFile(String filename, String text) throws Exception {
		javax.sound.sampled.AudioFileFormat.Type type = getAudioType(filename);
		AudioPlayer audioPlayer = null;
		if (audioPlayer == null)
			audioPlayer = new NullAudioPlayer();
		audioPlayer = new SingleFileAudioPlayer(getBasename(filename), type);
		System.out.println("audioPlayer " + audioPlayer);
		this.voice.setAudioPlayer(audioPlayer);
		this.voice.speak(text);
		audioPlayer.close();
	}

	// ----
	public void close() throws Exception {
		this.voice.deallocate();
	}

	// ----
	public static void listAllVoices() {
		System.out.println();
		System.out.println("All voices available:");
		VoiceManager voiceManager = VoiceManager.getInstance();
		System.out.println("voiceManager:" + voiceManager);
		Voice[] voices = voiceManager.getVoices();
		for (int i = 0; i < voices.length; i++) {
			System.out.println(" " + voices[i].getName() + " (" + voices[i].getDomain() + " domain)");
		}
	}

	// ----
	public static javax.sound.sampled.AudioFileFormat.Type getAudioType(String file) {
		javax.sound.sampled.AudioFileFormat.Type types[] = AudioSystem.getAudioFileTypes();
		String extension = getExtension(file);
		for (int i = 0; i < types.length; i++)
			if (types[i].getExtension().equals(extension))
				return types[i];
		return null;
	}

	// ----
	public static String getExtension(String path) {
		int index = path.lastIndexOf(".");
		if (index == -1)
			return null;
		else
			return path.substring(index + 1);
	}

	// ----
	public static String getBasename(String path) {
		int index = path.lastIndexOf(".");
		if (index == -1)
			return path;
		else
			return path.substring(0, index);
	}

	// ----
	static public void main(String[] args) throws Exception {
		try {
			// Instanciamos para usar la voz "kevin16"
			SimpleTTS voz = new SimpleTTS("kevin16");
			// Reproduce por el altavoz
			// while (true)
			// {
			voz.speak("auan babuluba balan bambu");
			voz.speak("Hello World!");
			// }
			voz.speak("Text to Speech demo");
			// Graba un fichero de audio con el contenido en el directorio
			voz.toFile("ttsdemo.wav", "Ubuntu Life is the best site of Linux");
			// Podriamos reproducir este fichero desde consola: $ mplayer ttsdemo.wav
			// Cerramos
			voz.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ----
}