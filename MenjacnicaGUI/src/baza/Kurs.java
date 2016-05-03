package baza;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Kurs {

	private LinkedList<Valuta> valute = new LinkedList<Valuta>();

	public void dodajValutu(Valuta valuta) {
		valute.add(valuta);
	}

	public void obrisiValutu(Valuta valuta) {
		if (valute.contains(valuta))
			valute.remove(valuta);
	}

	public LinkedList<Valuta> vratiSveValute() {
		return valute;
	}

	public String vratiPoslednjegString() {
		if (!valute.isEmpty()) {
			return valute.getLast().toString();
		} else {
			return "";
		}
	}

	public void sacuvajUFajl(String putanja) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(valute);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")

	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Valuta> valute2 = (LinkedList<Valuta>) (in.readObject());
			valute.clear();
			valute.addAll(valute2);

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
