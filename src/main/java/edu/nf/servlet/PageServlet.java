package edu.nf.servlet;


import com.google.gson.Gson;
import edu.nf.dao.CityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pagecount")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityDao dao=new CityDao();
        Double Count= dao.getPageCount(null)/10.0;
        Integer pageCount=(int)Math.ceil(Count);
        resp.setContentType("application/json;charset=utf-8");
        String json=new Gson().toJson(pageCount);
        resp.getWriter().println(json);
    }
}
