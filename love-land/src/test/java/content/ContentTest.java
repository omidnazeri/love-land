package content;

import com.love.land.Application;
import com.love.land.domain.dto.CategoryDto;
import com.love.land.domain.dto.ContentDto;
import com.love.land.domain.entity.FileType;
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
public class ContentTest {
    @Autowired
    private ContentService contentService;

    @Test
    public void getContentsTest() {
        List<ContentDto> listMain = new ArrayList<>();

        listMain.add(contentService.addTextContent(null, "Content 1", "Body 1"));
        listMain.add(contentService.addTextContent(null, "Content 2", "Body 2"));
        listMain.add(contentService.addFileContent(null, "Content 3", FileType.PDF, "url 1"));
        listMain.add(contentService.addFileContent(null, "Content 4", FileType.WORD, "url 2"));

        List<ContentDto> list = contentService.getContents(null, 0, 10);
        assertThat(listMain.size()).isEqualTo(list.size());
        assertThat(listMain).isEqualTo(list);
    }

    @Test
    public void getContentsWithCategoryTest() {
        List<ContentDto> listMain = new ArrayList<>();

        CategoryDto parent = contentService.addCategory(null, "Cat 1");

        contentService.addTextContent(null, "Content 1", "Body 1");

        listMain.add(contentService.addTextContent(parent.getId(), "Content 2", "Body 2"));
        listMain.add(contentService.addFileContent(parent.getId(), "Content 3", FileType.PDF, "url 1"));
        listMain.add(contentService.addFileContent(parent.getId(), "Content 4", FileType.WORD, "url 2"));

        List<ContentDto> list = contentService.getContents(parent.getId(), 0, 10);
        assertThat(listMain.size()).isEqualTo(list.size());
        assertThat(listMain).isEqualTo(list);
    }

    @Test
    public void getContentTest() {
        ContentDto contentAdded = contentService.addTextContent(null, "Content add 1", "Body add 1");

        ContentDto content = contentService.getContent(contentAdded.getId());
        assertThat(contentAdded).isEqualTo(content);
    }
}
