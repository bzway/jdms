package cn.zhumingwu.dms.dao.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.zhumingwu.dms.domain.User;

@Mapper
public interface UserMapper  
{
	@Select("select * from user where userName like #{name}")
	List<User> likeName(String name);

	@Select("select * from user where id = #{id}")
	User getById(int id);

	@Select("select username from user where id = #{id}")
	String getNameById(int id);

}
