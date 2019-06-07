package cn.edu.zucc.booklib.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.zucc.booklib.bookshelf.Bookshelf;
import cn.edu.zucc.booklib.databean.BeanBook;
import cn.edu.zucc.booklib.databean.BeanDetail;
import cn.edu.zucc.booklib.databean.BeanLendRecord;
import cn.edu.zucc.booklib.databean.BeanReader;
import cn.edu.zucc.booklib.databean.BeanReaderType;
import cn.edu.zucc.booklib.databean.BeanSystemUser;
import cn.edu.zucc.booklib.service.BookService;
import cn.edu.zucc.booklib.service.BookTypeService;
import cn.edu.zucc.booklib.service.DetailService;
import cn.edu.zucc.booklib.service.LendRecordService;
import cn.edu.zucc.booklib.service.ReaderService;
import cn.edu.zucc.booklib.service.ReaderTypeService;
import cn.edu.zucc.booklib.service.UserService;
import cn.edu.zucc.booklib.service.impl.BookServiceImpl;

@Controller
public class ShowBookshelfController {
	private ApplicationContext ctx;
	
	@Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private LendRecordService lendRecordService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private ReaderTypeService readerTypeService;
    @Autowired
    private UserService userService;
	
	@RequestMapping(value="/showBooks")
    public String handleRequest(HttpServletRequest request) throws Exception {
		ServletContext context = request.getSession().getServletContext();
		ctx = (ApplicationContext) context.getAttribute("applicationContext");
		HttpSession session = request.getSession(true);
        Bookshelf bookshelf = (Bookshelf) session.getAttribute("bookshelf");
        if (bookshelf == null) {
            bookshelf = new Bookshelf();
            session.setAttribute("bookshelf", bookshelf);
        }
        int bookId = request.getParameter("Remove");
        if (bookId>0) {
            bookshelf.remove(bookId);
        }
        bookId=request.getParameter("Add");
        if(bookId>0){
        	BookServiceImpl bs = (BookServiceImpl)ctx.getBean("bookServiceImpl");
            BeanBook book = bs.findBookById(bookId);
            bookshelf.add(bookId, book);
        }
		
		return "test";
	}

}
