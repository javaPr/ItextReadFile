package cn.edu.wang.ItextReadPDF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDF {

	  public static final String RESULT  = "F:\\readFromPDF1.txt";//存放由pdf转换成txt文件的路径。

	    /**

	     * Main method.

	     * @param args no arguments needed

	     * @throws DocumentException

	     * @throws IOException

	     */

	    public static void main(String[] args)

	        throws DocumentException, IOException {

	        PrintWriter writer = new PrintWriter(new FileOutputStream(RESULT));//txt文件写入流

	        String string = "F:\\1201433989.PDF";//pdf文件路径

	        inspect(writer,string); //调用读取方法

	        writer.close();
	        System.out.println("END");

	    }

	    /**

	     * Inspect a PDF file and write the info to a txt file

	     * @param writer Writer to a text file

	     * @param filename Path to the PDF file

	     * @throws IOException

	     */

	    public static void inspect(PrintWriter writer, String filename)

	        throws IOException {

	        PdfReader reader = new PdfReader(filename); //读取pdf所使用的输出流

	        int num = reader.getNumberOfPages();//获得页数

	        String content = "";  //存放读取出的文档内容
	        System.out.println(num);

	        for (int i = 1; i <10; i++) {

	        	//if(i == 1)
	        		
	           content += PdfTextExtractor.getTextFromPage(reader, i); //读取第i页的文档内容
	        	System.out.println(content);
	                  }

	       writer.write(content);//写入文件内容

	        writer.flush();

	    }
	
}
