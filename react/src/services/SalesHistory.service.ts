import http from "http-common";

class SalesHistoryService {
  get() {
    return http.get("/sales-history");
  }
  deleteAll() {
    return http.delete("/sales-history/delete-all");
  }
}

export default new SalesHistoryService();
