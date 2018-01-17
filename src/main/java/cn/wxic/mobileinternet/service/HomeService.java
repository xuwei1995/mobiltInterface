package cn.wxic.mobileinternet.service;

import java.util.List;

import cn.wxic.mobileinternet.entiy.Dashboard;
import cn.wxic.mobileinternet.entiy.ParkInfo;

public interface HomeService {

	List<ParkInfo> selectParkInfo();

	List<Dashboard> selectDashboard();

}
