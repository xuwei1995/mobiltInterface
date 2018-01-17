package cn.wxic.mobileinternet.repository;

import java.util.List;

import cn.wxic.mobileinternet.entiy.Dashboard;
import cn.wxic.mobileinternet.entiy.ParkInfo;

public interface HomeRepository {

	List<ParkInfo> selectParkInfo();

	List<Dashboard> selectDashboard();

}
