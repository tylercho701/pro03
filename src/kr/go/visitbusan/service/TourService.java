package kr.go.jeju.service;

import java.util.ArrayList;

import kr.go.jeju.dto.PicDTO;
import kr.go.jeju.dto.TourDTO;
import kr.go.jeju.model.TourDAO;
import kr.go.jeju.model.TourDAOMysql;

public class TourService {
	TourDAO dao = new TourDAOMysql();
	
	public int loadLastNo(){	//마지막 번호 로딩
		int cnt = dao.loadLastNo();
		return cnt;
	}
	public int fileUpload(PicDTO dto){	//파일 업로드
		int cnt = dao.fileUpload(dto);
		return cnt;		
	}
	public ArrayList<PicDTO> JSONPicList(String tourno) {	//json으로 이미지 불러오기
		ArrayList<PicDTO> picList = dao.JSONPicList(tourno);
		return picList;
	}
	public PicDTO getPic(String tourno){	//이미지 불러오기
		PicDTO dto = dao.getPic(tourno);
		return dto;
	}
	public int addTour(TourDTO dto){	//문화관광 추가
		int cnt = dao.addTour(dto);
		return cnt;
	}
	public ArrayList<TourDTO> getTourList(){	//문화관광 전체 목록
		ArrayList<TourDTO> tourList = dao.getTourList();
		return tourList;
	}
	public TourDTO getTour(int no){	////해당 순번을 이용한 상세보기
		TourDTO dto = dao.getTour(no);
		return dto;
	}
	public int delTour(int no){	//문화관광 정보 삭제
		int cnt = dao.delTour(no);
		return cnt;
	}
	public int modifyTour(TourDTO dto){	//문화관광 수정
		int cnt = dao.modifyTour(dto);
		return cnt;
	}
	public ArrayList<TourDTO> JSONPlaceList(){	//json 요청시 카테고리 목록 반환
		ArrayList<TourDTO> tourList = dao.JSONPlaceList();
		return tourList;
	}
	public ArrayList<TourDTO> getTourCateList(String cate){	//요청한 대분류 카테고리에 속한 문화관광 카테고리 반환
		ArrayList<TourDTO> tourList = dao.getTourSerachList(cate);
		return tourList;
	}
	public ArrayList<TourDTO> getTourSerachList(String keyword){ //검색어에 속한 문화관광 카테고리 반환
		ArrayList<TourDTO> tourList = dao.getTourSerachList(keyword);
		return tourList;
	}
	public ArrayList<TourDTO> getTourSerachList(String comment2, String keyword){ //관광지 설명에 속한 문화관광 카테고리 반환
		ArrayList<TourDTO> tourList = dao.getTourSerachList(comment2, keyword);
		return tourList;		
	}
	public ArrayList<TourDTO> getTourSerachList(String place, String comment2, String keyword){ //장소 이름 및 설명에 속한 문화관광 카테고리 반환
		ArrayList<TourDTO> tourList = dao.getTourSerachList(place, comment2, keyword);
		return tourList;
	}
	public TourDTO getPlace(String tourno){	//해당 문화관광코드를 이용한 상세보기
		TourDTO dto = dao.getPlace(tourno);
		return dto;
	}
}