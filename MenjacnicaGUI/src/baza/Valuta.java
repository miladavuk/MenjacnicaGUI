package baza;

import java.io.Serializable;
import java.util.LinkedList;

public class Valuta implements Serializable {

	private static final long serialVersionUID = 35L;
	private int sifra;
	private String skraceniNaziv;
	private double prodajni;
	private double srednji;
	private double kupovni;
	private String naziv;

	public int getSifra() {
		return sifra;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getProdajni() {
		return prodajni;
	}

	public double getSrednji() {
		return srednji;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kupovni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		temp = Double.doubleToLongBits(prodajni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sifra;
		result = prime * result + ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		temp = Double.doubleToLongBits(srednji);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Valuta))
			return false;
		Valuta other = (Valuta) obj;
		if (Double.doubleToLongBits(kupovni) != Double.doubleToLongBits(other.kupovni))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (Double.doubleToLongBits(prodajni) != Double.doubleToLongBits(other.prodajni))
			return false;
		if (sifra != other.sifra)
			return false;
		if (skraceniNaziv == null) {
			if (other.skraceniNaziv != null)
				return false;
		} else if (!skraceniNaziv.equals(other.skraceniNaziv))
			return false;
		if (Double.doubleToLongBits(srednji) != Double.doubleToLongBits(other.srednji))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Šifra: " + sifra + ", skraćeni naziv: " + skraceniNaziv + ", prodajni kurs: " + prodajni
				+ ", kupovni kurs:  " + kupovni + ", srednji kurs: " + srednji + ", naziv: " + naziv + ".\n";
	}

}
