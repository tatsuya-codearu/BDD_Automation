package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class excelData {
    WebDriver driver;

    public String xlData(String testId, String data) throws IOException {
        FileInputStream fis = new FileInputStream(new File(
                "C:\\Users\\gvila\\Selenium\\Automation_Assessment_2\\src\\test\\java\\Data\\Luma Test Case.xlsx"));
        Workbook wk = new XSSFWorkbook(fis);

        Sheet sheet = wk.getSheet("Luma Test Data");
        ArrayList<String> rowData = new ArrayList<String>();

        Iterator<Row> rowIterator = sheet.iterator();
        while (((Iterator<?>) rowIterator).hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == CellType.BLANK) {
                    continue;
                } else {
                    if (cell.getCellType() == CellType.STRING) {
                        rowData.add(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        rowData.add(String.valueOf(cell.getNumericCellValue()));
                    }
                }
            }
        }

        int t = -1;
        int v = -1;

        for (int i = 0; i < rowData.size(); i++) {
            String value = rowData.get(i);
            if (value.equals(testId)) {
                t = i;
                break;
            }
        }

        for (int i = 0; i < rowData.size(); i++) {
            String value = rowData.get(i);
            if (value.equals(data)) {
                v = i;
                break;
            }
        }
        String result = null;

        if (t != -1 && v != -1) { // Check if t and v have been updated
            result = rowData.get(t + v);

        }
        wk.close();

        return result;
    }
}


