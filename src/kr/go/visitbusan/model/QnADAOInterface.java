package kr.go.visitbusan.model;

import java.util.ArrayList;

import kr.go.visitbusan.dto.QnA;

public interface QnADAOInterface {
	public ArrayList<QnA> qnAListAll();
	public ArrayList<QnA> qnAListBySid(String askedBy);
	public ArrayList<QnA> qnAListByQIdGroup(String qIdGroup);
	public QnA qnADetail(String qId);
	public void qnaUpdateReadCnt(String qId);
	public int qnAInsertQ(QnA qna);
	public int qnAInsertA(QnA qna);
	public String qIdGenerator();
	public QnA qnAUpdate(String qId);
	public int qnAUpdatePro(QnA qna);
	public int qnADeleteByQIdGroup(String qIdGroup);
	public int qnADeleteOnlyAnswer(String qId);
	public ArrayList<QnA> qnAAnsweredListByQIdGroup(String qIdGroup);
	public ArrayList<QnA> qnAQuestionListByQIdGroup(String qIdGroup);
}