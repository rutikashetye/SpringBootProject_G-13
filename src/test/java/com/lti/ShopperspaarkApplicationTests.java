package com.lti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.UserDao;
import com.lti.entity.Product;

@SpringBootTest
class ShopperspaarkApplicationTests {

	@Autowired
	UserDao Dao;
//	@Test
//	void addOrUpdateAlbum()
//	{
//		Album album = new Album();
//		album.setAlbumName("KateBush");
//		album.setLabel("Running up that hill");
//		album.setNoOfSongs(2);
//		album.setReleaseDate(LocalDate.of(1856,10,12));
//		
//		Album saved = Dao.addOrUpdateAlbum(album);
//		assertNotNull(saved);
//		
//	}
//	@Test
//	void AddOrUpdateProduct()
//	{
//		Product p = new Product();
//		p.se
//	}

}
