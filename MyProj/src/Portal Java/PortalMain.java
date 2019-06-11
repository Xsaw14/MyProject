import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class PortalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataFormatter dataform = new DataFormatter();
			String filePath = args[0];
			
			File mainExcelFile = new File(filePath);
			FileInputStream mainExcelFileFIS = new FileInputStream(mainExcelFile);
			HSSFWorkbook mainWorkBook = new HSSFWorkbook(mainExcelFileFIS);
			HSSFSheet mainSheet = mainWorkBook.getSheet("Requirements");
			String monthToUpload = dataform.formatCellValue(mainSheet.getRow(0).getCell(1));
			int noOfMetrics = Integer.parseInt(dataform.formatCellValue(mainSheet.getRow(1).getCell(1)));
			String metricQuery = dataform.formatCellValue(mainSheet.getRow(2).getCell(1));
			String date = dataform.formatCellValue(mainSheet.getRow(3).getCell(1));
			String connection = dataform.formatCellValue(mainSheet.getRow(4).getCell(1));
			String userID = dataform.formatCellValue(mainSheet.getRow(5).getCell(1));
			
			
			GetProjectNames objGetProjectNames = new GetProjectNames();
			GetAccountNames objGetAccountNames = new GetAccountNames();
			GetCellIndexForGivenMonth objGetCellIndexForGivenMonth = new GetCellIndexForGivenMonth();
			GetMetricValue objGetMetricValue = new GetMetricValue();
			MysqlCon objMysqlCon = new MysqlCon();
			GetSqlTableNameForExceName objGetSqlTableNameForExceName = new GetSqlTableNameForExceName();
			String accountNames[] = objGetAccountNames.getAccountNames(mainWorkBook);
			for (int i = 0; i < accountNames.length; i++) {
				HSSFSheet sheet = mainWorkBook.getSheet(accountNames[i]);
				String projectNames[] = objGetProjectNames.getProjectNames(sheet);
				int reqYearRowIndex = objGetCellIndexForGivenMonth.getCellIndexForGivenMonth(sheet, monthToUpload);
				System.out.println("********************************************************");
				System.out.println("Uploading for Account = " + accountNames[i]);
				String sqlTablename = objGetSqlTableNameForExceName.getSqlTableNameForExceName(accountNames[i],filePath);
				for (int j = 0; j < projectNames.length; j++) {
					System.out.println("Uploading for project = " + projectNames[j]);
					String metricValues = objGetMetricValue.getMetricsValue(sheet, reqYearRowIndex, projectNames[j],
							projectNames, noOfMetrics);
					objMysqlCon.returnLastSINumberAndAccountNameFromDB(sqlTablename, projectNames[j], metricValues, metricQuery,date,connection,userID,args[1]);//passWord = args[1];
				}
				System.out.println("********************************************************");
			}
			System.out.println(monthToUpload+" data has been uploaded successfully!!! :)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
