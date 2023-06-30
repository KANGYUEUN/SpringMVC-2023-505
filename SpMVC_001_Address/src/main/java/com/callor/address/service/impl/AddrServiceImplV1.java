package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.address.dao.AddrDao;
import com.callor.address.dao.BuyerDao;
import com.callor.address.dao.ScoreDao;
import com.callor.address.models.AddrDto;
import com.callor.address.service.AddrService;

@Service
public class AddrServiceImplV1 implements AddrService {

	/*
	 * < 의존성 주입(Dependency Inject : DI) > 객체를 선언하고, 클래스의 생성자를 통해 객체를 초기화 하는 Java의
	 * 전통적인 객체 생성 코드와 대비되는 Spring Framework Project 의 독특한 기법.
	 * 
	 * 객체를 선언만 하고, 의존성 주입 절차를 수행하면 Spring Container 에 의해 이미 생성되어 준비된 객체를 주입해주는 기능
	 * 
	 * 방법 1. 필드 주입 2. 생성자 주입 3. Setter 주입
	 */
	// 필드 의존성 주입(Field Dependency Inject)
	/*
	 * 필드(클래스 영역) 에 객체를 선언하고 @Autowired 를 부착하는 방법 Spring Project 의 전통적인 코딩에서 가장 많이
	 * 사용되던 방법. 이 방법이 메모리 관리 차원에서 문제가 있다는 보고가 있으면서 사용이 점차 줌. 이 방법은 메모리 누수를 줄이기 위하여
	 * 객체를 private으로 선언 할것을 권장하는 방법이다. 객체를 private으로 선언하면 상속(extends)을 했을시 다시 객체를
	 * 선언해야 한다.
	 * 
	 * 메모리 누수 정도 public > protected > private 순으로 작아진다.
	 */
	@Autowired
	protected BuyerDao buyerDao;

	// 생성자 의존성 주입(Constructor DI)
	/*
	 * 생성자를 통해서 주입될 객체는 final로 선언을 한다. 이 방식의 특징은 한번 주입이 되면 코드가 작동되는 중에 또 다시 주입을 할 수
	 * 없다. ( = 객체 보호가 완전하다.) 객체의 순환참조가 없다. 이 방식은 메모리 누수가 없고, 객체가 보호되며, 순환참조에 의한 코드의
	 * exception 을 막는다.
	 * 
	 * @Autowired를 붙이지 않아도 된다.
	 * 
	 * 단점 : 이 방식을 사용하려면 반드시 생성자 메서드가 필요하다. 코드가 다소 번잡 해 진다. 실수로 생성자 메서드를 만들지 않았을 경우
	 * NullPointer exception 이 발생한다.
	 */
	protected final AddrDao addrDao;

	public AddrServiceImplV1(AddrDao addrDao) {
		this.addrDao = addrDao;
	}

	protected ScoreDao scoreDao;

	// setter의존성 주입(Setter DI)
	/*
	 * 객체를 필드 영역에 선언만 하고 별도의 메서드를 통하여 주입을 하는 방법. 장점 : 누군가 실수로, 임의로 객체를 변경 할 수 있다.
	 * method 가 public으로 서 완정 개방된 상태이기 때문이다.
	 */
	@Autowired
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public List<AddrDto> selectAll() {
		return addrDao.selectAll();
	}

	@Override
	public AddrDto findById(String id) {
		addrDao.findById(id);
		return null;
	}

	@Override
	public String idCheck(String id) {
		AddrDto dto = addrDao.findById(id);
		if (dto == null)
			return "OK";
		else
			return "FAIL";
	}

	@Override
	public List<AddrDto> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddrDto> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AddrDto addrDto) {
		int result = addrDao.insert(addrDto);
		return result;
	}

	@Override
	public int update(AddrDto addrDto) {
		int result = addrDao.update(addrDto);
		return result;
	}

	@Override
	public int delete(AddrDto addrDto) {
		int result = addrDao.delete(addrDto);
		return result;
	}

}
