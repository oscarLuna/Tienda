package com.mpersd.techshop.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.mpersd.techshop.modelo.Orden;
import com.mpersd.techshop.modelo.ProductoCarrito;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GeneradorPDF {

public static final String DEST = "C:/Windows/Temp/pedido.pdf";
static PdfFont timesNewRoman = null;
static PdfFont timesNewRomanBold = null;

public static final String LOGO = "techshopsec/resources/logo.jpg";
     
        public void createPdf(Orden ordenCompra) throws IOException {
        	
        	timesNewRoman = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            timesNewRomanBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
            
            NumberFormat moneda = NumberFormat.getCurrencyInstance(Locale.US);
            
            String nombreCompleto = ordenCompra.getUsuario().getNombres()+" "+ordenCompra.getUsuario().getApellidoPaterno()+" "+ordenCompra.getUsuario().getApellidoMaterno();
        	List<String> cabecera = Arrays.asList(new String[]{"Producto", "Precio Unitario","Cantidad","Subtotal"});
            PdfWriter writer = new PdfWriter(DEST);
     
            PdfDocument pdf = new PdfDocument(writer);
     
            Document document = new Document(pdf);
    
            document.add(new Paragraph("TechShop").setFont(timesNewRomanBold).setFontSize(18).setTextAlignment(TextAlignment.CENTER));
            
            document.add(new Paragraph("Datos de cliente").setFont(timesNewRomanBold).setFontSize(14));
            
            document.add(new Paragraph("Nombre: " + nombreCompleto).setFont(timesNewRoman).setFontSize(14));
            document.add(new Paragraph("Domicilio: " + ordenCompra.getDomicilio()).setFont(timesNewRoman).setFontSize(14));
            document.add(new Paragraph("Email: " + ordenCompra.getUsuario().getEmail()).setFont(timesNewRoman).setFontSize(14));
            
            Table table = new Table(new float[]{3, 2, 2, 2});
            table.setWidthPercent(100);
            
            for(String texto : cabecera){
            	table.addHeaderCell(new Cell().add(texto).setFont(timesNewRomanBold));
            }
            for(ProductoCarrito pCarrito : ordenCompra.getCarrito().getProductos()){
                table.addCell(new Cell().add(new Paragraph(pCarrito.getProducto().getMarca()+" "+pCarrito.getProducto().getNombre()).setFont(timesNewRoman)));
                table.addCell(new Cell().add(new Paragraph(moneda.format(pCarrito.getProducto().getPrecio())).setFont(timesNewRoman)));
                table.addCell(new Cell().add(new Paragraph(pCarrito.getCantidad()+"").setFont(timesNewRoman)));
                table.addCell(new Cell().add(new Paragraph(moneda.format(pCarrito.getSubtotal())).setFont(timesNewRoman)));
            }
            document.add(table);
            
            document.add(new Paragraph("Cantidad total de productos: " + ordenCompra.getCarrito().getCantidadTotal()).setFont(timesNewRoman).setFontSize(14).setTextAlignment(TextAlignment.RIGHT));
            document.add(new Paragraph("Total a pagar: " + moneda.format(ordenCompra.getCarrito().getPrecioTotal())).setFont(timesNewRoman).setFontSize(14).setTextAlignment(TextAlignment.RIGHT));
            document.close();
        }
        
        
}
