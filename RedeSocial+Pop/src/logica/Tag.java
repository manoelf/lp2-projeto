package logica;

public class Tag implements Comparable<Tag> {
	
	private int frequencia;
	private String hashtag; 
	
	public Tag(String hashtag) {
		this.hashtag = hashtag;
		this.frequencia = 1;
	}
	
	public String getHashtag() {
		return this.hashtag;
	}
	
	public int getFrequencia() {
		return this.frequencia;
	}

	public void addFrequencia() {
		//System.out.print("\n"+ this.hashtag+ " ::: Add freq :"+ this.frequencia+ "|| nova freq ");
		this.frequencia += 1;
		//System.out.println(this.frequencia);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tag)) {
			return false;
		} else {	
			Tag other = (Tag) obj;
			if (hashtag.equals(other.getHashtag())) {
				return true;
			} else {
				return false;
			}
		}

	}

	public int compareTo(Tag outraTag) {
		
		if (this.frequencia > outraTag.getFrequencia()) {
			return -1;
		} else if (this.frequencia == outraTag.getFrequencia()) {
			return this.hashtag.compareTo(outraTag.getHashtag()) * -1;
		} else { //this.frequencia < outraTag.getFrequencia()
			return 1;
		}		
	}
	
	public String toString() {
		return this.hashtag+ ": "+ this.frequencia+ ";";
	}
}