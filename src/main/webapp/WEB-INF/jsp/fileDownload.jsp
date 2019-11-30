<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="org.springframework.util.FileCopyUtils" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일다운로드</title>
<%!
private String getBrowser(HttpServletRequest request) {
	String header = request.getHeader("User-Agent");
	if (header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1)
		return "MSIE";
	else if (header.indexOf("Chrome") > -1)
		return "Chrome";
	else if (header.indexOf("Opera") > -1)
		return "Opera";
	return "Firefox";
}

private String getDisposition(String filename, String browser) throws UnsupportedEncodingException {
	String dispositionPrefix = "attachment;filename=";
	String encodedFilename = null;
	if (browser.equals("MSIE")) {
		encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
	} else if (browser.equals("Firefox")) {
		encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
	} else if (browser.equals("Opera")) {
		encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
	} else if (browser.equals("Chrome")) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < filename.length(); i++) {
			char c = filename.charAt(i);
			if (c > '~') {
				sb.append(URLEncoder.encode("" + c, "UTF-8"));
			} else {
				sb.append(c);
			}
		}
		encodedFilename = sb.toString();
	}
	return dispositionPrefix + encodedFilename;
}
%>
<%
	String filePath = (String)request.getParameter("filePath");
	String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
	String realFilePath = filePath.substring(filePath.lastIndexOf("/uploads"), filePath.length());
	//파일명 인코딩
	String UTF8FileName = new String(fileName.getBytes("8859_1"), "UTF-8");
	System.out.println("파일다운로드 페이지 이동");
	String browser = getBrowser(request);
	if (browser.equals("MSIE")) {
		// 브라우저가 IE일 경우 저장될 파일 이름
		// 공백이 '+'로 인코딩된것을 다시 공백으로 바꿔준다.
		fileName = URLEncoder.encode(UTF8FileName, "UTF8").replaceAll("\\+", " ");
	} else {
		// 브라우저가 IE가 아닐 경우 저장될 파일 이름
		fileName = new String(UTF8FileName.getBytes("UTF-8"), "8859_1");
	}
	try {

		out.clear();
		out = pageContext.pushBody();

		File file = new File(filePath);

		byte b[] = new byte[1024];

		response.reset();

		//response.setContentType("application/octet-stream");
		response.setHeader("Content-Type", "application/octet-stream;");
		response.setHeader("Content-Disposition", getDisposition(fileName, browser));

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
