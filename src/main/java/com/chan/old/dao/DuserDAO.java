package com.chan.old.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.old.vo.DuserVO;

@Repository
public class DuserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertDuser(DuserVO vo) {
		int result = sqlSession.insert("Duser.insertDuser", vo);
		return result;
	}
	
	public int deleteDuser(int sid) {
		int result = sqlSession.delete("Duser.deleteDuser", sid);
		return result;
	}
	
	public int updateDuser(DuserVO vo) {
		int result = sqlSession.update("Duser.updateDuser", vo);
		return result;
	}
	
	public DuserVO getDuser(DuserVO vo) {
		return sqlSession.selectOne("Duser.getDuser", vo);
	}
	
	public DuserVO getDuserById(String id) {
		return sqlSession.selectOne("Duser.getDuserById", id);
	}
	
	public DuserVO getDuserByUsername(String username) {
		return sqlSession.selectOne("Duser.getDuserByUsername", username);
	}
}
