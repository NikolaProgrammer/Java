package by.gsu.pms.model.beans;

public class Byn implements Comparable<Byn> {
	private int amount;

	public Byn(int amount) {
		this.amount = amount;
	}

	public Byn(int rubles, int kopecks) {
		this((rubles * 100) + kopecks);
	}

	public Byn(Byn byn) {
		this(byn.amount);
	}

	public Byn addition(Byn byn) {
		amount += byn.amount;
		return this;
	}

	public Byn subtraction(Byn byn) {
		amount -= byn.amount;
		return this;
	}

	public Byn multiply(int k) {
		amount *= k;
		return this;
	}

	public int getRubs() {
		return amount / 100;
	}

	public int getKopecks() {
		return amount % 100;
	}

	@Override
	public int compareTo(Byn otherByn) {
		return amount - otherByn.amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Byn other = (Byn) obj;
		if (amount != other.amount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return amount/ 100 + "." + amount / 10 % 10 + amount % 10;
	}

}