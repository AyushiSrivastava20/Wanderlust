package com.me.myfinalproject;

import java.awt.Color;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;

import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.me.myfinalproject.pojo.Booking;
import com.me.myfinalproject.pojo.Customer;
import com.lowagie.text.Chunk;

import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;


public class PdfReportView  extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Booking b = (Booking) request.getSession().getAttribute("trip");
		System.out.println(b.getRoomname());
		 
		 Paragraph paragraph1 = new Paragraph();
         paragraph1.add("Booking Details");
         paragraph1.setAlignment(Element.ALIGN_CENTER);
         doc.add(paragraph1);
         doc.add(Chunk.NEWLINE);
         doc.add(new LineSeparator());
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         Paragraph paragraph2 = new Paragraph();
         paragraph2.add("Booking Name : " + b.getRoomname());
         paragraph2.setAlignment(Element.ALIGN_LEFT);
         doc.add(paragraph2);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         Paragraph paragraph3 = new Paragraph();
         paragraph3.add("Booking City : " + b.getRoomcity());
         paragraph3.setAlignment(Element.ALIGN_LEFT);
         doc.add(paragraph3);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         Paragraph paragraph4 = new Paragraph();
         paragraph4.add("Start Date : " + b.getBegin());
         paragraph4.setAlignment(Element.ALIGN_LEFT);
         doc.add(paragraph4);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         Paragraph paragraph5 = new Paragraph();
         paragraph5.add("End Date : " + b.getEnd());
         paragraph5.setAlignment(Element.ALIGN_LEFT);
         doc.add(paragraph5);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         Paragraph paragraph6 = new Paragraph();
         paragraph6.add("Cost $ : " + b.getTotal());
         paragraph6.setAlignment(Element.ALIGN_LEFT);
         doc.add(paragraph6);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
          Paragraph paragraph7 = new Paragraph();
          paragraph7.add("Thank you for choosing Wandurlust"
                 + "Please contact our customer care department at (857) 800-3978 with any questions or to set your payments. Thank you ");
         paragraph7.setAlignment(Element.ALIGN_JUSTIFIED);
         doc.add(paragraph7);
         doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
	     doc.add(Chunk.NEWLINE);
         doc.add(Chunk.NEWLINE);
         doc.add(new LineSeparator());
         
         doc.close();
		 
		
		
		
		
	}

}
