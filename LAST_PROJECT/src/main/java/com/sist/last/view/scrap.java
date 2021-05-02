package com.sist.last.view;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.last.service.HousesServiceImpl;
import com.sist.last.service.ImageServiceImpl;
import com.sist.last.vo.Houses;
import com.sist.last.vo.Image;


@Controller
public class scrap {
	
	final Logger LOG = LoggerFactory.getLogger(scrap.class);
	
	@Autowired
	HousesServiceImpl housesService;
	
	@Autowired
	ImageServiceImpl imageService;
	
	
	@RequestMapping(value="houses/houses_detail.do") //url에 이 경로치면 
	public String housesDetail(Model model, Houses houses) throws Exception {
		LOG.debug("=================");
		LOG.debug("=housesDetail()=");
		LOG.debug("=================");
		
		Houses outVO = (Houses) this.housesService.doSelectOne(houses);
		model.addAttribute("vo", outVO);

//		Image imageVO = new Image();
//		imageVO.setImgId(houses.getImgId());
//
//		List<Image> image = (List<Image>) this.imageService.doRetrieve(imageVO);
//		
//		model.addAttribute("image",image);
		
		
		return "houses/Community_Detail_Info";              //이 페이지 띄워주는거 같음!!!!
	}
	
	@RequestMapping(value="mypage/scrap_list.do")
	public String scrapView() {
		LOG.debug("=================");
		LOG.debug("=scrapView()=");
		LOG.debug("=================");
		
		return "mypage/Member_ScrapBook";           
	}
}
