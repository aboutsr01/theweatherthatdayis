package usingAPI.weather.theweatherthatdayis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usingAPI.weather.theweatherthatdayis.model.dao.ViewDao;

@Service("vService")
public class ViewServiceImpl implements ViewService{
	@Autowired
	private ViewDao vDao;
}
