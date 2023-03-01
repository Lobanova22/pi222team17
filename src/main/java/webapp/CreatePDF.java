package webapp;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatePDF.
 * @author Shimanov K.A.
 */
public class CreatePDF {
	
	/** The times. */
	private BaseFont times = null;

	/**
	 * Gets the pdf path.
	 *
	 * @return the pdf path
	 */
	public static String getPdfPath() {
		return pdfPath;
	}

	/** The pdf path. */
	public static String pdfPath;

    /**
     * Create.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */

    public void Create(Calculation calculation, double result) throws IOException {
      	
    	Document document = new Document();
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		StringBuilder abspath= new StringBuilder();
		for(int i=0;i<(lengthpath-1);i++) {
			abspath.append(parsfilepath[i]).append("/");
		}
		filepath=abspath + "/webapps/WebApp/Check.pdf";
		pdfPath = filepath;
		String imagepath= Objects.requireNonNull(CreatePDF.class.getResource("/img/logo.png")).getPath();
		String fontpath = Objects.requireNonNull(CreatePDF.class.getResource("/fonts/times.ttf")).getPath();
    	
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
					
		document.open(); 

		try {
			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}

		Font font20 = new Font(times,20);
		Font font16 = new Font(times,16);

		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph("Налоговой Калькулятор. Транспортный налог", font20));
		paragraph.add(new Paragraph("ФИО: " + calculation.getSurname() + " " + calculation.getName() + " " + calculation.getPatronymic(), font16));
		paragraph.add(new Paragraph("Период: " + calculation.getPeriod() + " мес.", font16));
		paragraph.add(new Paragraph("Мощность: " + calculation.getPower() + " л.с.", font16));
		paragraph.add(new Paragraph(calculation.getPrivileges(), font16));
		paragraph.add(new Paragraph(calculation.getLuxury(), font16));
		paragraph.add(new Paragraph("Транспортный налог - " + result + " руб.", font16));

		try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
		paragraph.clear();

	    Image img = null;
		try {
			img = Image.getInstance(imagepath);
		} catch (BadElementException | IOException e2) {
			e2.printStackTrace();
		}

		// Objects.requireNonNull(img).setAbsolutePosition(0, 0);

		/*
		try {
				document.add(img);
		} catch (DocumentException e) {
				e.printStackTrace();
		}
		*/
	     
	    document.close();
    }
}