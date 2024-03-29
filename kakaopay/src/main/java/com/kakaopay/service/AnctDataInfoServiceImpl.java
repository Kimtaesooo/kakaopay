package com.kakaopay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.kakaopay.dao.AnctDataInfoDao;
import com.kakaopay.model.BrSumAmtModel;
import com.kakaopay.model.NoDealCustomerModel;
import com.kakaopay.model.RankYearBrAmtModel;
import com.kakaopay.model.RankYearSumAmtModel;

@Service
public class AnctDataInfoServiceImpl implements AnctDataInfoService {
	
	@Autowired
    private AnctDataInfoDao anctDataInfoDao;

	@Override
	public List<RankYearSumAmtModel> selectRankYearSumAmt(String year) throws Exception {
		
		// 연도별 max 합계 금액 조회
		return anctDataInfoDao.selectRankYearSumAmt(year);
	}

	@Override
	public List<NoDealCustomerModel> selectNoDealCustomer(String year) throws Exception {
		
		// 거래가 없는 고객 조회
		return anctDataInfoDao.selectNoDealCustomer(year);
	}

	@Override
	public String selectRankYearBrAmt(List<String> year) throws Exception {
		
		// 연도별 부점별 합계금액 랭크
		String[] resultYear = new String[year.size()];
		
		List <JSONObject> list = new ArrayList <JSONObject>();
		
		for(int i=0; i < year.size(); i++) {
			resultYear[i] = year.get(i);
			List<RankYearBrAmtModel> resultRankYearBrAmtModel = new ArrayList <RankYearBrAmtModel>();
			resultRankYearBrAmtModel = anctDataInfoDao.selectRankYearBrAmt(resultYear[i]);	// 연도별 부점별 합계금액 랭크 조회
			
			JSONObject	obj		= new JSONObject();
			JSONArray	jArray	= new JSONArray();	// 배열이 필요할때
			
			for(int k=0; k < resultRankYearBrAmtModel.size(); k++) {
				JSONObject sObject = new JSONObject(); // 배열 내에 들어갈 json
				sObject.put("brName", resultRankYearBrAmtModel.get(k).get관리점명());		// 관리점명
				sObject.put("brCode", resultRankYearBrAmtModel.get(k).get관리점코드());		// 관리점코드
				sObject.put("sumAmt", resultRankYearBrAmtModel.get(k).get합계());			// 합계(금액-수수료)
				
				jArray.put(sObject);
			}
			
			obj.put("year", year.get(i));
			obj.put("dataList", jArray);
			
			list.add(obj);
			
			resultRankYearBrAmtModel.clear();	// 초기화
		}
		
		String result = list.toString();
		
		return result;
	}

	@Override
	public Map<String, String> selectBrSumAmt(Map<String, String> map) throws Exception {
		
		// 부점 거래금액 합계 조회
		String brName = map.get("brName").toString();
		
		Map<String, String> result = new HashMap<String, String>();
		
		if("판교점".equals(brName)){
			brName = "'판교점', '분당점'";
			BrSumAmtModel brSumAmtModel = anctDataInfoDao.selectBrSumAmt(brName);
			
			result.put("brName", brSumAmtModel.get관리점명());
			result.put("brCode", brSumAmtModel.get관리점코드());
			result.put("sumAmt", brSumAmtModel.get합계());
		}
		else if("분당점".equals(brName)) {
			result.put("code", "404");
			result.put("메세지", "br code not found error");
		}
		
		return result;
	}

} 
