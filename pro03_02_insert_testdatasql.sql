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


-- Regi 계정 더미
select * from registration;
insert into registration values ('000001', 'tyler', '1', '2023-06-03', '여행완료');
insert into registration values ('000002', 'tyler', '2', '2023-06-06', '여행완료');
insert into registration values ('000003', 'tyler', '3', '2023-06-13', '여행완료');
insert into registration values ('000004', 'faker', '1', '2023-06-16', '여행완료');
insert into registration values ('000005', 'faker', '2', '2023-06-30', '여행완료');
insert into registration values ('000006', 'faker', '3', '2023-07-03', '여행완료');
insert into registration values ('000007', 'narae', '1', '2023-08-03', '여행완료');
insert into registration values ('000008', 'narae', '2', '2023-09-03', '여행완료');
insert into registration values ('000009', 'narae', '3', '2023-10-03', '여행완료');
insert into registration values ('000010', 'seonjeong', '1', '2023-06-23', '여행완료');
insert into registration values ('000011', 'seonjeong', '2', '2023-06-09', '여행완료');
insert into registration values ('000012', 'seonjeong', '3', '2023-06-28', '여행완료');
insert into registration values ('000013', 'binbin', '1', '2023-06-03', '여행완료');
insert into registration values ('000014', 'binbin', '1', '2023-06-03', '여행완료');
insert into registration values ('000015', 'binbin', '1', '2023-06-03', '여행완료');

-- review 더미글
select * from review;
insert into review values ('000001', '리뷰 테스트 1', '리뷰 테스트 글 1번 입니다.', default, 'tyler', '1', '000001',  5, '/1.jpg', default);
insert into review values ('000002', '리뷰 테스트 2', '리뷰 테스트 글 2번 입니다.', default, 'tyler', '2', '000002', 4, '/2.jpg', default);
insert into review values ('000003', '리뷰 테스트 3', '리뷰 테스트 글 3번 입니다.', default, 'tyler', '3', '000003', 5, '/3.jpg', default);
insert into review values ('000004', '리뷰 테스트 4', '리뷰 테스트 글 4번 입니다.', default, 'faker', '1', '000004', 5, '/4.jpg', default);
insert into review values ('000005', '리뷰 테스트 5', '리뷰 테스트 글 5번 입니다.', default, 'faker', '2', '000005', 3, '/5.jpg', default);
insert into review values ('000006', '리뷰 테스트 6', '리뷰 테스트 글 6번 입니다.', default, 'faker', '3', '000006', 5, '/6.jpg', default);
insert into review values ('000007', '리뷰 테스트 7', '리뷰 테스트 글 7번 입니다.', default, 'narae', '1', '000007', 5, '/7.jpg', default);
insert into review values ('000008', '리뷰 테스트 8', '리뷰 테스트 글 8번 입니다.', default, 'narae', '2', '000008', 4, '/8.jpg', default);
insert into review values ('000009', '리뷰 테스트 9', '리뷰 테스트 글 9번 입니다.', default, 'narae', '3', '000009', 5, '/9.jpg', default);
insert into review values ('000010', '리뷰 테스트 10', '리뷰 테스트 글 10번 입니다.', default, 'seonjeong', '1', '000010', 5, '/10.jpg', default);
insert into review values ('000011', '리뷰 테스트 11', '리뷰 테스트 글 11번 입니다.', default, 'seonjeong', '2', '000011', 2, '/11.jpg', default);
insert into review values ('000012', '리뷰 테스트 12', '리뷰 테스트 글 12번 입니다.', default, 'seonjeong', '3', '000012', 5, '/12.jpg', default);
insert into review values ('000013', '리뷰 테스트 13', '리뷰 테스트 글 13번 입니다.', default, 'binbin', '1', '000013', 1, '/13.jpg', default);
insert into review values ('000014', '리뷰 테스트 14', '리뷰 테스트 글 14번 입니다.', default, 'binbin', '2', '000014', 5, '/14.jpg', default);
insert into review values ('000015', '리뷰 테스트 15', '리뷰 테스트 글 15번 입니다.', default, 'binbin', '3', '000015', 5, '/15.jpg', default);


select * from member;
select * from review;
select * from registration;
select * from qna;
select * from poke;
select * from notice;
select * from category;
select * from visit;
