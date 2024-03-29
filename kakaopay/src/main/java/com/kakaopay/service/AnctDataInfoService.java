package com.kakaopay.service;

import java.util.List;
import java.util.Map;

import com.kakaopay.model.NoDealCustomerModel;
import com.kakaopay.model.RankYearSumAmtModel;

public interface AnctDataInfoService {
	
	List<RankYearSumAmtModel> selectRankYearSumAmt(String year) throws Exception;	// 연도별 max 합계 금액 조회
	
	List<NoDealCustomerModel> selectNoDealCustomer(String year) throws Exception;	// 거래가 없는 고객 조회
	
	String selectRankYearBrAmt(List<String> year) throws Exception;					// 연도별 부점별 합계금액 랭크
	
	Map<String, String> selectBrSumAmt(Map<String, String> map) throws Exception;	// 부점 거래금액 합계 조회	
}
