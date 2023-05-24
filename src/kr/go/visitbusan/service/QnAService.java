package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.QnA;
import kr.go.visitbusan.model.QnADAO;
import kr.go.visitbusan.model.QnADAOInterface;

public class QnAService {
	QnADAOInterface dao = new QnADAO();
	
	public ArrayList<QnA> qnAListAll(){
		ArrayList<QnA> qList = dao.qnAListAll();
		return qList;
	}
	public ArrayList<QnA> qnAListByQIdGroup(String qIdGroup){
		ArrayList<QnA> qList = dao.qnAListByQIdGroup(qIdGroup);
		return qList;
	}
	public QnA qnADetail(String qId){
		QnA qna = dao.qnADetail(qId);
		return qna;
	}
	public void qnaUpdateReadCnt(String qId){
		dao.qnaUpdateReadCnt(qId);
	}
	public int qnAInsertQ(QnA qna){
		int cnt = dao.qnAInsertQ(qna);
		return cnt;
	}
	public int qnAInsertA(QnA qna){
		int cnt = qnAInsertA(qna);
		return cnt;
	}
	public String qIdGenerator(){
		String qId = dao.qIdGenerator();
		return qId;
	}
	public QnA qnAUpdate(String qId){
		QnA qna = dao.qnAUpdate(qId);
		return qna;
	}
	public int qnAUpdatePro(QnA qna){
		int cnt = qnAUpdatePro(qna);
		return cnt;
	}
	public int qnADeleteByQIdGroup(String qIdGroup){
		int cnt = qnADeleteByQIdGroup(qIdGroup);
		return cnt;
	}
	public int qnADeleteOnlyAnswer(String qId){
		int cnt = qnADeleteOnlyAnswer(qId);
		return cnt;
	}
}
