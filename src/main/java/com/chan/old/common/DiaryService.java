package com.chan.old.common;

import java.util.List;

import com.chan.old.vo.DiaryVO;

public interface DiaryService {
	public int insertDiary(DiaryVO vo);
	public int deleteDiary(int seq);
	public int updateDiary(DiaryVO vo);
	public DiaryVO getDiary(int seq);
	public List<DiaryVO> getDiaryList();
}
