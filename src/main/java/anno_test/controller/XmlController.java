package anno_test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yourbatis.Dbs;

import anno_test.beans.Xml_bean;
import anno_test.maps.AnnoMap;
import anno_test.maps.XmlMap;

@Controller
@RequestMapping(value="/xml")
public class XmlController {

	@Autowired
	Dbs dbs;
	@Autowired
	AnnoMap amap;
	@Autowired
	XmlMap xm;
	
	//xml_test home
	@RequestMapping(value="home")
	public String getListXml(Model m) {
		//select 추가
		m.addAttribute("list", xm.getListXml());
		return "xml/home";
	}
	//xml_test join 
	@RequestMapping(value="join")
	public String join(Model m,Xml_bean x) {
		System.out.println("join1 : "+xm.join(x));
		m.addAttribute("list", xm.getListXml());
		return "xml/home";
	}
	//xml_test delete
	@RequestMapping(value="delete")
	public String delete(Model m,Xml_bean x) {
		System.out.println(xm.delete(x));
		m.addAttribute("list", xm.getListXml());
		return "xml/home";
	}
	//xml_test join2
	@RequestMapping(value="join2")
	public String join2(Model m,Xml_bean x) {
		System.out.println("join2 : "+xm.join2(x));
		m.addAttribute("list", xm.getListXml());
		return "xml/home";
	}
	//xml_test update
	@RequestMapping(value="update")
	public String update(Model m,Xml_bean x) {
	System.out.println("update : "+xm.update(x));
	m.addAttribute("list", xm.getListXml());
	return "xml/home";
	}
}
