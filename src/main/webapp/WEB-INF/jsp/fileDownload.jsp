<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.URLEncoder"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일다운로드</title>
<%
	String filePath = (String)request.getParameter("filePath");
	String fileName = "";
	String realFilePath = "";
	
	if (filePath.lastIndexOf("/") != -1) {
		fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
		realFilePath = filePath.substring(filePath.lastIndexOf("/uploads"), filePath.length());
	} else if (filePath.lastIndexOf("\\") != -1) {
		fileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length());
		realFilePath = filePath.substring(filePath.lastIndexOf("\\uploads"), filePath.length());
	}
	
	System.out.println("filePath : " + filePath);
	System.out.println("fileName : " + fileName);
	System.out.println("realFilePath : " + realFilePath);
	//파일명 인코딩
	String UTF8FileName = new String(fileName.getBytes(), "UTF-8");
	System.out.println("UTF8FileName : " + UTF8FileName);
	
	System.out.println("파일다운로드 페이지 이동");
	boolean MSIE = request.getHeader("user-agent").indexOf("MSIE") != -1;
	
	if (MSIE) {
		// 브라우저가 IE일 경우 저장될 파일 이름
		// 공백이 '+'로 인코딩된것을 다시 공백으로 바꿔준다.
		fileName = URLEncoder.encode(UTF8FileName, "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
	} else {
		// 브라우저가 IE가 아닐 경우 저장될 파일 이름
		fileName = new String(UTF8FileName.getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	}
	System.out.println("fileName2 : " + fileName);
	try {

		out.clear();
		out = pageContext.pushBody();

		File file = new File(filePath);

		byte b[] = new byte[1024];

		response.reset();

		//response.setContentType("application/octet-stream");
		/* response.setHeader("Content-Type", "application/octet-stream;");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";"); */

		response.setContentType( "application/download; UTF-8" );
        response.setHeader("Content-Type", "application/octet-stream");                
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
		
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

		int numRead;

		while ((numRead = bis.read(b, 0, b.length)) != -1) {
			bos.write(b, 0, numRead);
		}
		bos.flush();
		bos.close();
		bis.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
%>
