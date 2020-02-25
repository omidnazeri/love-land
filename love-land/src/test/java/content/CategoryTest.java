package content;

import com.love.land.Application;
import com.love.land.domain.dto.CategoryDto;
import com.love.land.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CategoryTest {
    @Autowired
    private ContentService contentService;

    @Test
    public void getCategoriesTest() {
        List<CategoryDto> listMain = new ArrayList<>();

        listMain.add(contentService.addCategory(null, "Cat 1"));
        listMain.add(contentService.addCategory(null, "Cat 2"));
        listMain.add(contentService.addCategory(null, "Cat 3"));

        List<CategoryDto> list = contentService.getCategories(null);
        assertThat(listMain.size()).isEqualTo(list.size());
        assertThat(listMain).isEqualTo(list);
    }

    @Test
    public void getCategoriesWithParentTest() {
        List<CategoryDto> listMain = new ArrayList<>();

        CategoryDto parent = contentService.addCategory(null, "Cat 1");
        listMain.add(contentService.addCategory(parent.getId(), "Cat 2"));
        listMain.add(contentService.addCategory(parent.getId(), "Cat 3"));

        List<CategoryDto> list = contentService.getCategories(parent.getId());
        assertThat(listMain.size()).isEqualTo(list.size());
        assertThat(listMain).isEqualTo(list);
    }


}
