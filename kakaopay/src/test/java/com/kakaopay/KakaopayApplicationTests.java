package com.kakaopay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kakaopay.model.NoDealCustomerModel;
import com.kakaopay.model.RankYearSumAmtModel;
import com.kakaopay.service.AnctDataInfoServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KakaopayApplicationTests {
	
	@Autowired
	private AnctDataInfoServiceImpl anctDataInfoServiceImpl;
	
    @Test
    public void test01() throws Exception {
    	// 연도별 max 합계 금액 조회
    	List <RankYearSumAmtModel> rankYearSumAmtModel = anctDataInfoServiceImpl.selectRankYearSumAmt("'2018'");
    }
    
    @Test
    public void test02() throws Exception {
    	// 거래가 없는 고객 조회
    	List<NoDealCustomerModel> noDealCustomerModel = anctDataInfoServiceImpl.selectNoDealCustomer("'2018'");
    }
    
    @Test
    public void test03() throws Exception {
    	// 연도별 부점별 합계금액 랭크
    	List<String> year = new ArrayList<String>();
    	year.add("2018");
    	year.add("2019");
    	String result = anctDataInfoServiceImpl.selectRankYearBrAmt(year);
    }
    
    @Test
    public void test04() throws Exception {
    	// 부점 거래금액 합계 조회
    	Map<String, String> reqMap = new HashMap<String, String>();
    	reqMap.put("brName", "판교점");
    	Map<String, String> map = anctDataInfoServiceImpl.selectBrSumAmt(reqMap);
    }

}
