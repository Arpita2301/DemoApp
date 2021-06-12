package com.project.example.helper;

import com.project.example.entity.QuestionAnswer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Description", "FOption", "SOption" };
    static String SHEET = "QuestionAnswers";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<QuestionAnswer> excelToQuestionAnswers(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                QuestionAnswer questionAnswer = new QuestionAnswer();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {

//                        case 0:
//                            questionAnswer.setQId((long) currentCell.getNumericCellValue());
//                            break;

                        case 0:
                            questionAnswer.setQId(Integer.toString((int)Math.round(currentCell.getNumericCellValue()))
                            );
                            break;

                        case 1:
                            questionAnswer.setDescription(currentCell.getStringCellValue());
                            break;

//                        case 2:
//                            questionAnswer.setImg(currentCell.getStringCellValue());
//                            break;

                        case 2:
                            questionAnswer.setFOption(currentCell.getStringCellValue());
                            break;

                        case 3:
                            questionAnswer.setSOption(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                questionAnswers.add(questionAnswer);
            }

            workbook.close();

            return questionAnswers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
