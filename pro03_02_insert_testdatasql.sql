show databases;
create database busan;
use busan;

set AUTOCOMMIT=true;	-- 자동커밋 설정
show variables like 'autocommit';	-- 자동커밋 설정 확인


-- Member 계정 더미
insert into member values ('admin', '1234', '관리자', '01012341234', 'admin@naver.com', '경기도 고양시 일산서구', default);
insert into member values ('tyler', '1234', '조교행', '01012341234', 'tyler@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('faker', '1234', '이상혁', '01012341234', 'faker@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('narae', '1234', '김나래', '01012341234', 'narae@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('jungwoo', '1234', '박정우', '01012341234', 'jungwoo@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('seonjeong', '1234', '최선정', '01012341234', 'seonjeong@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('jiny', '1234', '유지니', '01012341234', 'jiny@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('bklove', '1234', '정봉길', '01012341234', 'bklove@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('binbin', '1234', '이성빈', '01012341234', 'binbin@naver.com', '경기도 고양시 일산동구', default);
insert into member values ('criminalcity', '1234', '마동석', '01012341234', 'criminalcity@naver.com', '경기도 화성시 중구', default);


-- Notice 계정 더미
insert into notice values ('000001', '테스트 더미글 1', '테스트 더미글 1번 입니다.', default, 'admin', '1.jpg', default);
insert into notice values ('000002', '테스트 더미글 2', '테스트 더미글 2번 입니다.', default, 'admin', '2.jpg', default);
insert into notice values ('000003', '테스트 더미글 3', '테스트 더미글 3번 입니다.', default, 'admin', '3.jpg', default);
insert into notice values ('000004', '테스트 더미글 4', '테스트 더미글 4번 입니다.', default, 'admin', '4.jpg', default);
insert into notice values ('000005', '테스트 더미글 5', '테스트 더미글 5번 입니다.', default, 'admin', '5.jpg', default);
insert into notice values ('000006', '테스트 더미글 6', '테스트 더미글 6번 입니다.', default, 'admin', '6.jpg', default);
insert into notice values ('000007', '테스트 더미글 7', '테스트 더미글 7번 입니다.', default, 'admin', '7.jpg', default);
insert into notice values ('000008', '테스트 더미글 8', '테스트 더미글 8번 입니다.', default, 'admin', '8.jpg', default);
insert into notice values ('000009', '테스트 더미글 9', '테스트 더미글 9번 입니다.', default, 'admin', '9.jpg', default);
insert into notice values ('000010', '테스트 더미글 10', '테스트 더미글 10번 입니다.', default, 'admin', '10.jpg', default);
insert into notice values ('000011', '테스트 더미글 11', '테스트 더미글 11번 입니다.', default, 'admin', '11.jpg', default);
insert into notice values ('000012', '테스트 더미글 12', '테스트 더미글 12번 입니다.', default, 'admin', '12.jpg', default);
insert into notice values ('000013', '테스트 더미글 13', '테스트 더미글 13번 입니다.', default, 'admin', '13.jpg', default);
insert into notice values ('000014', '테스트 더미글 14', '테스트 더미글 14번 입니다.', default, 'admin', '14.jpg', default);
insert into notice values ('000015', '테스트 더미글 15', '테스트 더미글 15번 입니다.', default, 'admin', '15.jpg', default);


-- Member 계정 더미