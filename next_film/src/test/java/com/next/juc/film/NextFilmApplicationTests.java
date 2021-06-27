package com.next.juc.film;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.next.juc.film.dao.entity.TbUser;
import com.next.juc.film.dao.mapper.TbUserMapper;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class NextFilmApplicationTests {

	@Test
    public 	void contextLoads() {
	}

	@Autowired
	private TbUserMapper tbUserMapper;


	/**
	 * 查所有数据
	 */
	@Test
	public  void test1(){
		List<TbUser> userList = tbUserMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	/**
	 * add 操作
	 */
	@Test
	public  void test2(){
		TbUser tbUser = new TbUser();
		tbUser.setName("王");
		tbUser.setAge(27);
		tbUserMapper.insert(tbUser);
	}

	/**
	 * updat 操作
	 */
	@Test
	public  void test3(){
		TbUser tbUser = new TbUser();
		tbUser.setId(3);
		tbUser.setName("张");
		tbUser.setAge(13);
		tbUserMapper.updateById(tbUser);
	}

	/**
	 * 分页查询
	 */

	@Test
	public  void test4(){
		IPage<TbUser>  iPage=new Page<>();
		iPage.setCurrent(1);
		iPage.setSize(2);
		IPage<TbUser> userIPage = tbUserMapper.selectPage(iPage, null);

		userIPage.getRecords().forEach(System.out::println);
	}

}
