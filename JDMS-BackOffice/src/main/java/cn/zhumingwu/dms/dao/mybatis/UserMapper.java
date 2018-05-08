package cn.zhumingwu.dms.dao.mybatis;

import cn.zhumingwu.dms.dao.MyMapper;
import cn.zhumingwu.dms.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper // extends MyMapper<User>
{
	@Select("select * from user where userName like #{name}")
	List<User> likeName(String name);

	@Select("select * from user where id = #{id}")
	User getById(int id);

	@Select("select username from user where id = #{id}")
	String getNameById(int id);

}