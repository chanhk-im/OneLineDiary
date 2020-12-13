package com.chan.old.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chan.old.dao.DuserDAO;
import com.chan.old.vo.DuserVO;

@Service
public class DuserServiceImpl implements DuserService {
	
	@Autowired
	DuserDAO duserDAO;
	
	@Override
	public int insertDuser(DuserVO vo) {
		if (duserDAO.getDuserById(vo.getUserid()) != null || duserDAO.getDuserByUsername(vo.getUsername()) != null) {
			return 2;
		}
		return duserDAO.insertDuser(vo);
	}
	
	@Override
	public int deleteDuser(int sid) {
		return duserDAO.deleteDuser(sid);
	}
	
	@Override
	public int updateDuser(DuserVO vo) {
		return duserDAO.updateDuser(vo);
	}
	
	@Override
	public DuserVO getDuser(DuserVO vo) {
		return duserDAO.getDuser(vo);
	}
}
