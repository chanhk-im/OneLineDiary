package com.chan.old.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.old.vo.DiaryVO;

@Repository
public class DiaryDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertDiary(DiaryVO vo) {
		int result = sqlSession.insert("Diary.insertDiary", vo);
		return result;
	}
	
	public int deleteDiary(int seq) {
		int result = sqlSession.delete("Diary.deleteDiary", seq);
		return result;
	}
	
	public int updateDiary(DiaryVO vo) {
		int result = sqlSession.update("Diary.updateDiary", vo);
		return result;
	}
	
	public DiaryVO getDiary(int seq) {
		DiaryVO result = sqlSession.selectOne("Diary.getDiary", seq);
		return result;
	}
	
	public List<DiaryVO> getDiaryList() {
		List<DiaryVO> result = sqlSession.selectList("Diary.getDiaryList");
		return result;
	}
}
