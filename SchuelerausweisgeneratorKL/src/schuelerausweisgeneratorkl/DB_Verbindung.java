/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jonas.linde
 */
public class DB_Verbindung {
    Connection datenbankverbindung;
    String connectURL;

    public DB_Verbindung(String user, String passwort, String connectURL) {
        this.connectURL = connectURL;
        datenbankverbindung = null;
        datenbanktreiberLaden();
        dBVerbindungAufbauen(user, passwort);
    }
	
    private void datenbanktreiberLaden(){
            try{
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.println("Treiber erfolgreich geladen!");
            } catch(Exception e){
                    System.out.println("Treiber konnte nicht geladen werden!");
                    e.printStackTrace();
                    //Programm abbrechen
                    System.exit(-1);
            }
    }
	
    private void dBVerbindungAufbauen(String user, String password){
            try{
                    datenbankverbindung = DriverManager.getConnection(connectURL, user, password);
                    System.out.println("Verbindung zum Server bzw. zur Datenbank erfolgreich!");
            } catch(SQLException e){
                    System.out.println("ES kann keine Verbindung zum Server bzw. zur Datenbank hergestellt werden!");
                    e.printStackTrace();
            }
    }
    
    public ArrayList<String> getKlassennamen(){
        ArrayList<String> klassennamen = new ArrayList<>();
        try{
            String query = "SELECT DISTINCT Klasse FROM schueler";
            Statement stmt = datenbankverbindung.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                // Ausgabe der einzelnen Feldwerte mit get-Methoden (bitte Datentyp beachten)
                System.out.println(rs.getString("Klasse"));
                klassennamen.add(rs.getString("Klasse"));
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Kein Zugriff auf Tabelle möglich");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return klassennamen;
    }
    
    public ArrayList<Schueler> getSchueler(String Klasse){
        ArrayList<Schueler> schueler = new ArrayList<>();
        try{
            String query = "SELECT Vorname, Name, Klasse, Geburtsdatum, Strasse, PLZ, OrtAbk, AbschlussDatum FROM schueler WHERE Klasse = ?";
            Statement stmt = datenbankverbindung.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Customer-ID\tName\t\tCity\tCreditlimit");

            while(rs.next()){
                
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Kein Zugriff auf Tabelle möglich");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return schueler;
    }
	
    /** Referenzen SQL Insert, Update, Select:
    public int dBInsertCustomer(int customer_id, String name, String city, int creditlimit ){
            try {
                    String queryUpdate = ("Insert into customer values (?,?,?,?)");
                    PreparedStatement psStatement = datenbankverbindung.prepareStatement(queryUpdate);
                    Ersetzen der ? durch die Werte
                    psStatement.setInt(1, customer_id);
                    psStatement.setString(2, name);
                    psStatement.setString(3, city);
                    psStatement.setInt(4, creditlimit);

                    return psStatement.executeUpdate();
            } catch (Exception e1) {
                     TODO Auto-generated catch block
                    e1.printStackTrace();
            }
            return 0;
    }
	
	public int dBUpdateInt(String table, String column,int oldValue, int newValue ){
		try {
			String queryUpdate = ("UPDATE " + table + " SET " + column + " = ? WHERE " + column + " = ?");
			PreparedStatement psStatement = datenbankverbindung.prepareStatement(queryUpdate);
			Ersetzen der ? durch die Werte
			psStatement.setInt(1, newValue);
			psStatement.setInt(2, oldValue);

			return psStatement.executeUpdate();
		} catch (Exception e1) {
			 TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	public void ausgabeTabelleCustomer(){
		try{
			String query = "SELECT * FROM customer";
			Statement stmt = datenbankverbindung.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("Customer-ID\tName\t\tCity\tCreditlimit");

			while(rs.next()){
				 Ausgabe der einzelnen Feldwerte mit get-Methoden (bitte Datentyp beachten)
				System.out.println(rs.getInt("customer_id") + "\t\t" + rs.getString("name") + "\t\t" + rs.getString("city") + "\t\t" + rs.getInt("creditlimit"));
			}
			rs.close();
			stmt.close();
		}catch(SQLException e){
			System.out.println("Kein Zugriff auf Tabelle möglich");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}*/
	
    public void beenden(){
        try {
            datenbankverbindung.close();
        } catch (SQLException e) {
            System.out.println("Die Connection konnte nich geschlossen werden.");
            e.printStackTrace();
        }
    }
}
