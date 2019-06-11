import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetSqlTableNameForExceName {

	public String getSqlTableNameForExceName(String accountname, String excelPath){
		String nameSQL = new String();
		try{
		File excelFile = new File(excelPath);
		FileInputStream fis = new FileInputStream(excelFile);
		HSSFWorkbook excelWorkbook = new HSSFWorkbook(fis);
		HSSFSheet excelSheet = excelWorkbook.getSheet("DB_Names");
		int numberOfRows = excelSheet.getPhysicalNumberOfRows();
		for(int i=1;i<numberOfRows;i++){
			String excelVal = excelSheet.getRow(i).getCell(0).getStringCellValue();
			if(excelVal.equals(accountname)){
				nameSQL = excelSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return nameSQL;
	}
}
