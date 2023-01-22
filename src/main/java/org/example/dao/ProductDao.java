package org.example.dao;

import lombok.NoArgsConstructor;
import org.example.dao.mapper.ProductMapper;
import org.example.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDao implements BaseDao<Product> {


    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject("select * from product where id = ?", new Object[]{id},new ProductMapper());
    }

    @Override
    public List<Product> getList() {
        return jdbcTemplate.query("select * from product", new ProductMapper());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("delete from product where id = ?", new Object[]{id}) > 0;
    }


    @Override
    public boolean add(Product product) {
        return jdbcTemplate.update(
                "insert into product(name, product_url, price, quantity, category_id, info) values (?,?,?,?,?,?)",
                new Object[]{product.getName(), product.getProductUrl(), product.getPrice(), product.getQuantity(), product.getCategoryId(), product.getInfo()}
        ) > 0;
    }
    public boolean update(Product product){
        return jdbcTemplate.update(
                "update  product set name = ?,   price = ?, quantity = ?, info = ? where id = ?",
                new Object[]{product.getName(),product.getPrice(), product.getQuantity(),product.getInfo(),product.getId()}
        )>0;
    }


}
