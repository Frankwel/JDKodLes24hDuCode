package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JasonRecherche {
	private static String contenu;
	private static String nom;
	private static float latitude;
	private static float longitude;
	private static ArrayList<Magasin> listeMagasin = new ArrayList<Magasin>();
	
	private static Magasin magasin;
	
	
	public JasonRecherche(String type, int nombre) throws ClientProtocolException, IOException, URISyntaxException{
		analyse(type, nombre);
	}
	
	
	private static void analyse(String type, int nombre) throws ClientProtocolException, IOException, URISyntaxException {
		
		URI uri = new URI("https://api.apipagesjaunes.fr/pros/find?what="+type+"&where=le_mans&app_id=d140a6f6&app_key=26452728b034374bccb462e880bfb0e5&return_urls=true");
		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpUriRequest request = new HttpGet(uri);
	    HttpResponse response = client.execute(request);
	    
	    System.out.println("\n *****Liste des " + type + " sur Le Mans: ");
                
	   
	    contenu = EntityUtils.toString(response.getEntity());
	    
	    JSONObject obj;
	    	
	    	obj = (JSONObject) JSONValue.parse(contenu);
	    	contenu = obj.get("search_results").toString();
	    	
	    	String[] parts = new String[2]; 
	    	for(int i=0; i<nombre; i++){
	    		parts = contenu.split("merchant_name\":\"", 2);
		    	contenu = parts[1];
		    	
		    	parts = contenu.split("\",", 2);
		    	nom = parts[0];
		    	System.out.println("nom: " + nom);
		    	contenu = parts[1];
		    	
		    	parts = contenu.split("latitude\":", 2);
		    	contenu = parts[1];
		    	
		    	parts = contenu.split(",", 2);
		    	latitude = Float.parseFloat(parts[0]);
		    	System.out.println("latitude: "+ latitude);
		    	contenu = parts[1];
		    	
		    	parts = contenu.split("longitude\":", 2);
		    	contenu = parts[1];
		    	
		    	parts = contenu.split("}", 2);
		    	longitude = Float.parseFloat(parts[0]);
		    	System.out.println("longitude: " + longitude);
		    	contenu = parts[1];
		    	
		    	magasin = new Magasin(nom, latitude, longitude);
		    	listeMagasin.add(magasin);
	    	}
	    	
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
		analyse("hôtel", 5);
	}
}