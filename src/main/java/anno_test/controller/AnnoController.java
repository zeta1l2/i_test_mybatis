package anno_test.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourbatis.Dbs;
import com.yourbatis.Dbs2;

import anno_test.beans.T_page_bean;
import anno_test.beans.T_test_bean;
import anno_test.maps.AnnoMap;


@Controller
public class AnnoController {

	@Autowired
	Dbs dbs;
	@Autowired
	Dbs2 dbs2;
	BCryptPasswordEncoder bp=new BCryptPasswordEncoder();
	PasswordEncoder pe=bp;
	@Autowired
	AnnoMap amap;
	
	//테스트
	@RequestMapping(value = { "/get_list_xml" }, method = RequestMethod.GET)
	public String getListXml(Model m) {
		m.addAttribute("message",amap.getListXml());
		return "get_list";
	}
	
	//마이바티스 테스트
	@RequestMapping(value= {"/home2"}, method = RequestMethod.GET)
	public String homePage2(ModelMap m) {
		return "my_batis_home";
	}
	//회원가입 폼 이동
	@RequestMapping(value= {"/join2"}, method = RequestMethod.GET)
	public String joinPage2(ModelMap m) {
		return "join";
	}
	//회원가입
	@RequestMapping(value= {"/join2"}, method = RequestMethod.POST)
	public String do_join(ModelMap m,T_test_bean b) {
		b.setT_pw(pe.encode(b.getT_pw()));
		amap.setJoin(b);
		m.addAttribute("list", amap.getList());
		return "my_list2";
	}
	//회원 삭제
	@RequestMapping(value= {"/delete"},method=RequestMethod.GET)
	public String do_delete(ModelMap m,T_test_bean b) {
		amap.setDelete(b);
		m.addAttribute("list", amap.getList());
		return "my_list2";
	}
	//로그인 폼 이동
	@RequestMapping(value= {"/login2"},method=RequestMethod.GET)
	public String loginPage2(ModelMap m) {
		return "my_batis_home";
	}
	//로그인
		@RequestMapping(value= {"/login2"},method=RequestMethod.POST)
		public String do_login(ModelMap m,T_test_bean b,T_page_bean b1,HttpSession session) {
			String enpw=amap.setLogin(b).get("T_PW");
			if(pe.matches(b.getT_pw(), enpw)) {
				session.setAttribute("t_id", b.getT_id());
				b1.setPage(1);
				b1.setPage_proc(10);
				
				m.addAttribute("list", amap.getBoard(b1));
				m.addAttribute("pages", amap.getProc(10).get("CP"));
				return "board";
			}else {
				return "my_batis_home";
			}
		}
	//게시판 페이지
		@RequestMapping(value= {"/board"},method=RequestMethod.GET)
		public String do_login(ModelMap m,T_page_bean b) {
			b.setPage(1);
			b.setPage_proc(10);
			m.addAttribute("pages", amap.getProc(10).get("CP"));
			m.addAttribute("list", amap.getBoard(b));
			return "board";
		}
	//페이지 이동
		@RequestMapping(value= {"/page"},method=RequestMethod.GET)
		public String move_page(ModelMap m,T_page_bean b) {
			m.addAttribute("pages", amap.getProc(10).get("CP"));
			m.addAttribute("list", amap.getBoard(b));
			return "board";
		}
	//답글 작성 폼 이동
		@RequestMapping(value= {"/recomend/{q_num}"},method=RequestMethod.GET)
		public String write_comend(@PathVariable String q_num,ModelMap m) {
			m.addAttribute("q_num", q_num);
			return "write_board";
		}
	//마이바티스 테스트 end
	
	@RequestMapping(value= { "/", "/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap m) {
		System.out.println("homePage");
		m.addAttribute("message", "HI MESSAGE");
		return "home";
	}
	
	@RequestMapping(value= {"/test_hikari"}, method = RequestMethod.GET)
	public String testHikari(Model m) {
		ArrayList<HashMap<String, String>> list=dbs.selectListMap("SELECT * FROM z_user");
		m.addAttribute("list", list);
		
		return "test_hikari";
	}
	
	//선생님 db
	@RequestMapping(value= {"/test_yourbatis"}, method = RequestMethod.GET)
	public String testYourbatis(Model m) {
		ArrayList<HashMap<String, String>> list=dbs2.selectListMap("SELECT * FROM z_user");
		m.addAttribute("list", list);
		return "testYourbatis";
	}
	//연습장 insert
	@RequestMapping(value= {"join"},method=RequestMethod.POST)
	public String test_join(Model m,String t_id,String t_pw) {
		t_pw=pe.encode(t_pw);
		String sql
		=String.format("insert into t_test01 VALUES('%s','%s')",t_id,t_pw);
		dbs.executeUpdate(sql);
		
		ArrayList<HashMap<String, String>> list=dbs.selectListMap("select * from t_test01");
		m.addAttribute("list", list);
		return "my_list";
	}
	@RequestMapping(value= {"join"},method=RequestMethod.GET)
	public String test_list(Model m,String t_id,String t_pw) {
		ArrayList<HashMap<String, String>> list=dbs.selectListMap("select * from t_test01");
		m.addAttribute("list", list);
		return "my_list";
	}
	
}
