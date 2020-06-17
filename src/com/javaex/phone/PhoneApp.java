package com.javaex.phone;

import java.util.List;

public class PhoneApp {

	public static void main(String[] args) {
		
		PhoneDao phoneDao = new PhoneDao();
		
		//등록
		//PersonVo vo01 = new PersonVo("이효리", "010-1111-1111", "02-1111-1111") ;
		phoneDao.phoneInsert("이효리", "010-1111-1111", "02-1111-1111");
		phoneDao.phoneInsert("정우성", "010-2222-2222", "02-2222-2222");
		phoneDao.phoneInsert("유재석", "010-3333-3333", "02-3333-3333");
		
		//수정
		phoneDao.phoneUpdate(2, "좡우성", "010-2222-2222", "02-2222-2222");
		
		//삭제
		phoneDao.phoneDelete(3);
		
		//리스트
		List<PersonVo> personList = phoneDao.getPersonList();
		
		System.out.println("=====================");
		for(PersonVo vo: personList) {
			System.out.println(vo.getpersonId() + "," + vo.getName() + "," + vo.getHp() + "," + vo.getCompany());
		}
		System.out.println("=======================");
		
		//검색
		
	}

}
