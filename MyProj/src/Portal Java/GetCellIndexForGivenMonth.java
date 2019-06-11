import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class GetCellIndexForGivenMonth {

	public int getCellIndexForGivenMonth(HSSFSheet sheet, String month){
		DataFormatter dataform = new DataFormatter();
		int cellValue = 0;
		Iterator<Cell> cellIt = sheet.getRow(2).cellIterator();
		try{
		while(cellIt.hasNext()){
			++cellValue;
			if(dataform.formatCellValue(cellIt.next()).equals(month)){
				break;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cellValue;
	}
}
