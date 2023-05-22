show databases;
create database busan;
use busan;

set AUTOCOMMIT=true;	-- 자동커밋 설정
show variables like 'autocommit';	-- 자동커밋 설정 확인

-- 회원
create table member(
	id varchar(20) primary key,
    pw varchar(300) not null,
    name varchar(20) not null,
    tel varchar(11),
    email varchar(50),
    addr varchar(100),
    logCnt int default 0
);

-- 공지
create table notice(
	noticeId varchar(8) primary key,
    noticeTitle varchar(200) not null,
    noticeContent varchar(1000) not null,
    writtenAt datetime default current_timestamp,
    writtenBy varchar(20),
    attachment varchar(200),
    readCnt int default 0,
    foreign key(writtenBy) references member(id)
);

-- 카테고리
create table category(	
	cateCode varchar(6) primary key,
    cateGroup varchar(50) not null,
    cateName varchar(50) not null
);

-- 여행
create table visit(	
	visitId varchar(8) primary key,
    visitTitle varchar(200) not null,
    visitCateCode varchar(50),
    visitAddr varchar(100) not null,
    visistImgMain varchar(100),
    visistImgSub1 varchar(100),
    visistImgSub2 varchar(100),
    likeCnt int default 0,
    foreign key(visitCateCode) references category(cateCode)
);

-- 리뷰
create table review(
	reviewId varchar(8) primary key,
    reviewTitle varchar(200) not null,
    reviewContent varchar(1000),
    reviewedAt datetime default current_timestamp,
    reviewedBy varchar(20),
    visitId varchar(20),
    point int default 6,
    img varchar(200),
    likeCnt int default 0,
    foreign key(reviewedBy) references member(id),
    foreign key(visitId) references visit(visitId)
);

-- poke 테이블
create table poke
			(pokeId varchar(8),
             pokedBy varchar(20),
             visitId varchar(8),
             primary key (pokeId),
             constraint foreign key (pokedBy) references member(id),
             constraint foreign key (visitId) references visit(visitId));

-- qna 테이블
create table qna
			(qId varchar(8),
             qTitle varchar(200) not null,
             qContent varchar(1000),
             qType varchar(6) not null,
             qIdGroup varchar(8) not null,
             askedAt datetime default current_timestamp,
             askedBy varchar(20),
             readCnt int default 0,
             primary key (qId),
             constraint foreign key (askedBy) references member(id));
             
-- 여행 등록 테이블
create table registration
			(regId varchar(8),
             registeredBy varchar(20),
             visitId varchar(8),
             regDate datetime not null,
             rStatus varchar(20) default '여행신청',
             primary key (regId),
             constraint foreign key (registeredBy) references member(id),
             constraint foreign key (visitId) references visit(visitId));
             
select noticeId from (select noticeId from notice order by noticeId desc) where rownum = 1;