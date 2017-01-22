package application;


import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/** Controls the login screen */
public class Controller implements Initializable {
  
	@FXML
  private TextField user;
  
	@FXML
  private TextField password;
  
	@FXML
  private Button loginButton;
  
	@FXML
  private Button nouvellePartie;
	
	@FXML
  private Button regleDuJeu;
  
	@FXML
  private WebView webview;
	
	@FXML
	private ImageView carte1;
	
	@FXML
	private ImageView carte2;
	
	@FXML
	private ImageView carte3;
	
	@FXML
	private ImageView carte4;
	
	@FXML
	private Label descript1;
	
	@FXML
	private Label descript2;
	 
	@FXML
	private Label descript3;
	
	@FXML
	private Label descript4;
	
	@FXML
	private Button changer;
	@FXML
	private Button changer1;
	@FXML
	private Button changer2;
	@FXML
	private Button changer3;
	@FXML
	private Button changer4;
	
	
	
	int newGame = 0;
	int autreCarte = 0;
	Image image;
	String nomImage;
	carte[] tableCartes = {new carte("accident", "provoque accident"), new carte("borne25", "parcourir 25 mètres"), new carte("borne50", "parcourir 50 mètres"), new carte("borne75", "parcourir 75 mètres"),
			new carte("borne100", "parcourir 100 mètres"), new carte("creveson", "provoquer creveson"), new carte("essence", "rempli le reservoire"), new carte("feu vert", "vous pourvez avancer au prochain tour"),
			new carte("feu rouge", "arrêt, désactivable par feu vert"), new carte("panne d'essence", "vider le reservoir"), new carte("roue de secours", "répare crevéson")};
  
  
  @FXML
  private void handleButtonAction(ActionEvent event){
	  carte[] cartePlayer = new carte[4];
	  if(((Button)event.getSource()) == nouvellePartie){
		  if(newGame == 1){
			  Alert alert = new Alert(AlertType.CONFIRMATION);
			  alert.setTitle("Nouvelle partie ");
			  alert.setHeaderText("Cette action va annuler la partie en cours");
			  alert.setContentText("Souhaitez-vous continuer");

			  ButtonType buttonTypeOui = new ButtonType("Oui");
			  ButtonType buttonTypeNon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

			  alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeNon);

			  Optional<ButtonType> result = alert.showAndWait();
			  if (result.get() == buttonTypeOui){
				  for(int i=0; i<4; i++){
					  cartePlayer[i]= tableCartes[(int) (0 + Math.random()*10)];
					  
				  }
				  for(int i=0; i<4; i++){
					  cartePlayer[i]= tableCartes[(int) (0 + Math.random()*10)];  
				  }
				  image = new Image("/application/image/"+cartePlayer[0].getNom()+".png");
				  carte1.setImage(image);
				  descript1.setText(cartePlayer[0].getNom());
				  image = new Image("/application/image/"+cartePlayer[1].getNom()+".png");
				  carte2.setImage(image);
				  descript2.setText(cartePlayer[1].getNom());
				  image = new Image("/application/image/"+cartePlayer[2].getNom()+".png");
				  carte3.setImage(image);
				  descript3.setText(cartePlayer[2].getNom());
				  image = new Image("/application/image/"+cartePlayer[3].getNom()+".png");
				  carte4.setImage(image);
				  descript4.setText(cartePlayer[3].getNom());
				  
				  joueur player = new joueur("joueur 1", cartePlayer);
				  webview.getEngine().load("file:///C:/Users/Frankwel/Desktop/Nouveau/JDKOD24h/src/application/Start.html");
			  } 
		  }
		  else{
			  for(int i=0; i<4; i++){
				  cartePlayer[i]= tableCartes[(int) (0 + Math.random()*10)];
				  
			  }
			  for(int i=0; i<4; i++){
				  cartePlayer[i]= tableCartes[(int) (0 + Math.random()*10)];  
			  }
			  image = new Image("/application/image/"+cartePlayer[0].getNom()+".png");
			  carte1.setImage(image);
			  descript1.setText(cartePlayer[0].getNom());
			  image = new Image("/application/image/"+cartePlayer[1].getNom()+".png");
			  carte2.setImage(image);
			  descript2.setText(cartePlayer[1].getNom());
			  image = new Image("/application/image/"+cartePlayer[2].getNom()+".png");
			  carte3.setImage(image);
			  descript3.setText(cartePlayer[2].getNom());
			  image = new Image("/application/image/"+cartePlayer[3].getNom()+".png");
			  carte4.setImage(image);
			  descript4.setText(cartePlayer[3].getNom());
			  
			  joueur player = new joueur("joueur 1", cartePlayer);
			  webview.getEngine().load("file:///C:/Users/Frankwel/Desktop/Nouveau/JDKOD24h/src/application/Start.html");
			  newGame = 1;
		  }

	  }
	  else if(((Button)event.getSource()) == changer1){
		  autreCarte=1;
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte1.setImage(image);
	  }
	  else if(((Button)event.getSource()) == changer2){
		  autreCarte=1;
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte2.setImage(image);
	  }
	  else if(((Button)event.getSource()) == changer3){
		  autreCarte=1;
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte3.setImage(image);
	  }
	  else if(((Button)event.getSource()) == changer4){
		  autreCarte=1;
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte4.setImage(image);
	  }
	  else if(((Button)event.getSource()) == regleDuJeu){
		  //Web w=new WebEngine();
		  
		 webview.getEngine().load("file:///C:/Users/Frankwel/Desktop/Nouveau/JDKOD24h/src/ressource/mille-bornes-express-regles-du-jeu");
	  }
	  else if((ImageView)event.getSource() == carte1){
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte1.setImage(image);
	  }
	  else if(((ImageView)event.getSource()) == carte2){
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte2.setImage(image);
	  }
	  else if(((ImageView)event.getSource()) == carte3){
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte3.setImage(image);
	  }
	  else if(((ImageView)event.getSource()) == carte4){
		  image = new Image("/application/image/"+(tableCartes[(int) (0 + Math.random()*10)]).getNom()+".png");
		  carte4.setImage(image);
	  }
	  
	  
  }
	 
  

public void initialize(URL location, ResourceBundle resources) {
	
}
  
 
}