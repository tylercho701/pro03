show databases;
use busan;

show tables;

-- cate
INSERT INTO CATEGORY VALUES('0101', '여행', '테마여행');
INSERT INTO CATEGORY VALUES('0102', '여행', '테마여행');
INSERT INTO CATEGORY VALUES('0201', '공연', '야구');
INSERT INTO CATEGORY VALUES('0202', '공연', '국제영화제');
INSERT INTO CATEGORY VALUES('0301', '축제', '봄');
INSERT INTO CATEGORY VALUES('0302', '축제', '여름');
INSERT INTO CATEGORY VALUES('0303', '축제', '가을');
INSERT INTO CATEGORY VALUES('0304', '축제', '겨울');

SELECT * FROM CATEGORY;

-- VISIT
INSERT INTO VISIT VALUES('1', '세계적인 관광도시 부산 5대 매력', '0101', 'SAMPLE주소', 'change1', 'change1', 'change1', default);
INSERT INTO VISIT VALUES('2', '빠르게 만나는 부산 봄 여행 추천 10', '0101', 'SAMPLE주소', 'change1', 'change1', 'change1', default);
INSERT INTO VISIT VALUES('3', '일러스트로 만나는 \'뉴진스 코드 in 부산\' 추천여행', '0101', 'SAMPLE주소', 'change1', 'change1', 'change1', default);

select * from visit;

SELECT VISITID FROM VISIT ORDER BY VISITID DESC LIMIT 1;

-- REGISTRATION
INSERT INTO REGISTRATION VALUES();

-- POKE
INSERT INTO POKE VALUES();