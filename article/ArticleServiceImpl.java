package com.rod.api.article;

import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService{
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository repository;

    private ArticleServiceImpl() {
        repository = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger save(Article o) {
        return null;
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Article o) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
