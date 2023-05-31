package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Poke;
import kr.go.visitbusan.model.PokeDAO;
import kr.go.visitbusan.vo.PokeVO;

public class PokeService {
	PokeDAO pdao = new PokeDAO();
	
	// 계정별 찜한 목록 불러오기
	public ArrayList<PokeVO> PokeVOListByMemberId(String pokedBy){
		ArrayList<PokeVO> pokeVOList = pdao.PokeVOListByMemberId(pokedBy);
		return pokeVOList;
	}
	
	public Poke CheckPoke(Poke poke){
		Poke nPoke = pdao.CheckPoke(poke);
		return nPoke;
	}
	
	// 찜하기
	public String InsertPoke(Poke poke){
		String visitId = pdao.InsertPoke(poke);
		return visitId;
	}
	
	// 찜한 visit 삭제
	public int DeletePoke(String pokeId){
		int i = pdao.DeletePoke(pokeId);
		return i;
	}
	
	// 한 visit이 찜 당한 횟수
	public int CountPokeListByVisitId(String visitId){
		int i = pdao.CountPokeListByVisitId(visitId);
		return i;
	}
}