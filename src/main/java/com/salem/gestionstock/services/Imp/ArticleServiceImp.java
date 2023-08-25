package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.ArticleDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.repository.ArticleRepository;
import com.salem.gestionstock.services.ArticleService;
import com.salem.gestionstock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImp implements ArticleService {
    ArticleRepository articleRepository;

    @Autowired
    ArticleServiceImp(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valide");
            throw new InvalidEntityException("Article n'est pas valide", ErrorCodes.ARTICLE_NOT_FOUND,errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
//        Optional<ArticleDto> articleDto1 = Optional.of(ArticleDto.fromEntity(article.get()));
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(
                () ->  new EntityNotFoundException("Aucun article avec l'id ="+id+"n'a ete trouve",ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if (StringUtils.hasLength(code)){
            log.error("code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(code);
//        Optional<ArticleDto> articleDto1 = Optional.of(ArticleDto.fromEntity(article.get()));
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(
                () ->  new EntityNotFoundException("Aucun article avec le code ="+code+"n'a ete trouve",ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("id is null");
        }
        articleRepository.deleteById(id);
    }
}
