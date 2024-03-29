package com.kakaopay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.model.NoDealCustomerModel;
import com.kakaopay.model.RankYearSumAmtModel;
import com.kakaopay.service.AnctDataInfoService;

@RestController
public class AnctDataInfoController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)	// URL 주소 = root
	public String login() {
		return "접속완료";
	}
	
	@Autowired
	AnctDataInfoService anctDataInfoService;
	
	@RequestMapping(value="/rankYearSumAmt/{year}", method = RequestMethod.GET)
	public List<RankYearSumAmtModel> srchRankYearSumAmt(@PathVariable String year) throws Exception {
		// http://localhost:9000/rankYearSumAmt/'2018','2019'
		return anctDataInfoService.selectRankYearSumAmt(year);	// 연도별 max 합계 금액 조회
	}
	
	@RequestMapping(value="/noDealCustomer/{year}", method = RequestMethod.GET)
	public List<NoDealCustomerModel> srchNodealCustomer(@PathVariable String year) throws Exception {
		// http://localhost:9000/noDealCustomer/'2018','2019'
		return anctDataInfoService.selectNoDealCustomer(year);	// 거래가 없는 고객 조회
	}
	
	@RequestMapping(value="/rankYearBrAmt/{year}")
	public String srchRankYearBrAmt(@PathVariable List<String> year) throws Exception {
		// http://localhost:9000/rankYearBrAmt/2019, 2018
		return anctDataInfoService.selectRankYearBrAmt(year);	// 연도별 관리점별 거래금액 합계 구하여 큰 순서로 출력
	}
	
	@RequestMapping(value="/brSumAmt", method = RequestMethod.POST)
	public Map<String, String> srchBrSumAmt(@RequestBody Map<String, String> map) throws Exception {
		// http://localhost:9000/brSumAmt/
		// postman 이용하여 json 데이터 전송
		return anctDataInfoService.selectBrSumAmt(map);			// 부점 거래금액 합계 조회
	}

}
