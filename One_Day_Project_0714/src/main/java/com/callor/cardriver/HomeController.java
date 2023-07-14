package com.callor.cardriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.cardriver.dao.CdDao;
import com.callor.cardriver.models.CdDto;
import com.callor.cardriver.service.CdService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	protected final CdService cdService;
	private final CdDao cdDao;
	public HomeController(CdService cdService, CdDao cdDao) {
		super();
		this.cdService = cdService;
		this.cdDao = cdDao;
	}

	@ModelAttribute
	// 데이터 등록시 출발일자 출발시간 현재시각 자동등록.
	public CdDto cdDto() {
		CdDto cdDto = new CdDto();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		cdDto.setCd_stdate(dateFormat.format(date));
		cdDto.setCd_sttime(timeFormat.format(date));
		return cdDto;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Local local, Model model) {
		List<CdDto> cdList = cdDao.selectAll();
		CdDto cdDto = null;
		int count = cdDao.lastSelectCheck();
		if(count > 0) {
			cdDto = cdDao.lastSelect();
			log.debug("UPDATE DATA : {}",cdDto);
			model.addAttribute("CD", "UPDATE");
		}else {
			model.addAttribute("CD", "INSERT");
		}
		model.addAttribute("CD_UPDATE",cdDto);
		model.addAttribute("CD_LIST",cdList);
		return "home";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(CdDto cdDto, Model model) {
		log.debug("S_DATA : {} ", cdDto);
		int result = cdDao.insertCd(cdDto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CdDto cdDto, Model model) {
		log.debug("S_DATA : {} ", cdDto);
		int result = cdDao.updateCd(cdDto);
		return "redirect:/";
	}
}
