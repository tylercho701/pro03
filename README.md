# 프로젝트 개요

## 프로젝트명 : VISIT BUSAN
## 프로젝트 기간 : 23.05.17 ~ 31
## 프로젝트 참여 : 이상혁, 조교행
## 자바 버전 : JDK 1.8
## 자바 스크립트 버전 : 1.0
## 다이나믹 랩 모듈 : 3.1
## DBMS : MySQL8.0
## 자바 라이브러리 : crypto, json, cos, commons, mail
## FrameWork : BULMA 0.9.4
## 스크립트 플러그인 : jQuery 1 .12 .4
## 스크립트 api : daum 주소 api, json 데이터 처리, iamport 결제 api
## 프로젝트 데이터 처리 패턴 : MVC2 (View -> Controller -> Model -> Controller -> View)
## 프로젝트 주요 기능 : 공지사항 게시판 열람/게시/수정/삭제, 회원 로그인/가입/탈퇴
## 프로젝트 특이사항
  - 회원가입 간 약관 동의를 별도 페이지를 통해 얻도록 구현
  - 회원가입 간 아이디 중복 체크는 json을 통해 별도 팝업 없이 진행
  - 회원가입 간 주소 입력은 daum 주소 api를 통해 입력/전달
  - 회원의 비밀번호 암호화는 AES256으로 처리하여 DB에 적재
  - 공지 사항에 파일 첨부 기능을 구현
  - 공지 사항 내 첨부된 파일은 공지사항 상세를 통해 다운로드 하도록 기능 구현
  - 여행의 종류는 고정하되, 여행 상품은 별도 추가 가능하도록 함
  - 여행 상세 내용으로 제목과 내용, 첨부 이미지를 최대 3장(메인1, 서브2) 게시하도록 구현
  - 여행에 대해 찜하기, 후기 등록 등을 통해 사용자의 여행지 선별 기준으로 제시함
  - 찜한 여행은 여행 등록으로 진행 가능하도록 하며, 여행 등록 후 관리자의 승인 후 여행하도록 함
  - 여행 승인을 얻은 사용자에 한하여 여행 후기를 등록할 수 있도록 함
  - 이용 후기는 사진 1장과 평점으로 평가/게시하도록 처리

# 개념적 설계
![유스케이스](/readme/usecase.jpg "usecase")

# 흐름도
![흐름도1](/readme/01.%ED%9D%90%EB%A6%84%EB%8F%84.png "flow1")
![흐름도2](/readme/03.%ED%9D%90%EB%A6%84%EB%8F%84.png "flow2")

# UI Process
![UI Process](/readme/03.uiProcess.drawio.png "uiprocess")

# 매뉴 설계도
![menu build guide](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C2.JPG "menu")

# 스토리보드
![스토리보드1](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C9.JPG "storyboard1")
![스토리보드2](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C10.JPG "storyboard1")
![스토리보드3](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C11.JPG "storyboard1")
![스토리보드4](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C12.JPG "storyboard4")
![스토리보드5](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C13.JPG "storyboard5")
![스토리보드6](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C14.JPG "storyboard6")
![스토리보드7](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C15.JPG "storyboard7")
![스토리보드8](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C16.JPG "storyboard8")
![스토리보드9](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C17.JPG "storyboard9")
![스토리보드10](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C18.JPG "storyboard10")
![스토리보드11](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C19.JPG "storyboard11")
![스토리보드12](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C20.JPG "storyboard12")
![스토리보드13](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C21.JPG "storyboard13")
![스토리보드14](/readme/04.%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C/%EC%9B%B9%EC%8A%A4%ED%86%A0%EB%A6%AC%EB%B3%B4%EB%93%9C_BUSAN_%EA%B8%B0%ED%9A%8D%EC%84%9C_%EC%B5%9C%EC%A2%85_230524/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C22.JPG "storyboard14")


# 프로젝트 구성
![구성도](/ "구성도")