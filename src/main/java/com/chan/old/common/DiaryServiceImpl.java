package com.chan.old.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chan.old.dao.DiaryDAO;
import com.chan.old.vo.DiaryVO;

@Service
public class DiaryServiceImpl implements DiaryService {
	
	@Autowired
	DiaryDAO diaryDAO;
	
	@Override
	public int insertDiary(DiaryVO vo) {
		return diaryDAO.insertDiary(vo);
	}
	
	@Override
	public int deleteDiary(int seq) {
		return diaryDAO.deleteDiary(seq);
	}
	
	@Override
	public int updateDiary(DiaryVO vo) {
		return diaryDAO.updateDiary(vo);
	}
	
	@Override
	public DiaryVO getDiary(int seq) {
		return diaryDAO.getDiary(seq);
	}
	
	@Override
	public List<DiaryVO> getDiaryList() {
		return diaryDAO.getDiaryList();
	}
}
