package edu.nf.servlet;

import com.google.gson.Gson;
import edu.nf.dao.CityDao;
import edu.nf.entity.City;
import edu.nf.entity.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 洒度
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagenum=Integer.parseInt(req.getParameter("pageNum"));
        int pagesize=Integer.parseInt(req.getParameter("pageSize"));
        PageBean page=new PageBean();
        page.setPageNum(pagenum);
        page.setPageSize(pagesize);
        CityDao dao=new CityDao();
        List<City> list=dao.listCity(page,null);
        resp.setContentType("application/json;charset=utf-8");
        String json=new Gson().toJson(list);
        resp.getWriter().println(json);
    }
}
