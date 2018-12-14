/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;



/**
 *
 * @author jonas.klocke
 */
public class PDF_Generator {

    public PDF_Generator() {
    }
    
    public void erzeugePDF(ArrayList<Schuelerausweis> schuelerausweise, String pfad) throws SQLException{
        String schuelerdaten = "";
        for(int i = 0; i < schuelerausweise.size(); i++){
            int durchlauf = 0;
            if(i%3 == 0){
            
            //int n = i + 2;
            //int z = i + 1;
            schuelerdaten = "<html>" + schuelerausweise.get(i).getSchuelerDaten()+"\n" + schuelerausweise.get(i+1).getSchuelerDaten() +"\n" + schuelerausweise.get(i+2).getSchuelerDaten() +"</html>";
            
        
            //for(Schuelerausweis saw : schuelerausweise)  {
            //String schuelerdaten = saw.getSchuelerDaten();
            //System.out.println(schuelerdaten);
            try {
            durchlauf++;
            String name = pfad + "/schuelerausweis" + (((durchlauf-1)*3)+1) + "-" + (durchlauf*3) + ".pdf";
            
            OutputStream file = new FileOutputStream(new File(name));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            StringReader is = new StringReader(schuelerdaten);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
            //Image bild = PngImage.getImage("Schuelerausweisdesign.png");
            int zaehler = 0;
            while(zaehler < 3)
            {
                Image bild2 = PngImage.getImage("src/schuelerausweisgeneratorkl/atiw-bk_150x60.png");
                bild2.setAbsolutePosition(190, 780-(zaehler*150));
                bild2.scalePercent(45); 
                zaehler++;
                document.add(bild2);
            }
            //InputStream in = saw.getSchueler().getBild().getBinaryStream();  
            
            //Image image = ImageIO.read(in).getScaledInstance(0, 0, 0);
            //document.add(bild);
            
            //Image image = Image.getInstance(in);
            zaehler = 0;
            while(zaehler < 3){
                Blob imageBlob = (Blob) schuelerausweise.get(zaehler).getSchueler().getBild(); 
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                Image bild1 = Image.getInstance(imageBytes);
                bild1.setAbsolutePosition(200,668-(zaehler*150));//scaleAbsolute(300,300);
                bild1.scalePercent(34);
                document.add(bild1);
                zaehler++;
            }
            document.close();
            file.close();
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }    
            }
        }
        //}        
        
        
        
//        for(Schuelerausweis saw : schuelerausweise)  {
//            String schuelerdaten = saw.getSchuelerDaten();
//            //System.out.println(schuelerdaten);
//            try {
//            String name = pfad + "/schuelerausweis" + saw.getSchueler().getName() + ".pdf";
//            OutputStream file = new FileOutputStream(new File(name));
//            Document document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, file);
//            document.open();
//            StringReader is = new StringReader(schuelerdaten);
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
//            //Image bild = PngImage.getImage("Schuelerausweisdesign.png");
//            Image bild2 = PngImage.getImage("src/schuelerausweisgeneratorkl/atiw-bk_150x60.png");
//            bild2.setAbsolutePosition(190, 780);
//            bild2.scalePercent(45); 
//            //InputStream in = saw.getSchueler().getBild().getBinaryStream();  
//            
//            //Image image = ImageIO.read(in).getScaledInstance(0, 0, 0);
//            //document.add(bild);
//            
//            //Image image = Image.getInstance(in);
//            
//            Blob imageBlob = (Blob) saw.getSchueler().getBild(); 
//            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
//            Image bild1 = Image.getInstance(imageBytes);
//            bild1.setAbsolutePosition(200,668);//scaleAbsolute(300,300);
//            bild1.scalePercent(34);
//
//            document.add(bild2);
//            document.add(bild1);
//            document.close();
//            file.close();
//            } catch (DocumentException | IOException e) {
//                e.printStackTrace();
//            }    
//        }
    }
}
