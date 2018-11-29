/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.util.ArrayList;



/**
 *
 * @author jonas.klocke
 */
public class PDF_Generator {

    public PDF_Generator() {
    }
    
    public void erzeugePDF(ArrayList<Schuelerausweis> schuelera){
        for(Schuelerausweis saw : schuelera)   {
            saw.getSchuelerDaten();
//            try {
//            OutputStream file = new FileOutputStream(new File("schuelerausweis.pdf"));
//            Document document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, file);
//            document.open();
//            InputStream is = new ByteArrayInputStream(k.getBytes());
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
//            Image bild = PngImage.getImage("Schuelerausweisdesign.png");
//            Image bild2 = PngImage.getImage("atiw-bk_150x60.png");
//            document.add(bild);
//            document.add(bild2);
//            document.close();
//            file.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }    
        }
    }
}
