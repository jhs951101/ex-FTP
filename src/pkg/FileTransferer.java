package pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*50*5
)
@WebServlet("/FileTransferer")
public class FileTransferer extends HttpServlet {
	
	/*
		Save Root
			Mac: /Users/(username)/Documents/dev/workspace/Java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TestFTP/(folder)/(real file)
	*/
	
	public static String projectName = "BeautySimulator";
	public static String projectPath = "/Users/sharping/Documents/dev/workspace/java-workspace/" + projectName;
	
	private String realPath;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part filePart = request.getPart("file");
			realPath = request.getServletContext().getRealPath(".");
	        String fileName = filePart.getSubmittedFileName();
	        String folderPath = realPath + File.separator + fileName;
	        String filePath = folderPath + File.separator + fileName;
	        
	        File folder = new File(folderPath);
	        if(!folder.exists())
	        	folder.mkdir();
	        
	        InputStream fis = filePart.getInputStream();
	        OutputStream fos = new FileOutputStream(filePath);
			FileWriter(fis, fos);
			fos.close();
			fis.close();
			
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void FileWriter(InputStream is, OutputStream os) throws IOException {
		byte[] buf = new byte[1024];
		int size = 0;
		
		while((size = is.read(buf)) != -1)
			os.write(buf,0,size);
	}
}
