package com.owatonnarobotics;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Eson
 */
public class ExcelManager {
    private static final String EXCEL_LOCATION = "time_log.xls";
    
    // Lists the different column values
    private static final int ID_COLUMN = 0;
    private static final int FIRST_NAME_COLUMN = 1;
    private static final int LAST_NAME_COLUMN = 2;
    private static final int TEAM_COLUMN = 3;
    private static final int TOTAL_TIME_COLUMN = 5;
    private static final int DATES_START_COLUMN = 8;
    
    // Lists the different row values
    private static final int NAMES_ROW = 0;
    private static final int START_ROW = 2;
    
    
    // Returns a new user given the id
    public static User getUser(String id) throws IOException, BiffException{
        Workbook workbook = Workbook.getWorkbook(new File(EXCEL_LOCATION));
        
        Sheet sheet = workbook.getSheet(0);
        
        for(int currentRow = START_ROW; currentRow < sheet.getRows(); currentRow++){
            Cell cell = sheet.getCell(ID_COLUMN, currentRow);
            if(cell.getContents().equals(id)){
                String fName = sheet.getCell(FIRST_NAME_COLUMN, currentRow).getContents();
                String lName = sheet.getCell(LAST_NAME_COLUMN, currentRow).getContents();
                int totalTime = Integer.parseInt(sheet.getCell(TOTAL_TIME_COLUMN, currentRow).getContents());
                
                workbook.close();
                return new User(fName, lName, id, totalTime);
            }
        }
        
        workbook.close();
        return null;
    }
    
    // Sets the user's time for the given day
    public static void setTotalWorkTime(String id, int totalTime) throws IOException, BiffException{
        Workbook workbook = Workbook.getWorkbook(new File(EXCEL_LOCATION));
        
        Sheet sheet = workbook.getSheet(0);
        
        int currentColumn = getCurrentDayColumn(id, sheet);
        
        if(currentColumn == 0){
            writeNewDate(workbook);
        }
    }
    
    // Find the column of the current day. If one doesn't exist, returns 0
    private static int getCurrentDayColumn(String id, Sheet sheet){
        
        String[] currentDateArray = getCurrentDate();
        
        for(int currentColumn = DATES_START_COLUMN; currentColumn < sheet.getColumns(); currentColumn++){
            Cell cell = sheet.getCell(currentColumn, NAMES_ROW);
            String date = cell.getContents();
            String[] dateArray = date.split("/");
            
            if(Arrays.equals(dateArray, currentDateArray)){
                return currentColumn;
            }
        }
        return 0;
    }
    
    // Writes the current date onto the sheet
    private static void writeNewDate(Workbook workbook) throws IOException{
        try {
            WritableWorkbook writeBook = Workbook.createWorkbook(new File(EXCEL_LOCATION), workbook);
            WritableSheet sheet = writeBook.getSheet(0);
            
            //WritableCell cell = sheet.getWritableCell(sheet.getColumns(), NAMES_ROW);
            
            Label label = new Label(sheet.getColumns(), NAMES_ROW, getCurrentDateString());
            
            sheet.addCell(label);
            
            writeBook.write();
            writeBook.close();
        } catch (WriteException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Returns an array with the current date in month, day, year form
    private static String[] getCurrentDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        
        String[] dateArray = new String[3];
        
        dateArray[0] = Integer.toString(calendar.get(GregorianCalendar.MONTH) + 1);
        dateArray[1] = Integer.toString(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        dateArray[2] = Integer.toString(calendar.get(GregorianCalendar.YEAR));
        
        return dateArray;
    }
    
    // Returns a string of the current date
    private static String getCurrentDateString(){
        GregorianCalendar calendar = new GregorianCalendar();

        int month = calendar.get(GregorianCalendar.MONTH) + 1;
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int year = calendar.get(GregorianCalendar.YEAR);
        
        return month + "/" + day + "/" + year;
    }
}
