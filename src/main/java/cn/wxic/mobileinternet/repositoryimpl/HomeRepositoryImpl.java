package cn.wxic.mobileinternet.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.wxic.mobileinternet.entiy.Dashboard;
import cn.wxic.mobileinternet.entiy.ParkInfo;
import cn.wxic.mobileinternet.repository.HomeRepository;
@Repository
public class HomeRepositoryImpl implements HomeRepository {
	@Autowired
	private JdbcTemplate jdbc;
	@Override
	public List<ParkInfo> selectParkInfo() {
		List<ParkInfo> list;
		String sql="select * from parkinfo";
		list=jdbc.query(sql, new BeanPropertyRowMapper<ParkInfo>(ParkInfo.class));
		return list;
	}
	@Override
	public List<Dashboard> selectDashboard() {
		List<Dashboard> list;
		String sql="select * from dashboard";
		list=jdbc.query(sql, new BeanPropertyRowMapper<Dashboard>(Dashboard.class));
		return list;
	}

}
