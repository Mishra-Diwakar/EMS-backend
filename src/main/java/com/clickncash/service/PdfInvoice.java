package com.clickncash.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

@Service
public class PdfInvoice {

	public void generateInvoice(String path) throws IOException {
		
		PdfWriter writer = new PdfWriter(path);
		PdfDocument doc = new PdfDocument(writer);
		
			doc.setDefaultPageSize(PageSize.A4);
			Document document = new Document(doc);

			float threecol = 198f;
			float twocol = 285f;
			float twocol150 = twocol + 150f;
			float twocolwidth[] = { twocol150, twocol };
			float fullwidth[] = { threecol * 3 };
			
			Paragraph p = new Paragraph("\n");

			Paragraph header = new Paragraph("Online Payement Receipt").setTextAlignment(TextAlignment.CENTER)
					.setFontSize(20);
			document.add(header.setMarginBottom(12f));
			Table twoColTable = new Table(twocolwidth);
			twoColTable.addCell(getBillingandShippingCell("User Id :" + " 34523"));
			twoColTable.addCell(getBillingandShippingCell("Dectechno Softwares Private Limited"));
			twoColTable.addCell(getBillingandShippingCell("Name :" + "VidyaPrasadLods"));
			twoColTable.addCell(
					new Cell().add("2023-06-03").setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
			twoColTable.addCell(getBillingandShippingCell("Phone :" + "8767654543"));
			twoColTable.addCell(getBillingandShippingCell(""));
			twoColTable.addCell(getBillingandShippingCell("Email :" + "Vidya@gmail.com"));
			document.add(twoColTable.setMarginBottom(12f));

			Border bd = new SolidBorder(Color.GRAY, 1f);
			Table divider = new Table(fullwidth);
			divider.setBorder(bd);

			document.add(p);
			document.add(divider);

			Table twoColTable1 = new Table(twocolwidth);
			twoColTable1.addCell(
					new Cell().add("Description").setBorder(Border.NO_BORDER).setBold().setFontColor(Color.RED));

			twoColTable1
					.addCell(new Cell().add("Amount").setBorder(Border.NO_BORDER).setBold().setFontColor(Color.RED));
			twoColTable1.addCell(new Cell().add("Wallet Recharge").setBorder(Border.NO_BORDER));
			twoColTable1.addCell(new Cell().add("5000").setBorder(Border.NO_BORDER));
			document.add(twoColTable1);

			Border bd1 = new SolidBorder(Color.GRAY, 1f);
			Table divider1 = new Table(fullwidth);
			divider.setBorder(bd1);

			document.add(divider1.setBorder(bd1));

			float onetwo[] = { threecol + 125f, threecol * 2 };
			Table twoColTable2 = new Table(onetwo);
			twoColTable2.addCell(new Cell().add("Reference No.").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("3637633436").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("PayementOrder No.").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("SB87654455.").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("Transaction Id").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("32345665245").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("Payement Mode").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("UPI").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("Status").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("Paid").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("Amount Paid").setBorder(Border.NO_BORDER));
			twoColTable2.addCell(new Cell().add("5000.00").setBorder(Border.NO_BORDER));

			document.add(p);
			document.add(twoColTable2.setMarginTop(12f));

			String add = " Sher-e-punjab Colony Nxt To Gurudwara Andheri , Mumbai,Gurgaon,400093,India";
			Paragraph p1 = new Paragraph(add);
			document.add(p);
			document.add(p1.setTextAlignment(TextAlignment.CENTER).setFontColor(Color.GRAY));

			String g = "GST:06AAA654SDFTER";
			Paragraph p2 = new Paragraph(g);
			document.add(p2.setTextAlignment(TextAlignment.CENTER).setFontColor(Color.GRAY));

			Border bd2 = new DashedBorder(Color.GRAY, 0.5f);
			Table div = new Table(fullwidth);
			div.setBorder(bd2);
			document.add(div);

			String g1 = "(This is a computer generated statement and does not require signature)";
			Paragraph p3 = new Paragraph(g1);
			document.add(p3.setTextAlignment(TextAlignment.CENTER).setFontColor(Color.BLACK));
			
			document.close();
		}

	static Cell getBillingandShippingCell(String textValue) {
		return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
	}

}
