package com.example.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.example.model.ExpMember;
import com.example.model.Notice;

public class MemberExcelView {

	// 신청자 명단 Excel 다운로드 기능 Class
	public static void writeNoticeListToFile(String fileName, List<ExpMember> expMemberList) throws Exception {
		Workbook workbook = null;

		if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (fileName.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		}

		Sheet sheet = workbook.createSheet("cordova");

		Iterator<ExpMember> iterator = expMemberList.iterator();

		int rowIndex = 0;
		int excelname = 0;
		do {
			ExpMember expMember = iterator.next();
			Row row = sheet.createRow(rowIndex++);

			if (excelname == 0) {

				Cell cell0 = row.createCell(0);
				cell0.setCellValue("이름");
				Cell cell1 = row.createCell(1);
				cell1.setCellValue("이메일");
				Cell cell2 = row.createCell(2);
				cell2.setCellValue("연락처");
				Cell cell3 = row.createCell(3);
				cell3.setCellValue("블로그주소");
				Cell cell4 = row.createCell(4);
				cell4.setCellValue("주소");
				Cell cell5 = row.createCell(5);
				cell5.setCellValue("상품명");
				Cell cell6 = row.createCell(6);
				cell6.setCellValue("메모");
				excelname++;

			} else {

				Cell cell0 = row.createCell(0);
				cell0.setCellValue(expMember.getName());
				Cell cell1 = row.createCell(1);
				cell1.setCellValue(expMember.getEmail());
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(expMember.getPhone());
				Cell cell3 = row.createCell(3);
				cell3.setCellValue(expMember.getBlogAddress());
				Cell cell4 = row.createCell(4);
				cell4.setCellValue(expMember.getAddress());
				Cell cell5 = row.createCell(5);
				cell5.setCellValue(expMember.getPrdName());
				Cell cell6 = row.createCell(6);
				cell6.setCellValue(expMember.getMemo());

			}

			sheet.setColumnWidth(0, 3000);
			sheet.setColumnWidth(1, 10000);
			sheet.setColumnWidth(2, 7000);
			sheet.setColumnWidth(3, 10000);
			sheet.setColumnWidth(4, 10000);
			sheet.setColumnWidth(5, 10000);
			sheet.setColumnWidth(6, 10000);

		} while (iterator.hasNext());

		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
	}
}