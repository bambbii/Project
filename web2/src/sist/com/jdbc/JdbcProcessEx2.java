package sist.com.jdbc;

import java.util.HashMap;
import java.util.Scanner;

import sist.com.dao.BoardDao;
import sist.com.model.BoardModel;

//View
public class JdbcProcessEx2 {
	private Scanner scan = new Scanner(System.in);

	public void writeProcess() {
		BoardModel boardModel=new BoardModel();
		System.out.println("Title:");
		boardModel.setTitle(scan.next());
		System.out.println("Writer:");
		boardModel.setWriter(scan.next());
		System.out.println("Contents:");
		boardModel.setContents(scan.next());
		System.out.println("Password:");
		boardModel.setpassword(scan.next());
		BoardDao.addBoard(boardModel);
		
	}
	public void listProcess() {
		for(BoardModel i:BoardDao.listBoard(null)) {
			System.out.println(i);
		}
	}
	public void infoProcess() {
		System.out.println("Search No :");
		int no=scan.nextInt();
		BoardModel bm=BoardDao.infoBoard(no);
		System.out.println(bm==null?"NoElement":bm);
	}
	public int searchIndex() {
		System.out.println("SearchTitle: ");
		int no=BoardDao.getNumber(scan.next().trim());
		return no;
	}
	public void infoProcess1() {//제목으로 찾기
		int index=searchIndex();
		BoardDao.updateHit(index);
		if(index==-1) {
			System.out.println("Not Found Element");
			return;
		}
		System.out.println(BoardDao.selectInfo(index));
	}
	public void selectSearch() {
		HashMap<String, Object>map=new HashMap<String,Object>();
		System.out.println("1.Writer 2.Title 3.Contents");
		String key="",value="";
		switch (scan.nextInt()) {
		case 1:
			key="writer";
			break;
		case 2:
			key="Title";
			break;
		case 3:
			key="Contents";
			break;
		}
		System.out.println("SearchContents : ");
		value=scan.next();
		map.put(key, value);
		System.out.println(map);
		System.out.println(BoardDao.listBoard(map));
	}
	public void deleteProcess() {
		int index=searchIndex();
		System.out.println(BoardDao.deleteMember(index)==true?"DeleteSuccess":"NoSuchElement");
	}
	public void boardMenu() {
		while (true) {
			System.out.println("1.글쓰기 2.전체조회 3.상세조회 4.삭제 5.수정 6.검색");
			switch (scan.nextInt()) {
			case 1:
				writeProcess();
				break;
			case 2:
				listProcess();
				break;
			case 3:
				infoProcess1();
				break;
			case 4:
				deleteProcess();
				break;
			case 5:
				//deleteProcess();
				break;
			case 6:
				selectSearch();
				break;
			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		new JdbcProcessEx2().boardMenu();
	}

}
