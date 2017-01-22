package application;

public class joueur {
	public String nomJoueur = new String();
	public carte[] tabCartes;
	public int distanceParcourue = 0;
	
	public joueur(String nom, carte tab[])
	{
		nomJoueur=nom;
		tabCartes = new carte[4];
	}
}
