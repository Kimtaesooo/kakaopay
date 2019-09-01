# kakaopay
# README.md

- 프레임워크 및 개발툴 : sts-3.9.6, MySql, mybatis
- 문제해결 방법
1. 연도별 합계 금액이 가장 많은 고객 추출  
	: 거래일자와 계좌번호를 group by로 묶은 후 합계 금액 출력  
2. 거래가 없는 고객 추출  
	: 모든 계좌정보를 조회 후 left join을 걸어, 거래가 있는 계좌정보를 제외하여 구함(A-B 방식)  
3. 연도벌 관리점별 거래금액 합계 구한 후 큰 순서로 출력  
	: 거래연도와 관리점 코드를 Group by로 묶은 후 합계금액 기준으로 order by하여 조회  
4. 관리점 거래금액 합계 출력  
	: 관리점 명을 받은 후 조건에 맞추어 판교점일경우 분당점을 포함하여 합계 금액을 출력하고  
	  분당점일경우는 조회하지 않고 return  
1,2,3번의 경우 Get방식으로 url에서 데이터를 받아서 처리하였으며  
4번은 Post 방식으로 제이슨으로 데이터를 입력받아 처리 하였습니다.  
Post 방식은 postman을 활용하여 테스트 하였습니다.  
#
#	  
- 빌드 및 실행방법  
	: kakaopay - kakaopayApplication을 실행  
<test url>  
1. "http://localhost:9000/rankYearSumAmt/'2018','2019'"  
2. "http://localhost:9000/noDealCustomer/'2018','2019'"  
3. "http://localhost:9000/rankYearBrAmt/2019, 2018"  
4. "http://localhost:9000/brSumAmt/"  
	: 4번의 경우 postman으로 TEST  
1,2,3,4 모두 Json 데이터를 Map으로 받아 로직 처리 후 다시 map으로 리턴하여 json으로 출력하려 하였으나  
4번밖에 구현하지 못함  