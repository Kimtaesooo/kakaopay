package com.kakaopay.model;

public class RankYearBrAmtModel {
	private String	거래일자;	// 연도
	private String	관리점명;	// 관리점명
	private String	관리점코드;	// 관리점코드
	private String	합계;		// 합계(금액 - 수수료)
	
	
	public String get거래일자() {
		return 거래일자;
	}
	public void set거래일자(String 거래일자) {
		this.거래일자 = 거래일자;
	}
	public String get관리점명() {
		return 관리점명;
	}
	public void set관리점명(String 관리점명) {
		this.관리점명 = 관리점명;
	}
	public String get관리점코드() {
		return 관리점코드;
	}
	public void set관리점코드(String 관리점코드) {
		this.관리점코드 = 관리점코드;
	}
	public String get합계() {
		return 합계;
	}
	public void set합계(String 합계) {
		this.합계 = 합계;
	}
}
