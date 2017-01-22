package application;

public class Magasin {
	
	String nom;
	float latitude;
	float longitude;
	
	public Magasin(String name, float lat, float lon){
		this.nom = name;
		this.latitude = lat;
		this.longitude = lon;
	}
	
	public Magasin(){
		
	}
	
	public String getNom(){
		return(this.nom);
	}
	
	public float getLatitude(){
		return(this.latitude);
	}
	
	public float getLongitude(){
		return(this.longitude);
	}
	
	public void setNom(String name){
		this.nom = name;
	}
	
	public void setLatitude(float lat){
		this.latitude = lat;
	}
	
	public void setLongitude(float lon){
		this.longitude = lon;
	}

}
