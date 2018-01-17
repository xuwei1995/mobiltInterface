package cn.wxic.mobileinternet.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wxic.mobileinternet.entiy.Dashboard;
import cn.wxic.mobileinternet.entiy.ParkInfo;
import cn.wxic.mobileinternet.repository.HomeRepository;
import cn.wxic.mobileinternet.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService{
  @Autowired HomeRepository homeRepository;
	@Override
	public List<ParkInfo> selectParkInfo() {
		List<ParkInfo> list=homeRepository.selectParkInfo();
		return list;
	}
	@Override
	public List<Dashboard> selectDashboard() {
		List<Dashboard> list=homeRepository.selectDashboard();
		return list;
	}

}
