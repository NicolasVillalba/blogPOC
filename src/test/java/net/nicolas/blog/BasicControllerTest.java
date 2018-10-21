package net.nicolas.blog;

import net.nicolas.blog.controllers.BasicController;
import net.nicolas.blog.dtos.ResponseDTO;
import net.nicolas.blog.services.NamesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicControllerTest {

	@MockBean
	private NamesService nameService;

	@Autowired
	private BasicController basicController;

	@Before
	public void setUp(){
		given(nameService.get()).willReturn("Carl");
	}

	@Test
	public void contextLoads() {
		assertThat(basicController).isNotNull();
		assertThat(basicController.home()).isEqualTo(new ResponseDTO("message", "Carl"));
	}

}
