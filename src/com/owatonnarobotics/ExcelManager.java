package com.owatonnarobotics;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Random;
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
import jxl.write.Number;

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
    private static final int GRADE_COLUMN = 3;
    private static final int TEAM_COLUMN = 4;
    private static final int PHONE_COLUMN = 5;
    private static final int EMAIL_COLUMN = 6;
    private static final int TOTAL_TIME_COLUMN = 8;
    private static final int DATES_START_COLUMN = 11;
    
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
                String grade = sheet.getCell(GRADE_COLUMN, currentRow).getContents();
                String team = sheet.getCell(TEAM_COLUMN, currentRow).getContents();
                String phone = sheet.getCell(PHONE_COLUMN, currentRow).getContents();
                String email = sheet.getCell(EMAIL_COLUMN, currentRow).getContents();
                int totalTime = Integer.parseInt(sheet.getCell(TOTAL_TIME_COLUMN, currentRow).getContents());
                
                workbook.close();
                return new User(fName, lName, id, grade, team, phone, email, totalTime);
            }
        }
        
        workbook.close();
        return null;
    }
    
    // Writes the user to the Excel Document
    public static void writeUser(User user) throws IOException, BiffException, WriteException{
        Workbook workbook = Workbook.getWorkbook(new File(EXCEL_LOCATION));
        WritableWorkbook writeBook = Workbook.createWorkbook(new File(EXCEL_LOCATION), workbook);
        
        Sheet sheet = workbook.getSheet(0);
        int row = sheet.getRows();
        
        writeCellNumber(ID_COLUMN, row, Integer.parseInt(user.getId()), writeBook);
        writeCellLabel(FIRST_NAME_COLUMN, row, user.getFirstName(), writeBook);
        writeCellLabel(LAST_NAME_COLUMN, row, user.getLastName(), writeBook);
        writeCellNumber(GRADE_COLUMN, row, Integer.parseInt(user.getGrade()), writeBook);
        writeCellLabel(TEAM_COLUMN, row, user.getTeam(), writeBook);
        writeCellLabel(PHONE_COLUMN, row, user.getPhone(), writeBook);
        writeCellLabel(EMAIL_COLUMN, row, user.getEmail(), writeBook);
        writeCellNumber(TOTAL_TIME_COLUMN, row, 0, writeBook);
        
        writeBook.write();
        writeBook.close();
        workbook.close();
    }
    
    // Returns a random open 3 digit id
    public static String getFreeID() throws IOException, BiffException{
        
        Random rand = new Random();
        
        String randomID = User.randomID(rand);
        
        while(getUser(randomID) != null){
            randomID = User.randomID(rand);
        }
        
        return randomID;
    }
    
    // Sets the user's time for the given day
    public static void setTotalWorkTime(User user, int totalTime) throws IOException, BiffException, WriteException{
        Workbook workbook = Workbook.getWorkbook(new File(EXCEL_LOCATION));
        WritableWorkbook writeBook = Workbook.createWorkbook(new File(EXCEL_LOCATION), workbook);
        
        Sheet sheet = workbook.getSheet(0);
        
        int currentColumn = getSetCurrentDayColumn(sheet, writeBook, getCurrentDateString());
        
        int currentRow = getUserRow(user.getId(), sheet);
        
        // Time that we added today, used for totalTime later
        int totalTodayTime = totalTime;
        
        // Adds the time the user has so far
        totalTodayTime += user.getTotalTime();
        
        // Sets today's time
        try{
            Cell cell = sheet.getCell(currentColumn, currentRow);
            int currentWorkTime = Integer.parseInt(cell.getContents());
            totalTime += currentWorkTime;
        } catch(Exception e){
            // Not a number, continue on
        }
        
        // Adds onto the total time column
        writeCellNumber(TOTAL_TIME_COLUMN, currentRow, totalTodayTime, writeBook);
        // Writes the total amount of minutes today
        writeCellNumber(currentColumn, currentRow, totalTime, writeBook);
        
        writeBook.write();
        writeBook.close();
        workbook.close();
    }
    
    // Finds the row that the user is in
    private static int getUserRow(String id, Sheet sheet){
        for(int currentRow = START_ROW; currentRow < sheet.getRows(); currentRow++){
            Cell cell = sheet.getCell(ID_COLUMN, currentRow);
            if(cell.getContents().equals(id)){
                return currentRow;
            }
        }
        return 0;
    }
    
    // Find the column of the current day, if one doesn't exist set last empty one to date
    private static int getSetCurrentDayColumn(Sheet sheet, WritableWorkbook writeBook, String todayDate) throws IOException{
        
        String[] currentDateArray = getCurrentDate();
        
        for(int currentColumn = DATES_START_COLUMN; currentColumn < sheet.getColumns(); currentColumn++){
            
            Cell cell = sheet.getCell(currentColumn, NAMES_ROW);
            String date = cell.getContents();
            String[] dateArray = date.split("/");
            
            if(date.equals("")){
                writeCellLabel(currentColumn, NAMES_ROW, todayDate, writeBook);
                return currentColumn;
            }
            
            if(Arrays.equals(dateArray, currentDateArray)){
                return currentColumn;
            }
        }
        writeCellLabel(sheet.getColumns() + 1, NAMES_ROW, todayDate, writeBook);
        return sheet.getColumns() + 1;
    }
    
    // Writes the cell with text at the row and column specified 
    private static void writeCellLabel(int column, int row, String text, WritableWorkbook writeBook) throws IOException{
        try {
            WritableSheet sheet = writeBook.getSheet(0);
            
            Label label = new Label(column, row, text);
            
            sheet.addCell(label);
            
        } catch (WriteException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Writes the cell with a number at the row and column specified 
    private static void writeCellNumber(int column, int row, double number, WritableWorkbook writeBook) throws IOException{
        try {
            WritableSheet sheet = writeBook.getSheet(0);
            Number num = new Number(column, row, number);
            
            sheet.addCell(num);
            
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
