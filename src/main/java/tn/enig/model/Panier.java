package tn.enig.model;

public class Panier {
	
	private Produit p;
	private int qte;
	
	public Panier(Produit p, int qte) {
		super();
		this.p = p;
		this.qte = qte;
	}
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit getP() {
		return p;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	

}
