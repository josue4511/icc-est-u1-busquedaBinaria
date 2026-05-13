package controllers;

import models.Product;

public class BusquedaBinaria {

    public int findProductIndexByStock(Product[] products, int clave) {

        sortProductsByStock(products);

        int bajo = 0;
        int alto = products.length - 1;

        while (bajo <= alto) {

            int centro = (bajo + alto) / 2;

            if (products[centro].getStock() == clave) {

                return centro;

            } else if (products[centro].getStock() > clave) {

                alto = centro - 1;

            } else {

                bajo = centro + 1;
            }
        }

        return -1;
    }

    public Product findProductByStock(Product[] products, int index) {

        if (index >= 0 && index < products.length) {
            return products[index];
        }

        return null;
    }

    private void sortProductsByStock(Product[] products) {

        for (int i = 0; i < products.length - 1; i++) {

            for (int j = 0; j < products.length - 1 - i; j++) {

                if (products[j].getStock() > products[j + 1].getStock()) {

                    Product aux = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = aux;
                }
            }
        }
    }
}