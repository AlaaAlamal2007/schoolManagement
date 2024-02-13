package com.alaa.school.utils;

import com.alaa.school.domain.*;
import com.alaa.school.exceptions.ClassInSchoolResourceException;
import com.alaa.school.exceptions.SubjectResourceException;
import com.alaa.school.exceptions.TeacherResourceException;
import com.alaa.school.repository.*;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelDailySessionsExportUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DailySessionDistributed> dailySessionDistributed;
    private final TeacherRepository teacherRepository;
    private final ClassInSchoolRepository classInSchoolRepository;
    private final SubjectRepository subjectRepository;
    private final DailySessionRepository dailySessionRepository;
    private final SessionRepository sessionRepository;

    public ExcelDailySessionsExportUtils(List<DailySessionDistributed> dailySessionDistributed, TeacherRepository teacherRepository, ClassInSchoolRepository classInSchoolRepository, SubjectRepository subjectRepository, DailySessionRepository dailySessionRepository, SessionRepository sessionRepository) {
        this.dailySessionDistributed = dailySessionDistributed;
        this.teacherRepository = teacherRepository;
        this.classInSchoolRepository = classInSchoolRepository;
        this.subjectRepository = subjectRepository;
        this.dailySessionRepository = dailySessionRepository;
        this.sessionRepository = sessionRepository;
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
        } else if (value instanceof SessionDay) {
            cell.setCellValue(value.toString());
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
        sheet.autoSizeColumn(columnCount);
        return cell;
    }

    private void createHeaderRow() {
        sheet = workbook.createSheet("Daily session");
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
        Cell c = createCell(row, 0, "Daily sessions", style);
        style.setAlignment(HorizontalAlignment.LEFT);
        c.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        font.setFontHeightInPoints((short) 10);
        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        createCell(row, 0, "teacher name", style);
        createCell(row, 1, "subject name", style);
        createCell(row, 2, "class name", style);
        createCell(row, 3, "session number", style);
        createCell(row, 4, "day", style);
    }

    private void writeDailySessionDistributedData() {
        ClassInSchool classInSchool = new ClassInSchool();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        DailySession dailySession = new DailySession();
        Session session = new Session();
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.LEFT);
        for (DailySessionDistributed dsd : dailySessionDistributed) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            classInSchool = classInSchoolRepository.findById(dsd.getClassId()).orElseThrow(
                    () -> new ClassInSchoolResourceException("class does not exist ")
            );
            teacher = teacherRepository.findById(dsd.getTeacherId()).orElseThrow(
                    () -> new TeacherResourceException("teacher does not exist ")
            );
            subject = subjectRepository.findById(dsd.getSubjectId()).orElseThrow(
                    () -> new SubjectResourceException("subject does not exist ")
            );
            dailySession = dailySessionRepository.findById(dsd.getDailySessionsId()).orElseThrow(
                    () -> new RuntimeException("day does not exist ")
            );
            session = sessionRepository.findById(dsd.getSessionId()).orElseThrow(
                    () -> new RuntimeException("session does not exist")
            );

            createCell(row, columnCount++, teacher.getFirstName() + " " + teacher.getLastName(), style);
            createCell(row, columnCount++, subject.getName(), style);
            createCell(row, columnCount++, classInSchool.getClassType() + "/" + classInSchool.getClassNumber(), style);
            createCell(row, columnCount++, session.getId(), style);
            createCell(row, columnCount++, dailySession.getDayName(), style);
        }
    }

    public void exportDailySessionsToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeDailySessionDistributedData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

