/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author jonas.klocke, jonas.linde
 */
public class PDF_Generator {

    public PDF_Generator() {
    }
    
    public void erzeugePDF(ArrayList<Schuelerausweis> schuelerausweise, String pfad) throws SQLException, FileNotFoundException{
        String schuelerdaten = "";
        String htmlRueckseite = new Scanner(new File("schuelerausweisrueckseite.html")).useDelimiter("\\Z").next();
        for(int i = 0; i < schuelerausweise.size(); i++){
            if(i == schuelerausweise.size() - schuelerausweise.size() % 5){
                schuelerdaten = "<html> <div height=\"22\">&nbsp;</div>";
                for(int j = 0; j < schuelerausweise.size() % 5; j++){
                    schuelerdaten += htmlRueckseite;
                }
                schuelerdaten+="<div height=\"" + (200 * (5 - schuelerausweise.size() % 5)) + "\">&nbsp;</div> <div>&nbsp;</div>";
                for(int j = 0; j < schuelerausweise.size() % 5; j++){
                    schuelerdaten += schuelerausweise.get(i+j).getSchuelerDaten() + "\n";
                }
                schuelerdaten += "</html>";
                try {
                String name = pfad + "/schuelerausweis" + (i+1) + "-" + ((i+schuelerausweise.size() % 5)) + ".pdf";
                //height=\"110\"

                OutputStream file = new FileOutputStream(new File(name));
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, file);
                StringReader is = new StringReader(schuelerdaten);
                document.open();
                XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
                
                this.bilderEinfuegen(document, schuelerausweise.size() % 5, i, schuelerausweise);
                document.close();
                file.close();

                } catch (DocumentException | IOException e) {
                    e.printStackTrace();
                }
            }
            if(i%5 == 0 && schuelerausweise.size() - i > 5){
                schuelerdaten = 
                    "<html> <div height=\"22\">&nbsp;</div>" + htmlRueckseite + htmlRueckseite + htmlRueckseite + htmlRueckseite + htmlRueckseite + "<div>&nbsp;</div>" +
                    schuelerausweise.get(i).getSchuelerDaten()+"\n" + schuelerausweise.get(i+1).getSchuelerDaten() +"\n" + 
                    schuelerausweise.get(i+2).getSchuelerDaten()+"\n" + schuelerausweise.get(i+3).getSchuelerDaten()+"\n" + 
                    schuelerausweise.get(i+4).getSchuelerDaten() + "</html>";
                try {
                String name = pfad + "/schuelerausweis" + (i+1) + "-" + ((i+5)) + ".pdf";
                //height=\"110\"

                OutputStream file = new FileOutputStream(new File(name));
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, file);
                StringReader is = new StringReader(schuelerdaten);
                document.open();
                XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
                
                this.bilderEinfuegen(document, 5, i, schuelerausweise);
                
                document.close();
                file.close();

                } catch (DocumentException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void bilderEinfuegen(Document doc, int anzahlBilder, int position, ArrayList<Schuelerausweis> schuelerausweise) throws IOException, SQLException, BadElementException, DocumentException{
        int zaehler = 0;
        int pos = position;
        while(position < pos+anzahlBilder){
            Image bild2 = PngImage.getImage("src/schuelerausweisgeneratorkl/atiw-bk_150x60.png");
            bild2.setAbsolutePosition(190, 780-16-(zaehler*151));
            bild2.scalePercent(45); 
            
            Blob imageBlob = (Blob) schuelerausweise.get(position).getSchueler().getBild(); 
            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
            Image bild1 = Image.getInstance(imageBytes);
            bild1.setAbsolutePosition(200,668-18-(zaehler*151));
            bild1.scalePercent(34);
            
            doc.add(bild1);
            doc.add(bild2);
            
            position++;
            zaehler++;    
        }
    }
}
