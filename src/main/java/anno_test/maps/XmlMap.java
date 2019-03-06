package anno_test.maps;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import anno_test.beans.Xml_bean;


@Mapper
public interface XmlMap {

	public List<HashMap<String, String>> getListXml();
	
	public int join(Xml_bean x);
	
	public int delete (Xml_bean x);
	
	public int join2 (Xml_bean x);
	
	public int update(Xml_bean x);
}
