import http from "http-common";

class SalesHistoryService {
  get() {
    return http.get("/sales-history");
  }
}

export default new SalesHistoryService();
