import http from "http-common";

class CoinBoxService {
  get() {
    return http.get("/product");
  }
}

export default new CoinBoxService();
