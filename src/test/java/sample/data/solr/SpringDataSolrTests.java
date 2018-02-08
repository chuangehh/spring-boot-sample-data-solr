package sample.data.solr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import sample.data.repository.solr.ProductSolrRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataSolrTests {

    @Autowired
    private ProductSolrRepository productSolrRepository;

    /**
     * 查找全部学生并放入solr 中
     */
    @Test
    public void findStudent() {
        productSolrRepository.findByNameStartingWith("");
    }


    /**
     * 查找全部学生并放入solr 中
     */
    @Test
    public void findStudentByDescription() {
    }














    private <T> List<T> listToList(List<? extends Object> list, Class<T> clazz) {
        List<T> voList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return voList;
        } else {
            Iterator i$ = list.iterator();

            while (i$.hasNext()) {
                Object dto = i$.next();
                T vo = dto2vo(dto, clazz);
                if (null != vo) {
                    voList.add(vo);
                }
            }

            return voList;
        }
    }

    public static <T> T dto2vo(Object dto, Class<T> clazz) {
        try {
            Class<?> classType = Class.forName(clazz.getName());
            Object vo = classType.newInstance();
            return (T) conversion(dto, vo);
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        } catch (InstantiationException var5) {
            var5.printStackTrace();
        } catch (IllegalAccessException var6) {
            var6.printStackTrace();
        }

        return null;
    }

    public static Object conversion(Object from, Object to) {
        if (null == from) {
            return null;
        } else {
            try {
                BeanUtils.copyProperties(from, to);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return to;
        }
    }

}
