package anno_test.maps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import anno_test.beans.T_page_bean;
import anno_test.beans.T_test_bean;

@Mapper
public interface AnnoMap {
	
	public List<HashMap<String, String>> getListXml();
	/*
	//1. 매개변수 있는 SELECT
	@Select("SELECT * FROM t_test01 WHERE T_ID=#{tid}")
	public ArrayList<HashMap<String, String>> getListWhere(String tid);
	
	
	//2. 업데이트
	@Select("UPDATE T_TEST02 SET T_NAME=#{t_name} WHERE T_ID=#{t_id}")
	public HashMap<String, Object> setUpdate(HashMap<String, Object> mm);
	*/
	//회원가입
	@Insert(value="{CALL t_join(#{t_id,mode=IN,jdbcType=NVARCHAR},#{t_pw,mode=IN,jdbcType=VARCHAR},#{t_name,mode=IN,jdbcType=VARCHAR})}")
	@Options(statementType=StatementType.CALLABLE)
	public boolean setJoin(T_test_bean b);

	//1. 리스트
	@Select("select * from t_test02")
	public ArrayList<HashMap<String, String>> getList();
	
	//회원 삭제
	@Select("DELETE FROM t_test02 WHERE t_id=#{t_id}")
	public void setDelete(T_test_bean b);
	
	//로그인
	@Select("select * from t_test02 where t_id=#{t_id}")
	public HashMap<String, String> setLogin(T_test_bean b);
	
	//댓글창
	@Select("SELECT Q_NUM,Q_TITLE,Q_DATE,Q_IP,Q_MARGIN FROM V_t_qna WHERE F_PAGE(R, #{page}, #{page_proc}) = 1")
	public ArrayList<HashMap<String, String>> getBoard(T_page_bean b);
	//전체 페이지
	@Select("SELECT V_page_1(#{page_proc}) CP FROM DUAL")
	public HashMap<String, String> getProc(int page_proc);
}
