import http from "http-common";

class StockService {
  get() {
    return http.get("/stock");
  }
}

export default new StockService();
