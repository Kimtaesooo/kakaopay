package com.kakaopay.model;

public class RankYearSumAmtModel {
	private String	거래일자;	// 연도
	private String	계좌명;	// 계좌명
	private String	계좌번호;	// 계좌번호
	private String	합계;		// 합계(금액 - 수수료)
	
	public String get거래일자() {
		return 거래일자;
	}
	public void set거래일자(String 거래일자) {
		this.거래일자 = 거래일자;
	}
	public String get계좌명() {
		return 계좌명;
	}
	public void set계좌명(String 계좌명) {
		this.계좌명 = 계좌명;
	}
	public String get계좌번호() {
		return 계좌번호;
	}
	public void set계좌번호(String 계좌번호) {
		this.계좌번호 = 계좌번호;
	}
	public String get합계() {
		return 합계;
	}
	public void set합계(String 합계) {
		this.합계 = 합계;
	}
	
}
