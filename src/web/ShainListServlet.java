package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ShainListBean;
import dao.EmployeesVo;

@WebServlet("/ShainListServlet")
public class ShainListServlet extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		//社員リストwoDBから取得　課題
		List<EmployeesVo> shainList = null;
		try {
			shainList = getEmployeesVoList();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		ShainListBean bean = new ShainListBean();

		bean.setMsg(			"社員リストを表示します");
		bean.setShainList( 		shainList );

		//セッションからログインユーザーを取得
		HttpSession session = request.getSession();
	    EmployeesVo emp  = (EmployeesVo)session.getAttribute("EmployeesVo");

	    bean.setLoginShainName(	emp.getEmployeename() );

		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/shainlist.jsp");
		disp.forward(request, response);
	}



	//DBから従業員を取得する
	private static List<EmployeesVo> getEmployeesVoList() throws ClassNotFoundException, SQLException
	{
		//List<EmployeesVo> empList = null;

		//ここにDBアクセス処理を作ってみましょう。　課題
		DBUtil db = new DBUtil();
		Connection c = null;
		c = db.getConnection();
		EmployeesDao dao = new EmployeesDao(c);

		ArrayList<EmployeesVo> empList;
		empList = dao.getAllEmployees();


		//仮実装　あとで消す
		/*empList = new ArrayList<EmployeesVo>();
		EmployeesVo e1 = new EmployeesVo();
		EmployeesVo e2 = new EmployeesVo();
		e1.setEmployeename("テスト1");
		e2.setEmployeename("テスト2");

		e1.setEmail("a@b");
		e2.setEmail("c@d");

		empList.add(e1);
		empList.add(e2);*/
		//仮実装終わり

		return empList;
	}


}
