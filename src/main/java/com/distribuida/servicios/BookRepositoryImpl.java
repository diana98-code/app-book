package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext(unitName = "puBook")
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createNamedQuery("Book.findAll",Book.class).getResultList();
    }

    @Override
    public Book findById(Integer id) {
        Book b = entityManager.find(Book.class, id);
        return b;
    }

    @Override
    @Transactional
    public void insert(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book book2 = entityManager.find(Book.class, book.getId());
        if (null != book2){
            entityManager.merge(book);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Book b = entityManager.find(Book.class, id);
        if (null != b){
            entityManager.remove(b);
        }
    }
}
