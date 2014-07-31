package com.owatonnarobotics;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

/**
 *
 * @author Eson
 */
public class ExcelManager {
    private static final String excelLocation = "time_log.xls";
    
    //Lists the different column values
    private static final int idColumn = 0;
    private static final int fNameColumn = 1;
    private static final int lNameColumn = 2;
    private static final int teamColumn = 3;
    private static final int totalTimeColumn = 5;
    private static final int datesStartColumn = 8;
    
    private static final int rowStart = 2;
    
    // Returns a new user given the id
    public static User getUser(String id) throws IOException, BiffException{
        Workbook workbook = Workbook.getWorkbook(new File(excelLocation));
        
        Sheet sheet = workbook.getSheet(0);
        
        for(int currentRow = rowStart; currentRow < sheet.getRows(); currentRow ++){
            Cell cell = sheet.getCell(0, currentRow);
            if(cell.getContents().equals(id)){
                String fName = sheet.getCell(fNameColumn, currentRow).getContents();
                String lName = sheet.getCell(lNameColumn, currentRow).getContents();
                int totalTime = Integer.parseInt(sheet.getCell(totalTimeColumn, currentRow).getContents());
                
                workbook.close();
                return new User(fName, lName, id, totalTime);
            }
            currentRow += 1;
        }
        
        workbook.close();
        return null;
    }
}
