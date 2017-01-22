package application;
	
public class carte {
	private String nom;
	public String effet;
	
	public carte(String nom, String effet)
	{
		this.nom= nom;
		this.effet=effet;
	}
	
	public String getEffet(){
		return (this.effet);
	}
	
	public String getNom(){
		return(this.nom);
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setEffet(String effet){
		this.effet = effet;
	}
}
