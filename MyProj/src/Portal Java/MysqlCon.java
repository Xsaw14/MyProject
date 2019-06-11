import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

class MysqlCon {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST", "root", "P@$$word");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select no from voya");
			TreeSet<Integer> ts = new TreeSet<>();
			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				ts.add(rs.getInt(1));
				
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void returnLastSINumberAndAccountNameFromDB(String sqlTablename, String projectNames, String metricValues, String metricQuery, String date, String connection, String userID, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(connection, userID, password);
			// here TEST is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select no from `"+sqlTablename+"`");
			TreeSet<Integer> ts = new TreeSet<>();
			while (rs.next()){
				ts.add(rs.getInt(1));
			}
			int last = ts.last();
			ResultSet rs1 = stmt.executeQuery("SELECT account_name from `"+sqlTablename+"` where no="+last+"");
			String accountName = new String();
			while (rs1.next()){
			accountName = rs1.getString(1);
			}
			int val = ts.last();
			val++;
			String query = "INSERT INTO `"+sqlTablename+"` (`no`, `project`, `date`, "+metricQuery+", `account_name`) VALUES ('"+val+"', '"+projectNames+"', '"+date+"', "+metricValues+" '"+accountName+"');";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
