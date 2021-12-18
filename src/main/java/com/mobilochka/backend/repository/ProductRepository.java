package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.*;


@Repository
public class ProductRepository {
    private final ProductJpaRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    public ProductRepository(ProductJpaRepository repository) {
        this.repository = repository;
    }


    public void save(Product product) {
        repository.save(product);
    }

    public Product findByArticle(String article) {
        return repository.findByArticle(article);
    }

    public Page<Product> findAll(int page, int size) {
        Pageable sortedByName = PageRequest.of(page, size, Sort.by("name"));
        return repository.findAll(sortedByName);
    }


    public Product findByBarcode(String barcode) {
        return repository.findByBarcode(barcode);
    }

    public List<Product> findAllNew() {
        Pageable sortedByArticle = PageRequest.of(0, 12, Sort.by("id").descending());
        return repository.findAll(sortedByArticle).getContent();
    }

    public List<Product> findAllNewSmartfon() {
        return entityManager.createQuery("SELECT p FROM Product p  where p.category.name =: name ORDER BY p.id desc ",
                Product.class).setParameter("name", "Смартфоны").setMaxResults(12).getResultList();
    }

    public void lodImageParse(Product product) throws IOException {
        try {
            String url = "HTTP://allo.ua/ua/catalogsearch/result/?q=" + product.getArticle();
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
                    .timeout(8000)
                    .referrer("https://www.google.com/")
                    .get();
            Elements classPro = document.body().getElementsByClass("products-layout__item");
            for (Element e : classPro) {
                if (e.getElementsByClass("product-sku__value").text().equals(product.getArticle())) {
                    url = Objects.requireNonNull(e.getElementsByAttribute("href").first()).attr("href");
                }
            }
            document = Jsoup.connect(url).get();
            classPro = document.body().getElementsByClass("main-gallery__picture main-gallery__picture--image");
            HashSet<String> images = new HashSet<>();
            for (Element e : classPro) {
                if (e.getElementsByAttribute("src").attr("src").equals("")) {
                    images.add(e.getElementsByAttribute("data-src").attr("data-src"));
                } else {
                    images.add(e.getElementsByAttribute("src").attr("src"));
                }
            }
            product.setImage((images));

        } catch (Exception e) {

            System.out.printf("%s %s", e, product.getArticle());
        }

    }
}


