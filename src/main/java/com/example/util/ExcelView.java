package com.example.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.example.model.Notice;

public class ExcelView {

	// 공지사항 Excel 다운로드 기능 Class
	public static void writeNoticeListToFile(String fileName, Page<Notice> noticeList) throws Exception {
		Workbook workbook = null;

		if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (fileName.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		}

		Sheet sheet = workbook.createSheet("cordova");

		Iterator<Notice> iterator = noticeList.iterator();

		int rowIndex = 0;
		int excelname = 0;
		do {
			Notice notice = iterator.next();
			Row row = sheet.createRow(rowIndex++);

			System.out.println("번호 : " + notice.getNoticeNo());
			if (excelname == 0) {

				Cell cell0 = row.createCell(0);
				cell0.setCellValue("번호");
				Cell cell1 = row.createCell(1);
				cell1.setCellValue("제목");
				Cell cell2 = row.createCell(2);
				cell2.setCellValue("등록일");
				excelname++;

			} else {

				Cell cell0 = row.createCell(0);
				cell0.setCellValue(notice.getNoticeNo());
				Cell cell1 = row.createCell(1);
				cell1.setCellValue(notice.getSubject());
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(notice.getRegDate());

			}

		} while (iterator.hasNext());

		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
	}
}