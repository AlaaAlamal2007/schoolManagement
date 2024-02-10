package com.alaa.school.utils;

import com.alaa.school.domain.Student;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ExcelStudentExportUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Student> studentList;

    public ExcelStudentExportUtils(List<Student> customerList) {
        this.studentList = customerList;
        workbook = new XSSFWorkbook();
    }

    private Cell createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Instant) {
            Date date = Date.from((Instant) value);
            String dateFormat = "dd/mm/yyyy";
            String val = new CellDateFormatter(dateFormat).format(date);
            cell.setCellValue(val);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
        sheet.autoSizeColumn(columnCount);
        return cell;
    }

    private void createHeaderRow() {
        sheet = workbook.createSheet("Student Information");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderBottom(BorderStyle.MEDIUM);
        Cell c = createCell(row, 0, "Student Information", style);
        style.setAlignment(HorizontalAlignment.LEFT);
        c.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));
        font.setFontHeightInPoints((short) 10);
        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "First Name", style);
        createCell(row, 2, "Second Name", style);
        createCell(row, 3, "third Name", style);
        createCell(row, 4, "Last Name", style);
        createCell(row, 5, "IdentificationNumber", style);
        createCell(row, 6, "Email", style);
        createCell(row, 7, "Mobile", style);
        createCell(row, 8, "birthdate", style);
        createCell(row, 9, "City", style);
        createCell(row, 10, "StreetName", style);
        createCell(row, 11, "StreetNumber", style);
        createCell(row, 12, "PostCode", style);
    }

    private void writeStudentData() {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.LEFT);
        for (Student student : studentList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, student.getId(), style);
            createCell(row, columnCount++, student.getFirstName(), style);
            createCell(row, columnCount++, student.getSecondName(), style);
            createCell(row, columnCount++, student.getThirdName(), style);
            createCell(row, columnCount++, student.getLastName(), style);
            createCell(row, columnCount++, student.getIdentificationNumber(), style);
            createCell(row, columnCount++, student.getEmail(), style);
            createCell(row, columnCount++, student.getMobile(), style);
            createCell(row, columnCount++, student.getBirthDate(), style);
            createCell(row, columnCount++, student.getAddress().getCity(), style);
            createCell(row, columnCount++, student.getAddress().getStreetName(), style);
            createCell(row, columnCount++, student.getAddress().getStreetNumber(), style);
            createCell(row, columnCount++, student.getAddress().getPostCode(), style);
        }
    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeStudentData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

