package cn.wxic.mobileinternet.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxic.mobileinternet.entiy.UploadFiles;
import cn.wxic.mobileinternet.util.UtilHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wxic.mobileinternet.entiy.Dashboard;
import cn.wxic.mobileinternet.entiy.ParkInfo;
import cn.wxic.mobileinternet.service.HomeService;

import cn.wxic.mobileinternet.util.ImageYasuo;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private HomeService homeService;
	private ParkInfo park;
	@Autowired
	private HomeController(HomeService homeService) {
		this.homeService = homeService;
	
	}
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}

	@RequestMapping(value="selectParkInfo")
	@ResponseBody
	public Map<String ,Object> selectParkInfo(HttpSession httpSession){
		try {
			List<ParkInfo> list=homeService.selectParkInfo();
			return UtilHelper.getInstance().success(list);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			return UtilHelper.getInstance().error(e.getCause());
		}

	}

	@RequestMapping(value="selectDashboard")
	@ResponseBody
public Map<String ,Object> selectDashboard(HttpSession httpSession){
		try {
			List<Dashboard> list=homeService.selectDashboard();
			return UtilHelper.getInstance().success(list);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			return UtilHelper.getInstance().error(e.getCause());
		}
	}
	

	 @RequestMapping("/uploadImages")
	 @ResponseBody
	    public  Map<String, Object> uploadImages(UploadFiles uploadFiles,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		 if(uploadFiles.getFiles()==null||uploadFiles.getFiles().length==0)
		 {
			 return UtilHelper.getInstance().error("请上传图片");
		 }else {
		 	try {
				for (int i = 0; i <uploadFiles.getFiles().length ; i++) {
					String fileName=UtilHelper.getInstance().generateFileName(uploadFiles.getFiles()[i].getOriginalFilename(),"IMG");
					String path = "D:/mobile/upload/imgyuantu/"+fileName;  //ԭͼĿ¼
					String path2= "D:/mobile/upload/img/"+fileName;//ѹ��Ŀ¼
					File destFile=new File(path);
					File destFile2 = new File(path2);
					// 检测是否存在目录
					if (!destFile.getParentFile().exists()) {
						destFile.getParentFile().mkdirs();
					}
					if (!destFile2.getParentFile().exists()) {
						destFile2.getParentFile().mkdirs();
					}
					uploadFiles.getFiles()[i].transferTo(destFile);

					ImageYasuo.compress(destFile, destFile2, 600, 1f);

				}
				return  UtilHelper.getInstance().success("上传图片成功");
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(),e);
				return UtilHelper.getInstance().error("上传图片失败"+e.getCause().toString().trim());
			}
		 }
	 }
}
