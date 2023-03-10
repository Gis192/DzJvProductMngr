package ru.netology.ProductManager;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void add ( Product product){
       Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
            //или
            //System.arraycopy(items, 0, tmp, 0, products.length);
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
       for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
               copyToIndex++;
            }
        }
        products = tmp;
    }
    public Product[] getProducts() {
        return products;
    }
}
