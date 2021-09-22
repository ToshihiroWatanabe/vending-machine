import http from "http-common";

class ProductService {
  get() {
    return http.get("/product");
  }
}

export default new ProductService();
