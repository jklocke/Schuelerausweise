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
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;



/**
 *
 * @author jonas.klocke
 */
public class PDF_Generator {

    public PDF_Generator() {
    }
    
    public void erzeugePDF(ArrayList<Schuelerausweis> schuelerausweise){
        for(Schuelerausweis saw : schuelerausweise)   {
            String schuelerdaten = saw.getSchuelerDaten();
            System.out.println(schuelerdaten);
            try {
            String name = "schuelerausweis" + saw.getSchueler().getName() + ".pdf";
            OutputStream file = new FileOutputStream(new File(name));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            StringReader is = new StringReader(schuelerdaten);
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
            //Image bild = PngImage.getImage("Schuelerausweisdesign.png");
            //Image bild2 = PngImage.getImage("atiw-bk_150x60.png");
            //document.add(bild);
            //document.add(bild2);
            document.close();
            file.close();
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }    
        }
    }
}
