package com.chan.old.common;

import com.chan.old.vo.DuserVO;

public interface DuserService {
	public int insertDuser(DuserVO vo);
	public int deleteDuser(int sid);
	public int updateDuser(DuserVO vo);
	public DuserVO getDuser(DuserVO vo);
}
