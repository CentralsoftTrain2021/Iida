package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EmployeesVo;

public class EmployeesDao
{
	private Connection con;

	private static final String SELECT_EMPLOYEE_SQL =
		"select "
		+" EMPLOYEEID"
		+",EMPLOYEENAME"
		+",HEIGHT"
		+",EMAIL"
		+",WEIGHT"
		+",HIREFISCALYEAR"
		+",BIRTHDAY"
		+",BLOODTYPE"
		+" from"
		+" EMPLOYEES"
		+" where"
		+" EMPLOYEEID=?";

	private static final String SELECT_ALL_EMPLOYEE_SQL =
			"select "
			+" EMPLOYEEID"
			+",EMPLOYEENAME"
			+",HEIGHT"
			+",EMAIL"
			+",WEIGHT"
			+",HIREFISCALYEAR"
			+",BIRTHDAY"
			+",BLOODTYPE"
			+" from"
			+" EMPLOYEES";


	public EmployeesDao(Connection con)
	{
		super();
		this.con = con;
	}

	//------------------------------
	public EmployeesVo getEmployee( int id) throws SQLException
	{
		EmployeesVo em = new EmployeesVo();

		/*Statementの作成*/
		try( PreparedStatement stmt= con.prepareStatement( SELECT_EMPLOYEE_SQL ) )
		{
			stmt.setInt( 1, id );

			/*ｓｑｌ実行*/
			try( ResultSet rset = stmt.executeQuery() )
			{
				/*取得したデータを表示します。*/
				while( rset.next() )
				{
					//em.setEmployeeid(       rset.getInt("EMPLOYEEID"));
					em.setEmployeeid(		rset.getInt(1)		);
					em.setEmployeename(		rset.getString(2)	);
					em.setHeight(			rset.getBigDecimal(3));
					em.setEmail(			rset.getString(4)	);
					em.setWeight(			rset.getBigDecimal(5));
					em.setHirefiscalyear(	rset.getInt(6)		);
					em.setBirthday(			rset.getDate(7)		);
					em.setBloodtype(		rset.getString(4)	);
				}
			}
		}

		return em;
	}

	//------------------------------
	// すべての従業員データを取得する
	public ArrayList<EmployeesVo> getAllEmployees() throws SQLException
	{
		ArrayList<EmployeesVo> ret  = new ArrayList<EmployeesVo>();

		/*Statementの作成*/
		try( PreparedStatement stmt= con.prepareStatement( SELECT_ALL_EMPLOYEE_SQL ) )
		{
			/*ｓｑｌ実行*/
			try( ResultSet rset = stmt.executeQuery() )
			{
				/*取得したデータを表示します。*/
				while( rset.next() )
				{
					EmployeesVo em = new EmployeesVo();

					em.setEmployeeid(		rset.getInt(1)		);
					em.setEmployeename(		rset.getString(2)	);
					em.setHeight(			rset.getBigDecimal(3));
					em.setEmail(			rset.getString(4)	);
					em.setWeight(			rset.getBigDecimal(5));
					em.setHirefiscalyear(	rset.getInt(6)		);
					em.setBirthday(			rset.getDate(7)		);
					em.setBloodtype(		rset.getString(4)	);

					ret.add(em);
				}
			}
		}

		return ret;
	}
}
