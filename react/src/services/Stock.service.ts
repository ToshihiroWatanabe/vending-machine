import http from "http-common";

class StockService {
  get() {
    return http.get("/stock");
  }

  supply(id: number, increment: number) {
    return http.post("/stock/supply/" + id, increment);
  }
}

export default new StockService();
