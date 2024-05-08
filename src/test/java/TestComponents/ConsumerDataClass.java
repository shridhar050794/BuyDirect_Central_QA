package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConsumerDataClass {
	public static Map<String, String> ExcelDataReader() throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\New folder\\Selenium\\New folder\\BuyDirect_FrameWork_Duplicate\\ConsumerData.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("ConsumerData");

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        Map<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < colCount; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null) {
                dataMap.put(cell.getStringCellValue(), "");
            }
        }

        int rowCount = sheet.getLastRowNum();
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell cell = row.getCell(j);
                if (cell != null && headerCell != null) {
                    String columnName = headerCell.getStringCellValue();
                    switch (cell.getCellType()) {
                        case STRING:
                            dataMap.put(columnName, cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                dataMap.put(columnName, cell.getDateCellValue().toString());
                            } else {
                                dataMap.put(columnName, String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            dataMap.put(columnName, String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            dataMap.put(columnName, "");
                            break;
                        default:
                            dataMap.put(columnName, cell.getStringCellValue());
                    }
                }
            }
        }

        workbook.close();
        inputStream.close();
        return dataMap;
    }

}
