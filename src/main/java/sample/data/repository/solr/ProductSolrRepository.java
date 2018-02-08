/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.repository.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;
import sample.data.entity.solr.ProductSolr;

import java.util.Collection;

/**
 * 商品solr 仓库
 *
 * @author liangchuanchuan
 */
public interface ProductSolrRepository extends SolrCrudRepository<ProductSolr, String> {

    /**
     * 根据商品名字或描述查找
     *
     * @param name
     * @param description
     * @param page
     * @return
     */
    Page<ProductSolr> findByNameOrDescription(String name, String description, Pageable page);

    /**
     * 根据名字高亮查找
     *
     * @param name
     * @param page
     * @return
     */
    @Highlight(prefix = "<span style='color:red'>", postfix = "</span>")
    HighlightPage<ProductSolr> findByNameIn(Collection<String> name, Pageable page);

}
