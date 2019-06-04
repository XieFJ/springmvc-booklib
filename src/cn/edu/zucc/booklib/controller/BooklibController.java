package cn.edu.zucc.booklib.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

@Controller
public class BooklibController {
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
	
	@RequestMapping(value="/index")
    public String handleRequest(HttpServletRequest request) throws Exception {
		ServletContext context = request.getSession().getServletContext();
		ctx = (ApplicationContext) context.getAttribute("applicationContext");
		request.setAttribute("msg", "hello world");
    	bookTypeService.addBookType("科幻a","sd");
//    	bookTypeService.modifyBookType(21, "科技");
//    	bookTypeService.loadBookTypes();
//    	System.out.println(bookTypeService.loadBookTypes().get(0).getBooktypeName());
//    	bookTypeService.deleteBookType(21);
		return "test";
	}

}
