package com.kakaopay.dao;

import java.util.List;

import com.kakaopay.model.BrSumAmtModel;
import com.kakaopay.model.NoDealCustomerModel;
import com.kakaopay.model.RankYearBrAmtModel;
import com.kakaopay.model.RankYearSumAmtModel;

public interface AnctDataInfoDao {
	
	List<RankYearSumAmtModel> selectRankYearSumAmt(String year) throws Exception;	// 연도별 max 합계 금액 조회
	
	List<NoDealCustomerModel> selectNoDealCustomer(String year) throws Exception;	// 거래가 없는 고객 조회
	
	List<RankYearBrAmtModel> selectRankYearBrAmt(String year) throws Exception;		// 거래가 없는 고객 조회
	
	BrSumAmtModel selectBrSumAmt(String year) throws Exception;						// 부점 거래금액 합계 조회
	
}
